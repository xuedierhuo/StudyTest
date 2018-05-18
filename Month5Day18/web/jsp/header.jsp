<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<script type="text/javascript">
	//1 请求路径
	var url = "${pageContext.request.contextPath}/CategoryServlet";
	//2 请求参数
	var params= {
		"method":"findAll"
	};
	//3 发送
	$.post(url,params,function( data ){
		//处理数组
		console.info(data);
		// categoryUL  --> <li><a href="#">电脑办公</a></li>
		for(var i = 0 ; i < data.length ; i ++){
			var category = data[i];
			$("#categoryUL").append("<li><a href='#'>"+category.cname+"</a></li>");
		}
	} , "json");
</script>

<!--
         	描述：菜单栏
         -->
<div class="container-fluid">
	<div class="col-md-4">
		<img src="${pageContext.request.contextPath}/img/logo2.png" />
	</div>
	<div class="col-md-5">
		<img src="${pageContext.request.contextPath}/img/header.png" />
	</div>
	<div class="col-md-3" style="padding-top:20px">
		<ol class="list-inline">
			<li><a href="${pageContext.request.contextPath}/jsp/login.jsp">登录</a></li>
			<li><a href="${pageContext.request.contextPath}/jsp/register.jsp">注册</a></li>
			<li><a href="${pageContext.request.contextPath}/jsp/cart.jsp">购物车</a></li>
			<li><a href="${pageContext.request.contextPath}/jsp/order_list.jsp">我的订单</a></li>
		</ol>
	</div>
</div>
<!--
         	描述：导航条
         -->
<div class="container-fluid">
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<!-- Brand and toggle get grouped for better mobile display -->
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
					<span class="sr-only">Toggle navigation</span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
					<span class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#">首页</a>
			</div>

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
				<ul id="categoryUL" class="nav navbar-nav">
					<!-- class="active" 
					<li><a href="#">电脑办公</a></li>
					-->
				</ul>
				<form class="navbar-form navbar-right" role="search">
					<div class="form-group">
						<input type="text" class="form-control" placeholder="Search">
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>

			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>
</div>