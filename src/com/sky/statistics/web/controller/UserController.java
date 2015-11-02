package com.sky.statistics.web.controller;

import com.sky.statistics.core.annotation.SystemControllerLog;
import com.sky.statistics.core.constant.SysConst;
import com.sky.statistics.core.feature.encoder.Md5PwdEncoder;
import com.sky.statistics.core.feature.orm.mybatis.Page;
import com.sky.statistics.core.util.ContextUtil;
import com.sky.statistics.core.util.StringUtil;
import com.sky.statistics.web.model.User;
import com.sky.statistics.web.model.UserExample;
import com.sky.statistics.web.model.UserLog;
import com.sky.statistics.web.service.UserLogService;
import com.sky.statistics.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.task.TaskExecutor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.*;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private UserLogService userLogService;
    @Autowired
    @Qualifier("logTaskExecutor")
    private TaskExecutor updateTaskExecutor;

    /**
     * 查询所有用户
     * */
    @RequestMapping(value="/list")
    public ModelAndView selectByPram(HttpServletRequest request){
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
        Page<User> page = new Page<User>(pageNo, pageSize);
        UserExample example = new UserExample();
        example.createCriteria().andIdGreaterThan(0L);
        final List<User> users = userService.selectByExampleAndPage(page, example);
        for (User user : users) {
            System.err.println(user);
        }
        ModelAndView mav=new ModelAndView("list");
        mav.addObject("user",users);
        return mav;
    }

    /**
     * 注册
     * //@RequestBody User 接受json格式的字符串自动转成bean
     * */
    @RequestMapping(value="/register",method= RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Map<String,Object> insertUser(@RequestBody @Valid User us,BindingResult result, HttpServletRequest request)
    {
        //返回对象集合
        Map<String,Object> map = new HashMap<String,Object>();
        //返回消息集合
        List<String> msgList = new ArrayList<String>();
        //用于返回的user
        User userForReturn = null;

        // 如果用户提交了序列号则只记录日志
        String sn = us.getSerialNumber();
        String uuid = us.getUuid();

        //根据提交序列号判断登录或注册，序列号为空视为注册请求
        if( StringUtil.isEmpty(sn)){
            //验证参数提交参数格式
            if (result.hasErrors()) {
                List<ObjectError> errorList = result.getAllErrors();
                List<String> errMsgList = new ArrayList<String>();
                for(ObjectError error : errorList){
                    errMsgList.add(error.getDefaultMessage());
                }

                map.put(SysConst.RETURN_CODE, SysConst.OP_FAILD);
                map.put(SysConst.RETURN_MSG, errMsgList);
                map.put(SysConst.RETURN_DATA, null);
                return map;
            }

//            int countUser = countUser(uuid);
            int countUser = 0;
            if(countUser>0){
                //账号存在
                msgList.add("此序列号已注册]");
                map.put(SysConst.RETURN_CODE, SysConst.OP_FAILD);
                map.put(SysConst.RETURN_MSG, msgList);
                map.put(SysConst.RETURN_DATA, null);
                return map;
            }else {
                //注册
                String ip= ContextUtil.getClientIp();
                String[] addr = ContextUtil.getAddressByIP(ip);//通过request获取IP再获取IP所在地
                //user初始化
                Date now = new Date();
                //获取随机码执行盐渍算法
                String salt= StringUtil.getRandomString(9);
                us.setPassword(new Md5PwdEncoder().encodePassword(us.getPassword(),salt));
                //盐渍生成序列号
                String serialNumber = new Md5PwdEncoder().encodePassword(uuid, salt);
                us.setSerialNumber(serialNumber);
                //保存盐渍随机码
                us.setSalt(salt);
                us.setIP(ip);
                us.setAddress(StringUtil.isEmpty(us.getAddress()) ? StringUtil.joinIgnoreEmptyStr(",",addr) : us.getAddress());
                us.setLastLoginTime(now);
                us.setCreator(us.getUserName());
                us.setCreateTime(now);
                //持久化
                userService.insert(us);

                userForReturn = us;
                userForReturn.setSalt("");//不返回salt

                //将用户信息写入session
                ContextUtil.setContextLoginUser( us);
            }
        }else{
            //验证登录
            List<User> userList = checkUser(uuid, sn);
            if(userList == null || userList.size() == 0){
                msgList.add("机器码与序列号有误");
                map.put(SysConst.RETURN_CODE, SysConst.OP_FAILD);
                map.put(SysConst.RETURN_MSG, msgList);
                map.put(SysConst.RETURN_DATA, null);
                return map;
            }else{
                us = userList.get(0);
                userForReturn = us;
                userForReturn.setSalt("");//不返回salt
            }

        }

        //开启线程添加日志
        log(us, "用户登录", request);

        //开启线程修改登录信息
        //updateLoginInfo(us);

        msgList.add("登录成功");
        map.put(SysConst.RETURN_CODE, SysConst.OP_SUCCESS);//操作成功
        map.put(SysConst.RETURN_MSG, msgList);
        map.put(SysConst.RETURN_DATA, userForReturn);//用户信息

        return map;
    }

    /**
     * 查询用户是否存在
     * @param uuid
     * @return
     */
    private int countUser(String uuid){

        //查询
        UserExample example = new UserExample();
        example.createCriteria().andUuidEqualTo(uuid);
        return userService.countByExample(example);
    }
    /**
     * 查询用户机器码与序列号是否一致
     * @param uuid
     * @param sn
     * @return
     */
    private List<User> checkUser(String uuid, String sn){

        //查询
        Page<User> page = new Page<User>(1, 1);
        UserExample example = new UserExample();
        example.createCriteria().andUuidEqualTo(uuid).andSNEqualTo(sn);
        return userService.selectByExampleAndPage(page, example);
    }

    /**
     * 记录日志
     * @param user
     * @param logInfo
     * @return
     */
    private void log(final User user,final String logInfo, final HttpServletRequest request){
        System.out.println("准备插入日志");
        //开启线程
        updateTaskExecutor.execute(new Runnable() {
            public void run() {
                try {
                    //TODO 两个insert操作之间的事务提交会有30秒延迟，为什么？
                    System.out.println("正在插入日志");
                    String ip = ContextUtil.getIpAddr(request);
                    String[] addr = ContextUtil.getAddressByIP(ip);//通过request获取IP再获取IP所在地
                    UserLog usl = new UserLog();

                    usl.setUser(user);
                    usl.setLogType(0);
                    usl.setLogInfo(logInfo);
                    usl.setLogTime(new Date());
                    usl.setIP(ip);
                    usl.setArea(StringUtil.joinIgnoreEmptyStr(",", addr));
                    usl.setMethodName(this.getClass().getSimpleName());
                    usl.setModelName(this.getClass().getName());

                    int i = userLogService.insert(usl);
                }catch (Exception e){
                    System.out.println("插入日志异常："+e.getMessage());
                }
            }
        });

    }

    /**
     * 更改用户登录信息
     * @param user
     * @return
     */
    private void updateLoginInfo(final User user){
        System.out.println("准备修改登录时间");
        //开启线程
        updateTaskExecutor.execute(new Runnable() {
            public void run() {
                try {
                    System.out.println("正在修改登录时间");
                    user.setLastLoginTime(new Date());
                    UserExample example = new UserExample();
                    example.createCriteria().andIdEqualTo(user.getId());
                    userService.updateByExample(user, example);
                }catch (Exception e){
                    System.out.println("修改登录时间异常："+e.getMessage());
                }
            }
        });

    }

    /**
     * 登录
     * */
    @RequestMapping(value="/login",method= RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> login( User us, HttpServletRequest request)
    {
        //返回操作状态码
        Map<String,Object> map = new HashMap<String,Object>();

//        if (result.hasErrors()) {
//            map.put("code", SysConst.OP_FAILD);
//            return map;
//        }

        //查询
        User user = userService.authentication(us);

        if(user!=null && user.getId()>0){
            map.put("code", SysConst.OP_SUCCESS);//操作成功
            map.put("data", user);
            //将用户信息写入session
            ContextUtil.setContextLoginUser(user);
        }else{
            map.put("code", SysConst.OP_FAILD);//操作失败
            //throw new UserException("登录失败");
        }


        return map;
    }

    /**
     * 查询用户信息
     * */
    @RequestMapping(value="/select",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> selectUserInfo(User us)
    {
        //返回操作状态码
        Map<String,Object> map = new HashMap<String,Object>();
        //TODO 测试跳转

        //查询
        Page<User> page = new Page<User>(1, 1);
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(us.getId());
        final List<User> users = userService.selectByExampleAndPage(page, example);

        if(users.size()>0){
            map.put("code", SysConst.OP_SUCCESS);//操作成功
            map.put("data", users);//操作成功
        }else{
            map.put("code", SysConst.OP_FAILD);//操作失败
        }


        return map;
    }

    /**
     * 修改用户信息
     * */
    @RequestMapping(value="/update",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> updateUserInfo(User us)
    {
        //返回操作状态码
        Map<String,Object> map = new HashMap<String,Object>();

        int i = userService.update(us);
        System.out.println(i);
        if(i>0){
            map.put("code", SysConst.OP_SUCCESS);//操作成功

        }else
            map.put("code", SysConst.OP_FAILD);//操作失败
        map.put("i", i);
        return map;
    }

    /**
     * 删除用户信息
     * */
    @RequestMapping(value="/delete",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> deleteUserInfo(@RequestParam Long id)
    {
        //返回操作状态码
        Map<String,Object> map = new HashMap<String,Object>();

        int i = userService.delete(id);
        System.out.println(i);
        if(i>0){
            map.put("code", SysConst.OP_SUCCESS);//操作成功

        }else
            map.put("code", SysConst.OP_FAILD);//操作失败
        map.put("i", i);
        return map;
    }

    /**
     * 测试返回json
     * @param id
     * @return
     */
    @RequestMapping(value="/json",method= RequestMethod.POST)
    @ResponseBody//将内容或对象作为 HTTP 响应正文返回，使用@ResponseBody将会跳过视图处理部分，而是调用适合HttpMessageConverter，将返回值写入输出流。
    public Map<String,Object> testJson(@RequestParam Long id){

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", id);
        System.out.println("操作状态："+id);
        return map;
    }

    @RequestMapping("/test")
    @SystemControllerLog(description = "测试跳转页面到test")
    public String test(HttpServletRequest request,HttpServletResponse response){
        //返回字符串指向jsp页面名称
        return "test";
    }
}
