<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 2015/10/23
  Time: 14:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>测试插入日志</title>

    <script type="text/javascript" src="app/lib/jquery.js"></script>
</head>
<body>
<form id="logForm">
    <label for="userID">用户ID</label>
    <input type="text" id="userID" name="user.id">
    <br>
    <label for="userSerialNum">序列号</label>
    <input type="text" id="userSerialNum" name="userSerialNum" value="123123123">
    <br>
    <label for="logInfo">日志信息</label>
    <input type="number" id="logInfo" name="logInfo" value="19">
    <br>
    <label for="IP">ip</label>
    <input type="text" id="IP" name="IP" value="ewrwe">
    <br>
    <label for="methodName">方法名</label>
    <input type="text" id="methodName" name="methodName" value="methodName">
    <br>
    <label for="modelName">模块名</label>
    <input type="text" id="modelName" name="modelName" value="model_name">

    <br>
    <input type="button" id="submitForm" value="提交">
</form>


<div id="display"></div>
<script>
  $(function(){
      $('#submitForm').on('click',function(){
          var data = $('#logForm').serialize();
          console.log(data)
          $.ajax({
              url:'userlog/insert',
              data:data,
              dataType:'json',
              type:'post',
              //contentType:'application/json;charset=UTF-8',
              success:function(data){
                  console.log(data);
                  $('#display').html(JSON.stringify(data));
              }
          });

      });

  });
</script>

</body>
</html>
