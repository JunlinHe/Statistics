package com.sky.statistics.web.controller;

import com.sky.statistics.core.util.IPUtil;
import com.sky.statistics.core.util.StringUtil;
import com.sky.statistics.web.model.User;
import com.sky.statistics.web.model.UserLog;
import com.sky.statistics.web.service.UserLogService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
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
     * 记录操作日志
     * */
    @RequestMapping(value="/insert",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insertLog(@Valid UserLog usl, BindingResult result,HttpServletRequest request)
    {
        //返回操作状态码
        Map<String,Object> map = new HashMap<String,Object>();
        if (result.hasErrors()) {
            map.put("code", "-1");
            return map;
        }

        //System.out.println(usl.getUser().getUserName());
        System.out.println("用户id："+usl.getUser().getId());

        //初始化
        String ip = IPUtil.getIpAddr(request);
        String[] addr = IPUtil.getAddressByIP(ip);//通过request获取IP再获取IP所在地
        usl.setIP(ip);
        usl.setArea(StringUtil.join(",",addr));
        usl.setLogTime(new Date());

        //持久化
        int i = userLogService.insert(usl);
        System.out.println("存储返回结果i："+i);
        if(i>0)
            map.put("code", "1");//操作成功
        else
            map.put("code", "0");//操作失败

        return map;
    }


}
