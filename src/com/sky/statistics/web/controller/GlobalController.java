package com.sky.statistics.web.controller;

import java.util.Date;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
//import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.support.RequestContext;

/**
 * 国际化语言切换
 */
@Controller
@RequestMapping(value = "/global")
public class GlobalController {
    @Autowired
    CookieLocaleResolver resolver;

    @RequestMapping(value = "/language", method = {RequestMethod.GET})
    public String test(HttpServletRequest request, HttpServletResponse response, Model model, @RequestParam(value = "langType", defaultValue = "zh") String langType) {
        if (langType.equals("zh")) {
            Locale locale = new Locale("zh", "CN");
            //request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
            (resolver).setLocale(request, response, locale);
        } else if (langType.equals("en")) {
            Locale locale = new Locale("en", "US");
            //request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,locale);
            (resolver).setLocale(request, response, locale);
        } else
            //request.getSession().setAttribute(SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME,LocaleContextHolder.getLocale());
            (resolver).setLocale(request, response, LocaleContextHolder.getLocale());

        //从后台代码获取国际化信息
        RequestContext requestContext = new RequestContext(request);
        model.addAttribute("money", requestContext.getMessage("money"));
        model.addAttribute("date", requestContext.getMessage("date"));
        return "redirect:/";
    }

}