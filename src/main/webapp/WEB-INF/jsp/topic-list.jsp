<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.sams.com/tags" prefix="sams" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录</title>
<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/content/bootstrap-3.0.3/css/bootstrap.css"
	rel="stylesheet" media="screen">
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/content/css/main.css"
	rel="stylesheet">
<style type="text/css">
	#fanye{margin-top: 20px;text-align: center;}
	div.pager a{
		text-decoration: none;
		border: solid 1px gray;
		padding: 1px 3px;
	}
	div.pager span.current{
		padding: 1px 3px;
		background-color: gray;
		color: white;
	}
	div.pager span.pageInfo{
		margin-left: 10px;
	}
</style>
</head>
<body>
	<div id="logo">
		<img
			src="${pageContext.request.contextPath}/content/css/images/logo.png"
			alt="" />
	</div>
	<nav class="navbar navbar-default">
	<div class="navbar-header">
		<button type="button" class="navbar-toggle" data-toggle="collapse"
			data-target="#navbar-collapse-menu">
			<span class="sr-only">Toggle navigation</span> <span class="icon-bar"></span>
			<span class="icon-bar"></span> <span class="icon-bar"></span>
		</button>
		<a class="navbar-brand" href="#">首页</a>
	</div>
	<div class="collapse navbar-collapse" id="navbar-collapse-menu">
		<ul class="nav navbar-nav">
			<li class="active"><a href="#">个人主页</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">我的邮箱<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#">收件箱</a></li>
					<li><a href="#">发件箱</a></li>
					<li class="divider"></li>
					<li><a href="#">回收站</a></li>
				</ul></li>
		</ul>
		<form class="navbar-form navbar-left" role="search" action="topic-list">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="主题" name="title">
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
			    <li><a href="remove">注销</a></li>
		   </c:if>
		</ul>
	</div>
	</nav>
	</header>
	</div>
	<div class="container">
		<div class="panel panel-default">
		  	<div class="panel-heading">Android讨论区-精华区</div>
		  	<table class="table table-striped">
		  		<thead>
		  			<tr><th>主题</th><th>作者</th><th>回复</th><th>最后更新时间</th></tr>
		  		</thead>
		  		<tbody>
		  		<c:forEach var="c" items="${elitetopics}">
			  		<tr><td><a href="comment?id=${c.id}">${c.title}</a><td>${c.user.nickname}</td><td>${c.commentTimes}/${c.clicks}</td><td>${c.updateTime}</td></tr>
				</c:forEach>
		  		</tbody>
		  	</table>
		</div>
		<div class="panel panel-default">
		  	<div class="panel-heading">Android讨论区-讨论区</div>
		  	<table class="table table-striped">
		  		<thead>
		  			<tr><th>主题</th><th>作者</th><th>回复</th><th>最后更新时间</th></tr>
		  		</thead>
		  		<tbody>
		  		<c:forEach var="c" items="${generaltopics}">
			  		<tr><td><a href="comment?id=${c.id}">${c.title}</a></td><td>${c.user.nickname}</td><td>${c.commentTimes}/${c.clicks}</td><td>${c.updateTime}</td></tr>
				</c:forEach>
		  		</tbody>
		  	</table>
		  	<div id="fanye">
				<sams:pager urlFormat="topic-list?forumId=${param.forumId}&pageNum=%d&title=${param.title}"
				pageSize="1" numbers="5" totalRows="${totalPages}" curPage="${param.pageNum}" />
			</div>
		</div>
	</div>
	<div class="container">
		<footer id="footer" class="panel-footer">
		<p>手机论坛 xda.cn</p>
		<p>Designed by Sam Chen</p>
		</footer>
	</div>
	<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
	<script
		src="${pageContext.request.contextPath}/content/script/jquery-1.10.2.js"></script>
	<!-- Include all compiled plugins (below), or include individual files as needed -->
	<script
		src="${pageContext.request.contextPath}/content/bootstrap-3.0.3/dist/js/bootstrap.js"></script>

</body>
</html>