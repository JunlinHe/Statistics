package com.sky.statistics.web.controller;

import com.sky.statistics.core.annotation.SystemControllerLog;
import com.sky.statistics.core.constant.SysConst;
import com.sky.statistics.core.feature.orm.mybatis.Page;
import com.sky.statistics.core.util.ContextUtil;
import com.sky.statistics.core.util.StringUtil;
import com.sky.statistics.web.dao.IUserLogMapper;
import com.sky.statistics.web.model.User;
import com.sky.statistics.web.model.UserLog;
import com.sky.statistics.web.model.UserLogExample;
import com.sky.statistics.web.model.vo.ClientVO;
import com.sky.statistics.web.service.UserLogService;
import com.sky.statistics.web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping(value = "/userlog")
public class UserLogController {

    @Resource
    private UserLogService userLogService;

    @Resource
    private UserService userService;

    @Resource
    private IUserLogMapper userLogMapper;
    /**
     * 查询用户日志
     * */
    @RequestMapping("/list")
    public ModelAndView selectUserLog(){
        User us = new User();
        us.setId(1L);
        List<UserLog> ul = userLogService.selectUserLog(us);
//        UserLog ul = userLogService.selectById(1L);
        System.out.println("小何");
        System.out.println(ul);
        ModelAndView mav=new ModelAndView("list");
        mav.addObject("userLog",ul);
        return mav;
    }

    /**
     * 查询用户日志
     * */
    @RequestMapping("/list1")
    @SystemControllerLog(description = "查询所有用户日志")
    public ModelAndView selectUserLogPage(){
        User us = new User();
        us.setId(2L);

        Page<UserLog> page = new Page<UserLog>(1, 2);
        UserLogExample example = new UserLogExample();
        example.createCriteria().relationUser().andUserIDEqualTo(2L);

        final List<UserLog> usl = userLogMapper.selectByExampleAndPage(page,example);
//        final List<UserLog> usl = userLogMapper.selectUserLog(page, us);
        for (UserLog user : usl) {
            System.err.println(user);
        }
        ModelAndView mav=new ModelAndView("list");
        mav.addObject("userLog",usl);
        return mav;
    }

    /**
     * 查询用户日志
     * */
    @RequestMapping("/getLog")
    @ResponseBody
    public Map<String,Object> selectLog(HttpServletRequest request, UserLog usl){
        //user参数不全返回失败操作状态码
        Map<String,Object> map = new HashMap<String,Object>();
        int pageNo = Integer.parseInt(request.getParameter("pageNo"));
        int pageSize = Integer.parseInt(request.getParameter("pageSize"));
//        int pageNo = 1;
//        int pageSize = 5;
        Page<UserLog> page = new Page<UserLog>(pageNo, pageSize);
        //提供id、user.id、area、userSN、logTime 五个查询条件
        UserLogExample example = new UserLogExample();
        //查询规则
        UserLogExample.Criteria criteria = example.createCriteria();
        criteria.relationUser();//关联用户表

        System.out.println(usl);
        //封装查询条件
        if( usl.getId() != null )
            criteria.andIdEqualTo(usl.getId());
        if( usl.getUser().getId() != null )
            criteria.andUserIDEqualTo(usl.getUser().getId());
        if( !StringUtil.isEmpty(usl.getArea()) )
            criteria.andAreaLike("%" + usl.getArea() + "%");
        if( usl.getLogType() != 0 )
            criteria.andLogTypeEqualTo(usl.getLogType());
        if( usl.getLogTime() != null )
            criteria.andLogTimeLessThanOrEqualTo(usl.getLogTime());

        final List<UserLog> listUserLog = userLogService.selectByExampleAndPage(page, example);
        System.out.println(listUserLog);
        if(listUserLog.size()>0){
            map.put("code", SysConst.OP_SUCCESS);//操作成功
            map.put("data", listUserLog);//操作成功
        }else
            map.put("code", SysConst.OP_FAILD);//操作失败
        return map;
    }


    /**
     * 记录操作日志
     * */
//    @RequestMapping(value="/insert",method= RequestMethod.POST, consumes = "application/json")
//    @ResponseBody
//    public Map<String,Object> insertLog(@RequestBody UserLog usl, HttpServletRequest request)
    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insertLog(UserLog usl, HttpServletRequest request)
    {
        //返回操作状态码
        Map<String,Object> map = new HashMap<String,Object>();
//        if (result.hasErrors()) {
//            map.put("code", SysConst.OP_FAILD);
//            return map;
//        }

        //System.out.println(usl.getUser().getUserName());
        System.out.println("用户id："+usl.getUser().getId());

        //初始化
        String ip = ContextUtil.getClientIp();
        String[] addr = ContextUtil.getAddressByIP(ip);//通过request获取IP再获取IP所在地
        usl.setIp(ip);
        usl.setArea(StringUtil.joinIgnoreEmptyStr(",", addr));
        usl.setLogTime(new Date());

        //持久化
        userLogService.insert(usl);


        User us = new User();
        userService.insert(us);

        Long resultID = usl.getId();
        System.out.println("存储返回结果i："+resultID);
        if(resultID > 0L)
            map.put("code", SysConst.OP_SUCCESS);//操作成功
        else
            map.put("code", SysConst.OP_FAILD);//操作失败

        return map;
    }

    /**
     * 删除操作日志
     * */
    @RequestMapping(value="/delete",method= RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public Map<String,Object> deleteLog(@RequestBody UserLog usl, HttpServletRequest request)
    {
        //返回操作状态码
        Map<String,Object> map = new HashMap<String,Object>();

        System.out.println("用户id："+usl.getUser().getId());

        //提供id、user.id、area、userSN、logTime 五个查询条件
        UserLogExample example = new UserLogExample();
        //查询规则
        UserLogExample.Criteria criteria = example.createCriteria();
        criteria.relationUser();//关联用户表

        System.out.println(usl);
        //封装查询条件
        if( usl.getId() != null )
            criteria.andIdEqualTo(usl.getId());
        if( usl.getUser().getId() != null )
            criteria.andUserIDEqualTo(usl.getUser().getId());
        if( !StringUtil.isEmpty(usl.getArea()) )
            criteria.andAreaLike("%" + usl.getArea() + "%");
        if( usl.getLogType() != 0 )
            criteria.andLogTypeEqualTo(usl.getLogType());
        if( usl.getLogTime() != null )
            criteria.andLogTimeLessThanOrEqualTo(usl.getLogTime());
        //执行操作
        int i = userLogService.deleteByExample(example);

        if(i > 0L)
            map.put("code", SysConst.OP_SUCCESS);//操作成功
        else
            map.put("code", SysConst.OP_FAILD);//操作失败

        return map;
    }

    @RequestMapping(value="/client",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> select()
    {
        Map<String,Object> map = new HashMap<String,Object>();
        List<String> msgList = new ArrayList<String>();

        List<ClientVO> client = userLogService.selectClient();

        msgList.add("查询成功");
        map.put(SysConst.RETURN_KEY_CODE, SysConst.OP_SUCCESS);//操作成功
        map.put(SysConst.RETURN_KEY_MSG, msgList);
        map.put(SysConst.RETURN_KEY_DATA, client);//终端注册信息
        return map;
    }
}
