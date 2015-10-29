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
        return str == null || !Pattern.compile("^\\\\s*$").matcher(str).matches() ? true : false;
    }

    public static void main(String[] args) {
        String[] t = new String[4];
        t[0] = t[1] = "1";
        t[2] = t[3] = "";
        System.out.println(StringUtil.joinIgnoreEmptyStr(",", t));

        System.out.println(StringUtil.isEmpty(" "));
    }
}
