package com.sky.statistics.core.constant;


/**
 * 系统常量
 * @author 胡礼波-Andy
 *
 */
public class SysConst {
    
	public final static String MEMBER_LOGIN_FLAG="loginMember";					//用户登录标识
	public final static String LOGIN_FLAG="loginUser";					//用户登录标识
	public final static String ENCODEING_UTF8="UTF-8";				//编码
	public final static String RETURNURL="returnUrl";
    public final static String COMMON_SECRET_KEY = "@7LW^!*$";				//公共数据的加密密钥
	
	public final static String FIRSTRESULT="firstResult";		//从第几条记录开始
	public final static String MAXRESULT="maxResult";			//到第几条记录结束
	public final static String PAGENO="pageNo";					//页码
	public final static String PAGESIZE="pageSize";				//每页记录条数
	
	public final static String IP="ip";							//用户IP
	public final static String USERID="userId";					//用户ID
	
	public final static String OP_SUCCESS="1";
	public final static String OP_FAILD="0";
	
	public final static int SECONDS = 30;										//扫描时间间隔
	public final static int MAX_IMG_SIZE=2;										//上传图片最大
	public final static int PAY_TIMEOUT=5;										//支付时间限制5分钟
	
	public static String appServer=null;							//网站地址
	public static String picServer=null;							//图片服务器地址

	//返回json键
	public static String RETURN_KEY_CODE = "code";
	public static String RETURN_KEY_MSG = "messages";
	public static String RETURN_KEY_DATA = "data";
	public static String RETURN_KEY_TOTAL = "total";

	public static String OP_SUCCESS_MSG = "操作成功";
	public static String OP_FAILD_MSG = "操作失败";
}





