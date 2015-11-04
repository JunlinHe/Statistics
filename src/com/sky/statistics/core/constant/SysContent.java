package com.sky.statistics.core.constant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by User on 2015/11/4.
 * 将request、response、session存入ThreadLocal
 */
public class SysContent {
    private static ThreadLocal<HttpServletRequest> requestLocal= new ThreadLocal<HttpServletRequest>();
    private static ThreadLocal<HttpServletResponse> responseLocal= new ThreadLocal<HttpServletResponse>();

    public static HttpServletRequest getRequest() {
        return (HttpServletRequest)requestLocal.get();
    }
    public static void setRequest(HttpServletRequest request) {
        requestLocal.set(request);
    }
    public static HttpServletResponse getResponse() {
        return (HttpServletResponse)responseLocal.get();
    }
    public static void setResponse(HttpServletResponse response) {
        responseLocal.set(response);
    }
    public static HttpSession getSession() {
        return (HttpSession)((HttpServletRequest)requestLocal.get()).getSession();
    }

    public static void destroy(){
        requestLocal.remove();
        responseLocal.remove();
    }
}
