package com.sky.statistics.web.controller;

import com.sky.statistics.web.model.User;
import com.sky.statistics.web.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
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
    @RequestMapping("/list")
    public ModelAndView selectall(){
        List<User> user = userService.selectUsers("%何%");
        System.out.println("小何");
        System.out.println(user);
        ModelAndView mav=new ModelAndView("list");
        mav.addObject("user",user);
        return mav;
    }

    /**
     * 注册
     * */
    @RequestMapping(value="/register",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insertUser(@Valid User us, BindingResult result)
    {
        //返回操作状态码
        Map<String,Object> map = new HashMap<String,Object>();
        if (result.hasErrors()) {
            map.put("code", "-1");
            return map;
        }

        System.out.println(us.getUserName());

        //持久化
        int i = userService.insert(us);

        if(i>0)
            map.put("code", "1");//操作成功
        else
            map.put("code", "0");//操作失败

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
            map.put("code", "-1");
            return map;
        }

        //持久化
        User user = userService.authentication(us);


        if(user.getId()>0)
            map.put("code", "1");//操作成功
        else
            map.put("code", "0");//操作失败

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
