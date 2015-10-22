package com.sky.statistics.web.controller;

import com.sky.statistics.web.model.User;
import com.sky.statistics.web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Resource
    private UserService userService;

    @RequestMapping("/list")
    public ModelAndView selectall(HttpServletRequest request,HttpServletResponse response){
        List<User> user=userService.selectUsers("%%");
        System.out.println("小何");
        System.out.println(user);
        ModelAndView mav=new ModelAndView("list");
        mav.addObject("user",user);
        return mav;
    }

    @RequestMapping("/register")
    public ModelAndView insert(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        System.out.println("id: "+id);
        ModelAndView mav=new ModelAndView("register");
        mav.addObject("result","你提交的ID："+id);
        return mav;
    }

    @RequestMapping(value="/register1",method= RequestMethod.POST)
    public String insertUser(HttpServletResponse response, User us)
    {

        Date now = new Date();
        us.setLastLoginTime(now);
        us.setCreator("me");
        us.setCreateTime(now);

        System.out.println(us.getUserName());

        int i = userService.insert(us);

        System.out.println("操作状态："+i);
        return null;
    }

    @RequestMapping("/test")
    public String test(HttpServletRequest request,HttpServletResponse response){
        //返回字符串指向jsp页面名称
        return "test";
    }
}
