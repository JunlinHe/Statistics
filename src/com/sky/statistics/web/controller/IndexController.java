package com.sky.statistics.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by User on 2015/11/4.
 */
@Controller
@RequestMapping(value = "/index")
public class IndexController {

    @RequestMapping(value="")
    public ModelAndView selectByPram(){

        return new ModelAndView("index");
    }

    @RequestMapping(value="/Statistics")
    public ModelAndView Statistics(){

        ModelAndView mav=new ModelAndView("rpt");
//        mav.addObject("user",users);
        return mav;
    }
}
