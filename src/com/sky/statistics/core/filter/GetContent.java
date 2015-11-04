package com.sky.statistics.core.filter;

import com.sky.statistics.core.constant.SysContent;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by User on 2015/11/4.
 * 将request、response、session存入ThreadLocal
 */
public class GetContent implements Filter {
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        System.out.println("GetContent销毁，删除SysContent");
        SysContent.destroy();
    }
    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1,
                         FilterChain arg2) throws IOException, ServletException {
        SysContent.setRequest((HttpServletRequest) arg0);
        SysContent.setResponse((HttpServletResponse) arg1);
        arg2.doFilter(arg0, arg1);
    }
    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub
        System.out.println("GetContent初始化");
    }
}

