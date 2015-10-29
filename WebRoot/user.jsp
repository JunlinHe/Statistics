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
    <title>测试用户相关</title>

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
    <h3>注册</h3>
    <form id="regForm" method="post" action="user/register" enctype="">
        <label for="userName">姓名</label>
        <input type="text" id="userName" name="userName">
        <br>
        <label for="password">密码</label>
        <input type="password" id="password" name="password" value="12345678">
        <br>
        <label for="uuid">机器序列号</label>
        <input type="text" id="uuid" name="uuid" value="12345678">
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
        <label for="email">email</label>
        <input type="email" id="email" name="email" value="86132587@qq.com">
        <br>
        <label for="ip">ip</label>
        <input type="text" id="ip" name="ip" value="127.0.0.1">
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
        <input type="button" id="submitForm" value="提交">
    </form>
    <div id="regState" class="display"></div>
</div>

<div class="panel">
    <h3>登录</h3>

    <form id="loginForm">
        <label for="loginID">ID</label>
        <input type="text" id="loginID" name="id" value="213">
    </form>
    <input type="button" id="getJson" value="获取json">
    <div id="loginState" class="display"></div>
</div>

<div class="panel">
    <h3>修改</h3>
    <form id="updateForm">
        <label for="updateID">ID</label>
        <input type="text" id="updateID" name="id">
        <br>
        <label for="userName">姓名</label>
        <input type="text" name="userName">
        <br>
        <label for="password">密码</label>
        <input type="password"  name="password" >
        <br>
        <label for="uuid">机器序列号</label>
        <input type="text"  name="uuid" >
        <br>
        <label for="age">年龄</label>
        <input type="number"  name="age" >
        <br>
        <label for="address">地址</label>
        <input type="text"  name="address" >
        <br>
        <label for="company">公司</label>
        <input type="text"  name="company" >
        <br>
        <label for="phone">电话</label>
        <input type="number"  name="phone" >
        <br>
        <label for="email">email</label>
        <input type="email"  name="email">
        <br>
        <label for="ip">ip</label>
        <input type="text"  name="ip" >
        <br>
        <label for="client">客户端类型</label>
        <input type="text"  name="client" >
        <br>
        <label for="headURL">头像</label>
        <input type="text"  name="headURL" >
        <br>
        <label for="dsc">描述</label>
        <input type="text"  name="dsc" >
        <br>
        <input type="button" id="getData" value="获取数据">
        <input type="button" id="submitUpdate" value="提交">
    </form>
    <div id="updateState" class="display"></div>
</div>

<div class="panel">
    <h3>删除</h3>
    <label for="deleteUser">ID</label>
    <input type="text" id="deleteUser" placeholder="输入要删除的用户ID">
    <input type="button" id="actionDelete" value="删除">

    <div id="deleteState" class="display"></div>
</div>

<script>
$(function(){

    $('#submitForm').on('click',function(){
        var data = $('#regForm').serializeJson();
        console.log(data)
        $.ajax({
            url:'user/register',
            data:JSON.stringify(data),
            dataType:'json',
            type:'post',
            contentType:'application/json;charset=UTF-8',
            success:function(data){
                console.log(data);
                $('#regState').html(JSON.stringify(data));
            }
        });
    });


    $('#getJson').on('click',function(){

        var data = $('#loginForm').serialize();
        console.log(data)
        $.ajax({
            url:'user/json',
            data:data,
            dataType:'json',
            type:'post',
            //contentType:'application/json;charset=UTF-8',
            success:function(data){
                console.log(data);
                $('#loginState').html(JSON.stringify(data));
            }
        });

    });

    $('#getData').on('click',function(){
        var usID = $('#updateID').val();

        $.ajax({
            url:'user/select',
            data:{id:usID},
            dataType:'json',
            type:'post',
            //contentType:'application/json;charset=UTF-8',
            success:function(data){
                console.log(data);
                $('#updateState').html(JSON.stringify(data));
                $("#updateForm").autofill( data.data[0] );
            }
        });

    });

    $('#submitUpdate').on('click',function(){
        var data = $('#updateForm').serialize();
        console.log(data);
        $.ajax({
            url:'user/update',
            data:data,
            dataType:'json',
            type:'post',
            //contentType:'application/json;charset=UTF-8',
            success:function(data){
                console.log(data);
                $('#updateState').html(JSON.stringify(data));
            }
        });

    });

    $('#actionDelete').on('click',function(){
        var usID = $('#deleteUser').val();

        $.ajax({
            url:'user/delete',
            data:{id:usID},
            dataType:'json',
            type:'post',
            //contentType:'application/json;charset=UTF-8',
            success:function(data){
                console.log(data);
                $('#deleteState').html(JSON.stringify(data));
            }
        });

    });
});
</script>

</body>
</html>
