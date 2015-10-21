package com.sky.statistics.controller;

import com.sky.statistics.dao.IUserMapper;
import com.sky.statistics.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserMapper userMapper;

//    @RequestMapping("/list")
//    public ModelAndView listall(HttpServletRequest request,HttpServletResponse response){
//        List<Article> articles=userMapper.getUserArticles(1);
//        ModelAndView mav=new ModelAndView("list");
//        mav.addObject("articles",articles);
//        return mav;
//    }

    @RequestMapping("/list")
    public ModelAndView listall(HttpServletRequest request,HttpServletResponse response){
        List<User> user=userMapper.selectUsers("%何%");
        System.out.println("小何");
        System.out.println(user);
        ModelAndView mav=new ModelAndView("list");
        mav.addObject("user",user);
        return mav;
    }

    @RequestMapping("/register")
    public ModelAndView register(HttpServletRequest request,HttpServletResponse response){
        String id = request.getParameter("id");
        System.out.println("id: "+id);
        ModelAndView mav=new ModelAndView("register");
        mav.addObject("result","你提交的ID："+id);
        return mav;
    }
}
