<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Hellow Bootstrap V3</title>
<!-- Bootstrap -->
<link
	href="${pageContext.request.contextPath}/content/bootstrap-3.0.3/css/bootstrap.css"
	rel="stylesheet" media="screen">
<!-- Custom CSS -->
<link href="${pageContext.request.contextPath}/content/css/main.css"
	rel="stylesheet">

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
			<li class="active"><a href="personal/person">个人主页</a></li>
			<li class="dropdown"><a href="#" class="dropdown-toggle"
				data-toggle="dropdown">我的邮箱<b class="caret"></b></a>
				<ul class="dropdown-menu">
					<li><a href="#">收件箱</a></li>
					<li><a href="#">发件箱</a></li>
					<li class="divider"></li>
					<li><a href="#">回收站</a></li>
				</ul></li>
		</ul>
		<form class="navbar-form navbar-left" role="search">
			<div class="form-group">
				<input type="text" class="form-control" placeholder="主题">
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
		<div class="row">
			<div class="col-lg-6">
				<div id="banner" class="carousel slide">
					<ol class="carousel-indicators">
						<li data-target="#banner" data-slide-to="0" class=""></li>
						<li data-target="#banner" data-slide-to="1" class=""></li>
						<li data-target="#banner" data-slide-to="2" class=""></li>
						<li data-target="#banner" data-slide-to="3" class="active"></li>
					</ol>
					<!-- Wrapper for slides -->
					<div class="carousel-inner">
						<div class="item">
							<img
								src="${pageContext.request.contextPath}/content/pictures/banner/okwu.jpg"
								alt="OKWU.edu Homepage">
						</div>
						<div class="item">
							<img
								src="${pageContext.request.contextPath}/content/pictures/banner/okwu-athletics.jpg"
								alt="OKWU Athletics Homepage">
						</div>
						<div class="item">
							<img
								src="${pageContext.request.contextPath}/content/pictures/banner/bartlesvillecf.jpg"
								alt="Bartlesville Community Foundation">
						</div>
						<div class="item active">
							<img
								src="${pageContext.request.contextPath}/content/pictures/banner/emancipation.jpg"
								alt="Emancipation Stories">
						</div>
					</div>
					<!-- /.carousel-inner -->

					<!-- Controls -->
					<a class="left carousel-control" href="#banner" data-slide="prev">
						<span class="chevron">&lt;</span>
					</a> <a class="right carousel-control" href="#banner" data-slide="next">
						<span class="chevron">&gt;</span>
					</a>
				</div>
			</div>
			<div class="col-md-6">
				<h4>
					<strong>热门话题</strong>
				</h4>
				<ul class="list-group">
				   <c:forEach var="t" items="${topics}">
				   		<li class="list-group-item"><span class="badge">回复：${t.commentTimes}</span>
						${t.title}</li>
				   </c:forEach>
					
				</ul>
			</div>
		</div>
		<div class="row">		
			<c:forEach var="c" items="${forums}">
				<c:if test="${c.parentId==null}">
					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<div class="panel-heading">${c.name}</div>
							</div>
						</div>
					</div>
					<c:forEach var="f" items="${c.list}">
						<div class="col-md-3">
							<div class="thumbnail">
								<img
									src="${pageContext.request.contextPath}/content/pictures/forum/forum_${f.id}_icon.png"
									alt="">
								<h3><a href="topic-list?forumId=${f.id}">${f.name}</a></h3>
								<p>${f.description}</p>
							</div>
						</div>
					</c:forEach>
				</c:if>
			</c:forEach>

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