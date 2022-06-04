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
    <title>考试管理系统-登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- 引入jQuery -->
    <script type="text/javascript" src="static/js/jquery-3.6.0.min.js"></script>
    <!-- 引入样式 -->
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4">
            <div class="login-panel panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">请登录</h3>
                </div>
                <div class="panel-body">
                    <form role="form" action="login" method="post">
                        <fieldset>
                            <span class="text-danger">${msg}</span>
                            <div class="form-group">
                                <input class="form-control" placeholder="用户名" name="username" type="text" autofocus required>
                            </div>
                            <div class="form-group">
                                <input class="form-control" placeholder="密码" name="password" type="password" value="" required>
                            </div>
                            <div class="checkbox">
                                <label>
                                    <input name="remember" type="checkbox" value="Remember Me">记住我
                                </label>
                            </div>
                            <input type="hidden" name="action">
                            <div class="btngroup">
                                <button type="submit" class="btn btn-lg btn-success" onclick="return login()">登录</button>
                                <button type="submit" class="btn btn-lg btn-success" onclick="return register()"><a href="register.jsp">注册</a></button>
                            </div>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    function login() {
        $("input[name='action']").val('login');
        $("form").submit();
    }
    function register() {
        $("input[name='action']").val('register');
        $("form").submit();
    }
    //登录限制输入
    $(function () {
        $("input[name='username']").keyup(function () {
            var value = $(this).val();
            if (value.length > 10) {
                $(this).val(value.substr(0, 10));
            }
        });
        $("input[name='password']").keyup(function () {
            var value = $(this).val();
            if (value.length > 10) {
                $(this).val(value.substr(0, 10));
            }
        });
    });
</script>
</body>
<style>
    body {
        background: url("static/images/background.jpg") no-repeat;
        background-size: cover;
    }
    .login-panel {
        margin-top: 150px;
    }
    .btngroup {
        margin-top: 20px;
        margin-left: 33%;
    }
</style>
</html>
