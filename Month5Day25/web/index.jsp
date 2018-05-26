<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

	<head>
		<meta charset="UTF-8">
		<title>传智专修学院</title>
		<meta name="keywords" content="传智专修学院">
		<meta name="content" content="传智专修学院">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1">
		<link type="text/css" rel="stylesheet" href="bootstrap/css/login.css">

	</head>

	<body class="login_bj">
		<div class="zhuce_body">
			<div class="logo">
				<a href="#"><img src="bootstrap/images/czxylogo.png" height="54" border="0"></a>
			</div>
			<div class="zhuce_kong login_kuang">
				<div class="zc">
					<div class="bj_bai">
						<h3>登录</h3>
						<form action="${pageContext.request.contextPath}/UserServlet" method="post">
							<input type="hidden" name="method" value="join">
							<input name="loginname" value="" type="text" class="kuang_txt" placeholder="账号">
							<input name="password" value="" type="password" class="kuang_txt" placeholder="密码">
							<div>
								${msg }
								${message}
							</div>
							<div>
								<!-- 游客模式 -->
								<a href="${pageContext.request.contextPath}/ProductServlet?method=findAll">游客模式</a>
								<a href="${pageContext.request.contextPath}/login.jsp">注册</a>
							</div>
							<input type="submit" class="btn_zhuce" value="登录">
							
						</form>
					</div>
					<div class="bj_right">
						<p>使用以下账号直接登录</p>
						<a href="#" class="zhuce_qq">QQ注册</a>
						<a href="#" class="zhuce_wb">微博注册</a>
						<a href="#" class="zhuce_wx">微信注册</a>
						<p>已有账号？
							<a href="#">立即登录</a>
						</p>

					</div>
				</div>
				<P>www.czxy.com&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;传智专修学院欢迎您</P>
			</div>

		</div>

	</body>

</html>