<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    
    <title>My JSP 'list.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <%--<c:forEach items="${articles}" var="item">--%>
        <%--${item.id }--${item.title }--${item.content }<br />--%>
    <%--</c:forEach>--%>
    <c:forEach items="${user}" var="item">
        ${item.id }--${item.userName }--${item.password }<br />
    </c:forEach>

    <c:forEach items="${userLog}" var="item">
        ${item.id }--用户名：${item.userID.userName }--序列号：${item.userID.serialNumber }--操作：${item.logInfo }<br />
    </c:forEach>
  </body>
</html>
