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

    <link rel="stylesheet" type="text/css" href="app/css/style.css">
    <script type="text/javascript" src="app/lib/jquery.js"></script>
    <script type="text/javascript" src="app/lib/jquery.formautofill.min.js"></script>
    <script type="text/javascript" src="app/js/app.js"></script>
</head>
<body>

<div class="panel">
    <h3></h3>

    <div class="display"></div>
</div>

<div class="panel">
    <h3>添加日志</h3>
    <form id="logForm">
        <label for="userID">用户ID</label>
        <input type="text" id="userID" name="user.id">
        <br>
        <label for="userSerialNum">序列号</label>
        <input type="text" id="userSerialNum" name="userSerialNum" value="123123123">
        <br>
        <label for="logInfo">日志信息</label>
        <input type="text" id="logInfo" name="logInfo" value="19">
        <br>
        <label for="IP">ip</label>
        <input type="text" id="IP" name="ip" value="ewrwe">
        <br>
        <label for="methodName">方法名</label>
        <input type="text" id="methodName" name="methodName" value="methodName">
        <br>
        <label for="modelName">模块名</label>
        <input type="text" id="modelName" name="modelName" value="model_name">

        <br>
        <input type="button" id="submitForm" value="提交">
    </form>
    <div id="insertState" class="display"></div>
</div>

<div class="panel">
    <h3>查询</h3>
    <form id="selectForm">
        <label >ID</label>
        <input type="text" name="id">
        <br>
        <label >用户ID</label>
        <input type="text" name="user.id">
        <br>
        <label >序列号</label>
        <input type="text" name="userSerialNum" >
        <br>
        <label >地区</label>
        <input type="text" name="area" >
        <br>
        <label >时间</label>
        <input type="text" name="logTime" >
        <br>
        <input type="button" id="selectBtn" value="查询">
    </form>
    <div id="selectState" class="display"></div>
</div>

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
                  $('#insertState').html(JSON.stringify(data));
              }
          });

      });

      $('#selectBtn').on('click',function(){
          var data = $('#selectForm').serialize();
          console.log(data)
          $.ajax({
              url:'userlog/getLog',
              data:data+"&pageSize=5&pageNo=1",
              dataType:'json',
              type:'post',
              //contentType:'application/json;charset=UTF-8',
              success:function(data){
                  console.log(data);
                  $('#selectState').html(JSON.stringify(data));
              }
          });

      });
  });
</script>

</body>
</html>
