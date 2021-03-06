<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<meta property="qc:admins" content="025302756375" />
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<script type="text/javascript" src="http://qzonestyle.gtimg.cn/qzone/openapi/qc_loader.js" 
	data-appid="1104841101" 
	data-redirecturi="http://www.baidu.com" 
	charset="utf-8"></script>
  </head>

<body>
	This is my JSP page.
	<br>
	<a><span id="qqLoginBtn"></span> QQ账号登陆</a>
	
	<script type="text/javascript">
		//调用QC.Login方法，指定btnId参数将按钮绑定在容器节点中
		QC.Login({
			//btnId：插入按钮的节点id，必选
			btnId : "qqLoginBtn",
			//用户需要确认的scope授权项，可选，默认all
			scope : "all",
			//按钮尺寸，可用值[A_XL| A_L| A_M| A_S|  B_M| B_S| C_S]，可选，默认B_S
			size : "C_S"
		},function(reqData, opts) {//登录成功
			//根据返回数据，更换按钮显示状态方法
			var dom = document.getElementById(opts['btnId']), _logoutTemplate = [
					//头像
					'<span><img src="{figureurl}" class="{size_key}"/></span>',
					//昵称
					'<span>{nickname}</span>',
					//退出
					'<span><a href="javascript:QC.Login.signOut();">退出</a></span>' ]
					.join("");
			dom
					&& (dom.innerHTML = QC.String
							.format(
									_logoutTemplate,
									{
										nickname : QC.String
												.escHTML(reqData.nickname), //做xss过滤
										figureurl : reqData.figureurl
									}));
		}, function(opts) {//注销成功
			alert('QQ登录 注销成功');
		});
	</script>
</body>
</html>
