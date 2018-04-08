<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人主页</title>
<!-- Bootstrap -->
<link href=".././个人主页_files/bootstrap.css" rel="stylesheet" media="screen">
    <!-- Custom CSS -->
    <link href=".././个人主页_files/main.css" rel="stylesheet">
    <script src=".././个人主页_files/jquery-1.10.2.js.下载"></script>
</head>
<body>
	  <div class="container">
  		

<header>
    <div id="logo">
        <img src=".././个人主页_files/logo.png" alt="">
    </div>
    <nav class="navbar navbar-default">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#navbar-collapse-menu">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
        </button>
            <a class="navbar-brand" href="http://localhost:8080/mycommunity/#">首页</a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-collapse-menu">
        	
            <ul class="nav navbar-nav">
                <li class="active"><a href="http://localhost:8080/mycommunity/personal">个人主页</a></li>
                <li class="dropdown">
                    <a href="http://localhost:8080/mycommunity/#" class="dropdown-toggle" data-toggle="dropdown">我的邮箱<b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li><a href="http://localhost:8080/mycommunity/message/receive_list">收件箱</a></li>
                        <li><a href="http://localhost:8080/mycommunity/message/send_list">发件箱</a></li>
                        <li class="divider"></li>
                        <li><a href="http://localhost:8080/mycommunity/message/create">编写新邮件</a></li>
                    </ul>
                </li>
                <li>
                	
                	<a href="http://localhost:8080/mycommunity/create_topic">发表主题</a>
                	
                </li>
            </ul>
            
            <form action="http://localhost:8080/mycommunity/search_result" method="get" class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <input type="text" name="title" value="" class="form-control" placeholder="主题">
                </div>
                <button type="submit" class="btn btn-default">搜索</button>
            </form>
            <ul class="nav navbar-nav navbar-right">
            
            <c:if test="${loginUser==null}">
		   		<li><a href="login">登录</a></li>
			    <li><a href="register">注册</a></li>
		   </c:if>
		    <c:if test="${loginUser!=null}">
		   		<li>您好,${loginUser.nickname}</li>
			    <li><a href="../remove">注销</a></li>
		   </c:if>
			
            </ul>
        </div>
    </nav>
</header>
    
    	<div class="content">
        	

<script type="text/javascript" src=".././个人主页_files/jquery.validate.js.下载"></script>
<script type="text/javascript">
	$(function(){
		$("#personalForm").validate({
			rules:{
				password:{required:true},
				passwordAgain:{equalTo:"#password"},
				headmage: { accept: "jpg" },
				nickname:{required:true}
			},
			messages:{
				password:{required:"请填写密码"},
				passwordAgain:{equalTo:"两次输入的密码须一致"},
				headImage:{accept:"头像应该是jpg图片"},
				nickname:{required:"请填写昵称"}
			},
			errorPlacement: function(error, element) {	//重写错误的定位，把错误定位在与父div同级的末尾  
			    error.appendTo(element.parents("div[class='form-group']"));  
			},
			errorClass:"error"
		});
	});
</script>
<ol class="breadcrumb">
  <li><a href="../index">首页</a></li>
  <li><a href="person">个人主页</a></li>
</ol>
<div class="row">
    <div class="col-lg-6">
        <form id="personalForm" action="update" method="post" enctype="multipart/form-data" class="form-horizontal" role="form" novalidate="novalidate">
        	<input type="hidden" name="user.id" value="${loginUser.id}">
        	<div class="form-group" id="room">
                <label for="head-image" class="col-sm-3 control-label">上传头像</label>
                <div class="col-sm-5">
                	<div class="head-image"><img class="head-image" src="headImage/${loginUser.id}.jpg" alt=""></div>
                    <input type="file" id="head-image" name="headImage">
                </div>
            </div>
            <div class="form-group" id="room">
                <label for="username" class="col-sm-3 control-label">用户名</label>
                <div class="col-sm-5">
                    <input type="text" id="username" disabled="disabled" value="${loginUser.username}" name="user.username" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label for="password" class="col-sm-3 control-label">密码</label>
                <div class="col-sm-5">
                    <input type="password" id="password" name="password" class="form-control" placeholder="密码" value="${loginUser.password}">
                </div>
            </div>
            <div class="form-group">
                <label for="passwordAgain" class="col-sm-3 control-label">密码确认</label>
                <div class="col-sm-5">
                    <input type="password" id="passwordAgain" name="user.password" class="form-control" placeholder="密码确认">
                </div>
            </div>
            <div class="form-group" id="room">
                <label for="nickname" class="col-sm-3 control-label">昵称</label>
                <div class="col-sm-5">
                    <input type="text" id="nickname" name="user.nickname" value="${loginUser.nickname}" class="form-control" placeholder="昵称">
                </div>
            </div>
            <div class="form-group" id="room">
                <label for="signature" class="col-sm-3 control-label">个性签名</label>
                <div class="col-sm-5">
                    <input type="text" id="signature" name="user.signature" value="${loginUser.signature}" class="form-control" placeholder="个性签名">
                </div>
            </div>
            <div class="form-group" id="room">
                <label for="grade" class="col-sm-3 control-label">积分</label>
                <div class="col-sm-5">
                    <input type="text" id="grade" name="user.grade" value="${loginUser.grade}" disabled="disabled"  class="form-control">
                </div>
            </div>
            <div class="form-group" id="room">
                <label for="emial" class="col-sm-3 control-label">Email</label>
                <div class="col-sm-5">
                    <input type="text" id="email" disabled="disabled" name="user.email" value="${loginUser.email}" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <div class="col-sm-offset-3 col-sm-10">
                    <button type="submit" class="btn btn-default">修改</button>
                    <a href="../index" class="btn btn-default">回到首页</a>
                </div>
            </div>
            
        </form>
    </div>
</div>
    	</div>
    
		
<footer id="footer" class="panel-footer">
    <p>手机论坛 xda.cn </p>
    <p>Designed by Sam Chen </p>
</footer>

    </div>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src=".././个人主页_files/bootstrap.js.下载"></script>

</body>
</html>