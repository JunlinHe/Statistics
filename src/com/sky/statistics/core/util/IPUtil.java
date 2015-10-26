package com.sky.statistics.core.util;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Enumeration;

/**
 * Created by HJL on 2015/10/25.
 */
public class IPUtil {

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
//    public static void main(String[] args) {
//
//        IPUtil iu = new IPUtil();
//        System.out.print(iu.getAddressByIP("119.139.127.85")[2]);
//    }
}
