<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>登录</title>
    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/content/bootstrap-3.0.3/css/bootstrap.css" rel="stylesheet" media="screen">
    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/content/css/main.css" rel="stylesheet">
</head>
<body>
<div id="logo">
            <img src="${pageContext.request.contextPath}/content/css/images/logo.png" alt="" />
            </div>
            <nav class="navbar navbar-default" >
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-menu">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                    <a class="navbar-brand" href="#">首页</a>
                </div>
                <div class="collapse navbar-collapse" id="navbar-collapse-menu">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="person">个人主页</a></li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">我的邮箱<b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">收件箱</a></li>
                                <li><a href="#">发件箱</a></li>
                                <li class="divider"></li>
                                <li><a href="#">回收站</a></li>
                            </ul>
                        </li>
                    </ul>
                    <form class="navbar-form navbar-left" role="search">
                        <div class="form-group">
                            <input type="text" class="form-control" placeholder="主题">
                        </div>
                        <button type="submit" class="btn btn-default">搜索</button>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <li><a href="#">登录</a></li>
                        <li><a href="#">注册</a></li>
                    </ul>
                </div>
            </nav>
        </header>
    </div>
    <div class="container">
    
    	<div class="row">
    		<form action="checkLogin">
    			<table>
    				<tr>
	    				<td><label>用户名</label></td>
	    				<td><input type="text" name="user.username"/></td>
    				</tr>
    				<tr>
	    				<td><label>密码</label></td>
	    				<td><input type="password" name="user.password"/></td>
    				</tr>
    				<tr>
	    				<td></td>
	    				<td><button>登录</button></td>
    				</tr>
    			</table>
    			<div>${message}</div>
    		</form>
    	</div>
        
    </div>
    <div class="container">
        <footer id="footer" class="panel-footer">
            <p>手机论坛 xda.cn </p>
            <p>Designed by Sam Chen </p>
        </footer>
    </div>
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="${pageContext.request.contextPath}/content/script/jquery-1.10.2.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="${pageContext.request.contextPath}/content/bootstrap-3.0.3/dist/js/bootstrap.js"></script>

</body>
</html>