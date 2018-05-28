<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>商品列表</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">

<link
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="<%=request.getContextPath()%>/bootstrap/css/bootstrap-theme.min.css"
	rel="stylesheet">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/jquery-1.11.3.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>商品列表</h2>
			</div>
			<div class="panel-heading ">
				<table class="table table-bookName">
					<thead>
						<tr>
							<th width="90" align="lift">&nbsp;</th>
							<th><a
								href="${pageContext.request.contextPath}/CartServlet?method=look">查看购物车</a>
							</th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>商品名称</th>
							<th>商品型号</th>
							<th>商品单价</th>
							<th>购</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${productList}" var="ss">
							<tr>
								<td>${ss.name}</td>
								<td>${ss.type}</td>
								<td>${ss.price}</td>
								<td><a class="btn btn-info"
									   href="${pageContext.request.contextPath}/CartServlet?method=add&name=${ss.name}"
									   target="_blank">添加到购物车</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>


		</div>
	</div>

</body>
</html>

