package com.sky.statistics.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by User on 2015/11/4.
 */
@Controller
//@RequestMapping(value = "/")
public class IndexController {

    @RequestMapping({"/","/index"})
    public ModelAndView index(){

        return new ModelAndView("index");
    }

    /**
     * 终端模块
     * @return
     */
    @RequestMapping("/terminal")
    public ModelAndView terminal(){

        return new ModelAndView("terminal/terminal");
    }
    @RequestMapping("/terminal/t_info")
    public ModelAndView terminalInfo(){

        return new ModelAndView("terminal/info");
    }
    @RequestMapping("/terminal/t_monitor")
    public ModelAndView terminalMonitor(){

        return new ModelAndView("terminal/monitor");
    }
    @RequestMapping("/terminal/t_setting")
    public ModelAndView terminalSetting(){

        return new ModelAndView("terminal/setting");
    }
    @RequestMapping("/terminal/t_group")
    public ModelAndView terminalGroup(){

        return new ModelAndView("terminal/group");
    }

    /**
     * 素材模块
     * @return
     */
    @RequestMapping("/material")
    public ModelAndView material(){

        return new ModelAndView("material/material");
    }

    /**
     * 节目模块
     * @return
     */
    @RequestMapping("/program")
    public ModelAndView program(){

        return new ModelAndView("program/program");
    }

    /**
     * 系统模块
     * @return
     */
    @RequestMapping("/system")
    public ModelAndView system(){

        return new ModelAndView("system/system");
    }
    @RequestMapping("/system/s_statistics")
    public ModelAndView systemStatistics(){

        return new ModelAndView("system/statistics");
    }
    @RequestMapping("/system/s_setting")
    public ModelAndView systemSetting(){

        return new ModelAndView("system/setting");
    }
    @RequestMapping("/system/s_resolution")
    public ModelAndView systemResolution(){

        return new ModelAndView("system/resolution");
    }
    @RequestMapping("/system/s_dbbackup")
    public ModelAndView systemDbbackup(){

        return new ModelAndView("system/dbbackup");
    }
    @RequestMapping("/system/s_authorization")
    public ModelAndView systemAuthorization(){

        return new ModelAndView("system/authorization");
    }
    @RequestMapping("/system/s_usermng")
    public ModelAndView systemUsermng(){

        return new ModelAndView("system/usermng");
    }
    @RequestMapping("/system/s_logmng")
    public ModelAndView systemLogmng(){

        return new ModelAndView("system/logmng");
    }


    @RequestMapping(value="/Statistics")
    public ModelAndView Statistics(){

        ModelAndView mav=new ModelAndView("rpt");
//        mav.addObject("user",users);
        return mav;
    }
}
