<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.sams.com/tags" prefix="sams"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>论坛主题</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="./论坛主题_files/bootstrap.css" rel="stylesheet" media="screen">
<!-- Custom CSS -->
<link href="./论坛主题_files/main.css" rel="stylesheet">
<script src="./论坛主题_files/jquery-1.10.2.js.下载"></script>
<style type="text/css">
#fanye {
	margin-top: 20px;
	text-align: center;
}

div.pager a {
	text-decoration: none;
	border: solid 1px gray;
	padding: 1px 3px;
}

div.pager span.current {
	padding: 1px 3px;
	background-color: gray;
	color: white;
}

div.pager span.pageInfo {
	margin-left: 10px;
}
</style>
</head>
<body style="">
	<div class="container">
		<header>
		<div id="logo">
			<img src="./论坛主题_files/logo.png" alt="">
		</div>
		<nav class="navbar navbar-default">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#navbar-collapse-menu">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="http://localhost:8080/mycommunity/#">首页</a>
		</div>
		<div class="collapse navbar-collapse" id="navbar-collapse-menu">

			<form action="http://localhost:8080/mycommunity/search_result"
				method="get" class="navbar-form navbar-left" role="search">
				<div class="form-group">
					<input type="text" name="title" value="" class="form-control"
						placeholder="主题">
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
		</nav> </header>

		<div class="content">
			<form id="submitForm" method="post"></form>
			<script type="text/javascript">
				
			</script>

			<ol class="breadcrumb">
				<li><a href="http://localhost:8080/mycommunity/#">首页</a></li>
				<li><a href="http://localhost:8080/mycommunity/forum/3">Android
						讨论区</a></li>
				<li>${topic.title}</li>
			</ol>

			<div id="topic-detail">
				<c:if test="${pageNum==1 }">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td class="col-md-2 topic-title">昵称：${topic.user.nickname}</td>
								<td>标题：${topic.title} <span class="pull-right"><a
										class="mail" href="http://localhost:8080/mycommunity/#"
										data-receiver="gdglc">发邮件</a></span>
								</td>
							</tr>
							<tr>
								<td class="topic-title"><img src="./论坛主题_files/1.jpg"
									alt="" class="user"></td>
								<td>${topic.content}<br> <br> <br> <span
									class="pull-right">——${topic.user.signature}</span>
								</td>
							</tr>
							<tr>
								<td class="topic-title">积分：${topic.user.grade}</td>
								<td>发表时间：${topic.updateTime} <span class="pull-right">${topic.iP}</span>
								</td>
							</tr>
						</tbody>
					</table>
				</c:if>
				<c:forEach var="c" items="${comments}" varStatus="vs">
					<table class="table table-bordered">
						<tbody>
							<tr>
								<td class="col-md-2 topic-title">昵称：${c.user.nickname}</td>
								<td><span class="floor"> <c:if
											test="${pageNum==1 || pageNum==0}">${vs.index+2}楼</c:if> <c:if
											test="${pageNum>1}">${vs.index+1+(pageNum-1)*5}楼</c:if>
								</span> <span class="pull-right"><a class="mail"
										href="http://localhost:8080/mycommunity/#"
										data-receiver="jack">发邮件</a></span></td>
							</tr>
							<tr>
								<td class="topic-title"><img src="./论坛主题_files/2.jpg"
									alt="" class="user"></td>
								<td>${c.content}<br> <br> <br> <span
									class="pull-right">——${c.user.signature}</span>
								</td>
							</tr>
							<tr>
								<td class="topic-title">积分：${c.user.grade}</td>
								<td>发表时间：${c.topic.updateTime} <span class="pull-right">IP:${c.topic.iP}</span>
								</td>
							</tr>
						</tbody>
					</table>

				</c:forEach>

				<c:if test="${loginUser!= null}">
					<div class="row">
						<div class="col-lg-12">
							<div class="panel panel-default">
								<table class="table table-striped">
									<tr>
										<td colspan="2" style="text-indent: 2em;">回复</td>
									</tr>
									<tr>
										<td colspan="2">
											<form action="published" style="margin-left: 60px;">
												<table>
													<tr>
														<td>内容</td>
														<td><textarea name="content" rows="2" cols="135"></textarea></td>
													</tr>
													<tr>
														<td><input type="hidden" name="rid"
															value="${referenceId}" /></td>
														<td><button type="submit">发表</button></td>
													</tr>
												</table>
											</form>
										</td>
									</tr>
								</table>
							</div>
						</div>
					</div>
				</c:if>

				<div id="fanye">
					<sams:pager urlFormat="comment?id=${param.id}&pageNum=%d"
						pageSize="1" numbers="5" totalRows="${totalPages}"
						curPage="${param.pageNum}" />
				</div>

			</div>


			<footer id="footer" class="panel-footer">
			<p>手机论坛 xda.cn</p>
			<p>Designed by Sam Chen</p>
			</footer>

		</div>
		<!-- Include all compiled plugins (below), or include individual files as needed -->
		<script src="./论坛主题_files/bootstrap.js.下载"></script>
</body>
</html>