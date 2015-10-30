package com.sky.statistics.core.util;

import java.io.*;
import java.net.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sky.statistics.core.constant.SysConst;
import com.sky.statistics.web.model.User;
import org.apache.log4j.Logger;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.support.WebApplicationContextUtils;


/**
 * 系统上下文工具类
 * @author 胡礼波
 * 2012-11-1 上午10:59:08
 */
public class ContextUtil {

	private static Logger logger=Logger.getLogger(ContextUtil.class);

	/**
	 * 从springcontext中获取某个类型的对象实例
	 * @author 胡礼波-andy
	 * @2013-6-22下午3:57:35
	 * @param c
	 * @return
	 */
	public static <T> T getWebContextBean(Class<T> c,ServletContext servletCtx)
	{
		WebApplicationContext ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(servletCtx);
		return ctx.getBean(c);
	}
	
	/**
	 * 从springcontext中获取某个类型的对象实例
	 * @author 胡礼波-andy
	 * @2013-6-22下午3:57:35
	 * @param c
	 * @return
	 */
	public static Object getWebContextBean(Class<?> c)
	{
		WebApplicationContext ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		return ctx.getBean(c);
	}
	
	/**
	 * 从springcontext中获取某个类型的对象实例
	 * @author 胡礼波-andy
	 * @2013-6-22下午3:57:35
	 * @param c name
	 * @return
	 */
	public static Object getWebContextBean(String name,Class<?> c)
	{
		WebApplicationContext ctx=WebApplicationContextUtils.getRequiredWebApplicationContext(getServletContext());
		return ctx.getBean(name,c);
	}
	
	/**
	 * 获得登录用户 从HttpSession中获取或者从ThreadLocal中得到
	 * @author 胡礼波
	 * 2012-12-4 上午10:43:07
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static User getContextLoginUser()
	{
		try
		{
			Map<String,Object> map=ThreadLocalUtil.get(Map.class);
			if(map!=null)
			{
				if(map.containsKey(SysConst.USERID))
				{
					return (User)map.get(SysConst.USERID);
				}
			}
			User user=(User)getHttpServletRequest().getSession().getAttribute(SysConst.LOGIN_FLAG);
			return user;
		}
		catch (Exception e) {
		}
		return null;
	}

	/**
	 * 设置登录用户
	 * @param user
	 */
	public static void setContextLoginUser(User user)
	{
		try
		{
			ThreadLocalUtil.set(user);
			getHttpServletRequest().getSession().setAttribute(SysConst.LOGIN_FLAG, user);
		}
		catch (Exception e) {
		}
	}
	
	/**
	 * 获取RequestAttributes对象
	 * @author 胡礼波-andy
	 * @2013-6-22下午3:15:09
	 * @return
	 */
	private static RequestAttributes getRequestAttributes()
	{
		RequestAttributes attri= RequestContextHolder.getRequestAttributes();
		return attri;
	}
	
	/**
	 * 获取ServletContext失败
	 * @author 胡礼波
	 * 2012-12-4 上午10:49:20
	 * @return
	 */
	public static ServletContext getServletContext()
	{
		try
		{
			ServletContext context=getHttpServletRequest().getServletContext();
			return context;
		}
		catch (Exception e) {
		}
		return null;
	}
	
	/**
	 * 获得HttpServletRequest
	 * @author 胡礼波
	 * 2012-12-4 上午10:45:11
	 */
	public static HttpServletRequest getHttpServletRequest()
	{
		try
		{
			HttpServletRequest request= ((ServletRequestAttributes)getRequestAttributes()).getRequest();
			return request;
		}catch (Exception e) {
		}
		return null;
	}
	
	
	/**
	 * 获取HttpServletResponse
	 * @author 胡礼波
	 * 2012-12-4 上午10:46:21
	 * @return
	 */
	public static HttpServletResponse getHttpServletResponse()
	{
		try
		{
			HttpServletResponse response= ((ServletWebRequest)getRequestAttributes()).getResponse();
			return response;
		}catch (Exception e) {
			logger.error("获取HttpServletResponse失败!");
		}
		return null;
	}
	
	/**
	 * 获得应用程序的根目录
	 * @author 胡礼波
	 * 2012-7-7 下午03:54:59
	 * @return
	 */
	public static String getAppPath()
	{
		String path=new File(StringUtil.class.getClassLoader().getResource("").getPath()).getParentFile().getParentFile().getPath();
		try {
			path=URLDecoder.decode(path,SysConst.ENCODEING_UTF8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	/**
	 * 获得WEB-INF下的目录结构
	 * @author 胡礼波
	 * 2012-7-7 下午03:48:14
	 * @param path  格式为"/XXX"
	 * @return
	 */
	public static String getWebInfPath(String path)
	{
		path=new File(StringUtil.class.getClassLoader().getResource("").getPath()).getParentFile().getPath()+path;
		try {
			path=URLDecoder.decode(path,SysConst.ENCODEING_UTF8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	/**
	 * 获得ClassLoader目录
	 * @author 胡礼波
	 * 2012-7-7 下午03:52:57
	 * @param path XX/XX
	 * @return
	 */
	public static String getClassLoaderPath(String path)
	{
		path=StringUtil.class.getClassLoader().getResource(path).getPath();
		try {
			path=URLDecoder.decode(path,SysConst.ENCODEING_UTF8);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return path;
	}

	/**
	 * 获得客户端的IP Web请求来自HttpServletRquest<br/>
	 * Mina Socket请求来自ThreadLocal
	 * @author 胡礼波
	 * 2013-4-25 下午4:03:51
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static String getClientIp()
	{
		Map<String,Object> map=ThreadLocalUtil.get(Map.class);
		if(map!=null)
		{
			if(map.containsKey(SysConst.IP))
			{
				return String.valueOf(map.get(SysConst.IP));
			}
		}
		return getIpAddr(getHttpServletRequest());
	}
	

	
	/**
	 * 判断请求是否来自一个站点 防盗链作用
	 * @author 胡礼波
	 * 2014-5-17 下午5:43:10
	 * @return
	 */
	public static boolean checkRequestIsSelfSite()
	{
		HttpServletRequest request=getHttpServletRequest();
		String refererTo=request.getHeader("referer");						//传来的页面
	   if(refererTo==null || refererTo.trim().equals("") || !refererTo.contains(request.getServerName())){	//防盗链  
		   return false;  
        }
	   return true;
	}



	/**
	 * 根据IP获取城市
	 * @param strIP
	 * @return [国家][省][市][运营商]
	 */
	public static String[] getAddressByIP(String strIP)
	{
		try
		{

			//淘宝
			//http://ip.taobao.com/service/getIpInfo.php?ip=
			//新浪
			//http://int.dpool.sina.com.cn/iplookup/iplookup.php?format=json&ip=
			URL url = new URL( "http://ip.taobao.com/service/getIpInfo.php?ip=" + strIP);
			URLConnection conn = url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "GBK"));


			String line = null;
			StringBuffer result = new StringBuffer();
			while((line = reader.readLine()) != null)
			{
				result.append(line);
			}
			reader.close();
//          taobao resultType
//            {
//                "code": 0,
//                "data": {
//                    "country": "中国",
//                    "country_id": "CN",
//                    "area": "华南",
//                    "area_id": "800000",
//                    "region": "广东省",
//                    "region_id": "440000",
//                    "city": "深圳市",
//                    "city_id": "440300",
//                    "county": "",
//                    "county_id": "-1",
//                    "isp": "电信",
//                    "isp_id": "100017",
//                    "ip": "119.139.127.85"
//                }
//            }

			ObjectMapper mapper = new ObjectMapper();
			JsonNode root = mapper.readTree(result.toString());

			JsonNode code = root.path("code");//请求状态
			JsonNode data = root.path("data");//响应数据
			String[] address = new String[4];
			address[0] = data.path("country").textValue();
			address[1] = data.path("region").textValue();
			address[2] = data.path("city").textValue();
			address[3] = data.path("isp").textValue();

			return address;
		}
		catch( IOException e)
		{
			return new String[4];
		}
	}

	/**
	 * 获取当前网络ip（此方法在代理服务器设置后才能正确获取request中的ip，如nginx的local节点中加proxy_set_header X-real-ip $remote_addr;）
	 * @param request
	 * @return
	 */
	public static String getIpAddr(HttpServletRequest request){
		String ipAddress = request.getHeader("x-forwarded-for");
		if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("Proxy-Client-IP");
		}
		if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getHeader("WL-Proxy-Client-IP");
		}
		if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
			ipAddress = request.getRemoteAddr();
			if(ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")){
				//根据网卡取本机配置的IP
//                InetAddress inet=null;
//                try {
//                    inet = InetAddress.getLocalHost();
//                } catch (UnknownHostException e) {
//                    e.printStackTrace();
//                }
//                ipAddress= inet.getHostAddress();

				//根据操作系统获取ip
				ipAddress = getLocalip();
			}
		}
		//对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
		if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15
			if(ipAddress.indexOf(",")>0){
				ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));
			}
		}
		return ipAddress;
	}

	private static String getLinuxIP() throws SocketException {
		// 根据网卡取本机配置的IP
		Enumeration netInterfaces = NetworkInterface.getNetworkInterfaces();
		InetAddress ipAddress = null;
		String ip = "";
		while (netInterfaces.hasMoreElements()) {
			NetworkInterface ni = (NetworkInterface) netInterfaces
					.nextElement();
			if (ni.getName().equals("eth0")) {
				continue;
			} else {
				Enumeration<?> e2 = ni.getInetAddresses();
				while (e2.hasMoreElements()) {
					ipAddress = (InetAddress) e2.nextElement();
					if (ipAddress instanceof Inet6Address)
						continue;
					ip = ipAddress.getHostAddress();
//					System.out.println("getLinuxIp:" + ip);
				}
				break;
			}
		}
		return ip;
	}

	/*
     * @return true---是Windows操作系统
     */
	public static boolean isWindowsOS() {
		boolean isWindowsOS = false;
		String osName = System.getProperty("os.name");
		if (osName.toLowerCase().indexOf("windows") > -1) {
			isWindowsOS = true;
		}
		return isWindowsOS;
	}

	private static String getLocalip() {
		String localIP = null;
		try {
			// localIP = InetAddress.getLocalHost(); //结果格式：PC-name/IP
			boolean isWindows = isWindowsOS(); // 判断是否是windows系统
			if (isWindows) {
				InetAddress address = InetAddress.getLocalHost();
				localIP = address.getHostAddress(); // 获取ip地址
				//System.out.println("windows ip地址：" + localIP);
			} else { // 如果是Linux系统
				localIP = getLinuxIP();
			}
		} catch (Exception e) {
		}
//		String strLocalIP = localIP.getHostAddress();// IP
//		return strLocalIP;
		return localIP;
	}

}
