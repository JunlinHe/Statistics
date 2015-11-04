package com.sky.statistics.core.util;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.regex.Pattern;

import com.sky.statistics.core.constant.SysConst;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.RandomUtils;


/**
 * 字符串工具类
 *
 * @author 胡礼波
 *         2012-5-18 下午03:02:13
 */
public class StringUtil {

    /**
     * 随机生成指定长度的字符串
     *
     * @param length
     * @return
     * @author 胡礼波-andy
     * @2013-6-23下午6:24:04
     */
    public static String getRandomString(int length) {
        String base = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 随机生成指定长度的字符串数字
     *
     * @param length
     * @return
     * @author 胡礼波-andy
     * @2013-6-23下午6:24:04
     */
    public static String getRandomNumber(int length) {
        String base = "0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(base.length());
            sb.append(base.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 把字符串转为UTF-8类型的字符串
     *
     * @param data
     * @return
     * @throws UnsupportedEncodingException
     * @author 胡礼波
     * 2012-5-18 下午03:04:29
     */
    public static String chartDecodeToUTF8(String data) {
        if (StringUtils.isEmpty(data)) {
            return null;
        }
        try {
            return new String(data.getBytes("ISO-8859-1"), SysConst.ENCODEING_UTF8);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 产生随机的最大数为maxNum的数字
     *
     * @param maxNum
     * @return
     * @author 胡礼波
     * 2012-6-6 下午02:49:42
     */
    public static String getRandom(int maxNum) {
        int num = 0;
        do {
            num = RandomUtils.nextInt(1, maxNum);
        }
        while (num > maxNum);
        return String.valueOf(num);
    }

    /**
     * 去掉所有的html标签
     *
     * @param html
     * @return
     * @author 胡礼波
     * 2013-3-10 下午4:56:18
     */
    public static String trimHtmlTag(String html) {
        if (StringUtils.isEmpty(html)) {
            return null;
        }
        return trimAllTags(html, false).replaceAll("\r", "").replaceAll("\n", "");
    }

    /**
     * @param input
     * @param inside
     * @return
     * @author 胡礼波
     * 2013-4-25 上午10:49:35
     */
    private static String trimAllTags(String input, boolean inside) {
        StringBuffer output = new StringBuffer();

        if (inside) {
            if ((input.indexOf('<') == -1) || (input.lastIndexOf('>') == -1) || (input.lastIndexOf('>') < input.indexOf('<'))) {
                output.append(input);
            } else {
                output.append(input.substring(0, input.indexOf('<')));
                output.append(input.substring(input.lastIndexOf('>') + 1, input.length()));
            }
        } else {
            boolean write = true;
            for (int index = 0; index < input.length(); index++) {
                if ((input.charAt(index) == '<') && (write))
                    write = false;
                if (write)
                    output.append(input.charAt(index));
                if ((input.charAt(index) == '>') && (!write)) {
                    write = true;
                }
            }
        }
        return output.toString();
    }

    /**
     * 拼接字符数组返回字符串，类似js的join方法
     *
     * @param join
     * @param strAry
     * @return
     */
    public static String join(String join, String[] strAry) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strAry.length; i++) {
            if (i == (strAry.length - 1)) {
                sb.append(strAry[i]);
            } else {
                sb.append(strAry[i]).append(join);
            }
        }

        return new String(sb);
    }

    /**
     * 拼接字符数组返回字符串，类似js的join方法，忽略空字符串
     *
     * @param join
     * @param strAry
     * @return
     */
    public static String joinIgnoreEmptyStr(String join, String[] strAry) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strAry.length; i++) {
            if ("".equals(strAry[i]))
                continue;
            sb.append(strAry[i]).append(join);
        }

        return new String(sb).substring(0, sb.length() - 1);
    }

    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        return str == null || Pattern.compile("^\\s*$").matcher(str).matches() ? true : false;
    }


    /**
     * 随机生成国内IP地址
     * @return
     */
    public static String getRandomIp(){

        //ip范围
        int[][] range = {{607649792,608174079},//36.56.0.0-36.63.255.255
                {1038614528,1039007743},//61.232.0.0-61.237.255.255
                {1783627776,1784676351},//106.80.0.0-106.95.255.255
                {2035023872,2035154943},//121.76.0.0-121.77.255.255
                {2078801920,2079064063},//123.232.0.0-123.235.255.255
                {-1950089216,-1948778497},//139.196.0.0-139.215.255.255
                {-1425539072,-1425014785},//171.8.0.0-171.15.255.255
                {-1236271104,-1235419137},//182.80.0.0-182.92.255.255
                {-770113536,-768606209},//210.25.0.0-210.47.255.255
                {-569376768,-564133889}, //222.16.0.0-222.95.255.255
        };

        Random rdint = new Random();
        int index = rdint.nextInt(10);
        String ip = num2ip(range[index][0]+new Random().nextInt(range[index][1]-range[index][0]));
        return ip;
    }

    /**
     * 将十进制转换成ip地址
     * @param ip
     * @return
     */
    private static String num2ip(int ip) {
        int [] b=new int[4] ;
        String x = "";

        b[0] = (int)((ip >> 24) & 0xff);
        b[1] = (int)((ip >> 16) & 0xff);
        b[2] = (int)((ip >> 8) & 0xff);
        b[3] = (int)(ip & 0xff);
        x=Integer.toString(b[0])+"."+Integer.toString(b[1])+"."+Integer.toString(b[2])+"."+Integer.toString(b[3]);

        return x;
    }

    public static void main(String[] args) {
        String[] t = new String[4];
        t[0] = t[1] = "1";
        t[2] = t[3] = "";
        System.out.println(StringUtil.joinIgnoreEmptyStr(",", t));

        String str = "7fb38473e3e65d209a488d1fbdf76e9a";
        System.out.println(StringUtil.isEmpty(str));

        System.out.println(Pattern.compile("^\\s*$").matcher("").matches());

        System.out.println(StringUtil.getRandomIp());
    }
}
