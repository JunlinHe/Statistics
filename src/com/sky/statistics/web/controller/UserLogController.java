package com.sky.statistics.web.controller;

import com.sky.statistics.web.model.UserLog;
import com.sky.statistics.web.service.UserLogService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/userlog")
public class UserLogController {

    @Resource
    private UserLogService userLogService;

    /**
     * 查询用户日志
     * */
    @RequestMapping("/list")
    public ModelAndView selectUserLog(){
        List<UserLog> userLog = userLogService.selectUserLog(1L);
        System.out.println("小何");
        System.out.println(userLog);
        ModelAndView mav=new ModelAndView("list");
        mav.addObject("userLog",userLog);
        return mav;
    }

    /**
     * 记录操作日志
     * */
    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insertLog(@Valid UserLog usl, BindingResult result)
    {
        //返回操作状态码
        Map<String,Object> map = new HashMap<String,Object>();
        if (result.hasErrors()) {
            map.put("code", "-1");
            return map;
        }

        //System.out.println(usl.getUser().getUserName());

        //持久化
        int i = userLogService.insert(usl);

        if(i>0)
            map.put("code", "1");//操作成功
        else
            map.put("code", "0");//操作失败

        return map;
    }


}
