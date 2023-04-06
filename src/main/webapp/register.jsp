<%--
  Created by IntelliJ IDEA.
  User: purity
  Date: 2022/6/2
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>考试管理系统-注册</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- 引入jQuery -->
    <script type="text/javascript" src="static/js/jquery-3.6.0.min.js"></script>
    <!-- 引入样式 -->
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<%--注册页面--%>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">注册</h3>
                </div>
                <div class="panel-body">
                    <form action="register" method="post">
                        <div class="form-group">
                            <label for="username">用户名</label>
                            <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名" required>
                        </div>
                        <div class="form-group">
                            <label for="password">密码</label>
                            <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码" required>
                        </div>
                        <div class="form-group">
                            <label for="password2">确认密码</label>
                            <input type="password" class="form-control" id="password2" name="password2" placeholder="请再次输入密码" required>
                            <span id="msg" style="color: red"></span>
                        </div>
                        <div class="form-group">
                            <label for="name">真实姓名</label>
                            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名" required>
                        </div>
                        <div class="form-group">
                            <label>用户类别</label>
                            <input type="radio" value="admin" name="userrole">管理员
                            <input type="radio" value="teacher" name="userrole">教师
                            <input type="radio" value="student" name="userrole">学生
                        </div>
                        <div class="form-group">
                            <label>性别</label>
                            <input type="radio" value="1" name="gender">男
                            <input type="radio" value="0" name="gender">女
                        </div>
                        <div class="form-group">
                            <label for="phone">手机号</label>
                            <input type="text" class="form-control" id="phone" name="phone" placeholder="请输入手机号">
                            <span id="msg1" style="color: red"></span>
                        </div>
                        <div class="form-group">
                            <label for="age">年龄</label>
                            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
                        </div>
                        <div class="panel-footer">
                            <button type="submit" class="btn btn-primary" onclick="return check()">注册</button>
                            <button type="reset" class="btn btn-default">重置</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
<script>
    function check() {
        var password = document.getElementById("password").value;
        var password2 = document.getElementById("password2").value;
        if (password != password2) {
            document.getElementById("msg").innerHTML = "两次密码不一致";
            return false;
        }
        var phone = document.getElementById("phone").value;
        var reg = /^1[34578]\d{9}$/;
        if (!reg.test(phone)) {
            document.getElementById("msg1").innerHTML = "手机号格式不正确";
            return false;
        }
        return true;
    }
    //实时监听两次密码是否一致
    $("#password2").blur(function () {
        var password = $("#password").val();
        var password2 = $("#password2").val();
        if (password != password2) {
            $("#msg").html("两次密码不一致");
        } else {
            $("#msg").html("");
        }
    });
    $("#phone").blur(function () {
        var phone = $("#phone").val();
        if (phone.length != 11) {
            $("#msg1").html("手机号长度不正确");
        } else {
            $("#msg1").html("");
        }
    });
</script>
</html>
