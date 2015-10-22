<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2015/10/22
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<form method="post" action="user/register1">
  <label for="userName">姓名</label>
  <input type="text" id="userName" name="userName">
  <br>
  <label for="password">密码</label>
  <input type="password" id="password" name="password">
  <br>
  <label for="age">年龄</label>
  <input type="number" id="age" name="age" value="19">
  <br>
  <label for="address">地址</label>
  <input type="text" id="address" name="address" value="ewrwe">
  <br>
  <label for="company">公司</label>
  <input type="text" id="company" name="company" value="sdfeewr">
  <br>
  <label for="phone">电话</label>
  <input type="number" id="phone" name="phone" value="18500000000">
  <br>
  <label for="IP">IP</label>
  <input type="text" id="IP" name="IP" value="127.0.0.1">
  <br>
  <label for="client">客户端类型</label>
  <input type="text" id="client" name="client" value="1">
  <br>
  <label for="headURL">头像</label>
  <input type="text" id="headURL" name="headURL" value="234">
  <br>
  <label for="dsc">描述</label>
  <input type="text" id="dsc" name="dsc" value="213">
  <br>
  <input type="submit" value="提交">
</form>
</body>
</html>
