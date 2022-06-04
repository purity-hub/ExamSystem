<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>考试管理系统-首页</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="static/js/jquery-3.6.0.min.js"></script>
    <link href="static/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <script src="static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<!--顶部导航栏部分-->
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" title="logoTitle" href="studentIndex.jsp">考试管理系统</a>
        </div>
        <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li >
                    <a href="${pageContext.request.contextPath}/UserInfo" target="mainFrame">当前用户：<span class="badge">${username}</span></a>
                </li>
                <li>
                    <a href="login">
                        <span class="glyphicon glyphicon-lock"></span>退出登录</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<!-- 中间主体内容部分 -->
<div class="pageContainer">
    <!-- 左侧导航栏 -->
    <div class="pageSidebar">
        <ul class="nav nav-stacked nav-pills">
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/myexaming" target="mainFrame" >我的考试</a>
            </li>
            <li role="presentation">
                <a href="${pageContext.request.contextPath}/studentScore" target="mainFrame">查询成绩</a>
            </li>
        </ul>
    </div>

    <!-- 左侧导航和正文内容的分隔线 -->
    <div class="splitter"></div>
    <!-- 正文内容部分 -->
    <div class="pageContent">
        <iframe src="welcome.jsp" id="mainFrame" name="mainFrame"
                frameborder="0" width="100%"  height="100%" frameBorder="0">
        </iframe>
    </div>

</div>
<!-- 底部页脚部分 -->
<div class="footer">
    <p class="text-center">
        2022 &copy; 罗鸿运.
    </p>
</div>

<script type="text/javascript">
    $(".nav li").click(function() {
        $(".active").removeClass('active');
        $(this).addClass("active");
    });
</script>
<%--css--%>
<style>
    /* 后台管理框架的样式 */

    /* 下拉菜单和导航 */
    .navbar-collapse{
        padding-left: 5px;
        padding-right: 5px;
    }
    .nav>li{
        text-align: center;
    }
    .nav>li>a{
        color:#444;
        margin: 0 5px;
    }
    .nav-pills>li.active>a, .nav-pills>li.active>a:focus, .nav-pills>li.active>a:hover{
        background-color: #222222;
    }
    .dropdown-menu{
        float: none;
        position: initial;
        min-width: 200px;
        margin-left: 0;
        background-color: #E3E3E3;
        box-shadow: none;
        text-align: center;
    }
    .dropdown-menu>li>a{
        padding: 10px 15px;
    }

    /* 主体样式 */
    body {
        width: 100%;
        height: 100%;
        margin: 0;
        overflow: hidden;
        background-color: #FFFFFF;
        font-family: "Microsoft YaHei", sans-serif;
    }
    .pageSidebar{
        width: 240px;
        height:100%;
        padding-bottom: 30px;
        overflow: auto;
        background-color: #e3e3e3;
    }
    .splitter {
        width: 5px;
        height: 100%;
        bottom: 0;
        left: 240px;
        position: absolute;
        overflow: hidden;
        background-color: #fff;
    }
    .pageContent{
        height: 100%;
        min-width: 768px;
        left: 246px;
        top: 0;
        right: 0;
        z-index: 3;
        padding-bottom: 30px;
        position: absolute;
    }
    .pageContainer{
        bottom: 0;
        left:0;
        right: 0;
        top: 53px;
        overflow: auto;
        position: absolute;
        width: 100%;
    }
    .footer {
        width: 100%;
        height: 30px;
        line-height: 30px;
        margin-top: 0;
        left: 0;
        right: 0;
        bottom: 0;
        position: absolute;
        z-index: 10;
        background-color:#DFDFDF;
    }
</style>
</body>
</html>
