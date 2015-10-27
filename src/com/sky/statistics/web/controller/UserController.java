package com.sky.statistics.web.controller;

import com.sky.statistics.core.constant.SysConst;
import com.sky.statistics.core.feature.encoder.Md5PwdEncoder;
import com.sky.statistics.core.feature.orm.mybatis.Page;
import com.sky.statistics.core.util.StringUtil;
import com.sky.statistics.web.dao.IUserMapper;
import com.sky.statistics.web.model.User;
import com.sky.statistics.web.model.UserExample;
import com.sky.statistics.web.service.UserService;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;


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
     * */
    @RequestMapping(value="/register",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insertUser(@Valid User us, BindingResult result)
    {
        //user参数不全返回失败操作状态码
        Map<String,Object> map = new HashMap<String,Object>();
        if (result.hasErrors()) {
            //TODO 捕获异常
            //System.out.println(result.getFieldErrors());
            map.put("code", SysConst.OP_FAILD);
            return map;
        }

        //us初始化
        Date now = new Date();
        //获取随机码执行盐渍算法
        String salt= StringUtil.getRandomString(9);
        us.setPassword(new Md5PwdEncoder().encodePassword(us.getPassword(),salt));
        //盐渍生成序列号
        String serialNumber = new Md5PwdEncoder().encodePassword(us.getIMEI(), salt);
        us.setSerialNumber(serialNumber);
        //保存盐渍
        us.setSalt(salt);

        us.setLastLoginTime(now);
        us.setCreator("me");
        us.setCreateTime(now);
        //持久化
        int i = userService.insert(us);

        if(i>0){
            map.put("code", SysConst.OP_SUCCESS);//操作成功
            map.put("sn",serialNumber);//返回序列号
        }else
            map.put("code", SysConst.OP_FAILD);//操作失败

        return map;
    }

    /**
     * 登录
     * */
    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> login(@Valid User us, BindingResult result)
    {
        //返回操作状态码
        Map<String,Object> map = new HashMap<String,Object>();

        if (result.hasErrors()) {
            map.put("code", SysConst.OP_FAILD);
            return map;
        }

        //持久化
        User user = userService.authentication(us);


        if(user.getId()>0)
            map.put("code", SysConst.OP_SUCCESS);//操作成功
        else
            map.put("code", SysConst.OP_FAILD);//操作失败

        return map;
    }

    /**
     * 查询用户信息
     * */
    @RequestMapping(value="/select",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> select(User us)
    {
        //返回操作状态码
        Map<String,Object> map = new HashMap<String,Object>();

        //查询
        Page<User> page = new Page<User>(1, 1);
        UserExample example = new UserExample();
        example.createCriteria().andIdEqualTo(us.getId());
        final List<User> users = userService.selectByExampleAndPage(page, example);

        if(users.size()>0){
            map.put("code", SysConst.OP_SUCCESS);//操作成功
            map.put("data", users);//操作成功
        }else
            map.put("code", SysConst.OP_FAILD);//操作失败

        return map;
    }


    @RequestMapping(value="/json",method= RequestMethod.POST)
    @ResponseBody//将内容或对象作为 HTTP 响应正文返回，使用@ResponseBody将会跳过视图处理部分，而是调用适合HttpMessageConverter，将返回值写入输出流。
    public Map<String,Object> testJson(@RequestParam Long id){

        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code", id);
        System.out.println("操作状态："+id);
        return map;
    }

    @RequestMapping("/test")
    public String test(HttpServletRequest request,HttpServletResponse response){
        //返回字符串指向jsp页面名称
        return "test";
    }
}
