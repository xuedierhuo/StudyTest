<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>购物车</title>
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
				<h2>购物车</h2>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>商品名称</th>
							<th>商品型号</th>
							<th>商品单价</th>
							<th>购买数量</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${carts}" var="ss">
							<tr>
								<td>${ss.name}</td>
								<td>${ss.type}</td>
								<td>${ss.price}</td>
								<td>${ss.number}</td>
								<td><a class="btn btn-info"
									   href="${pageContext.request.contextPath}/CartServlet?method=delete&name=${ss.name}"
									   target="_blank">删除</a></td>
							<tr/>
						</c:forEach>


					</tbody>
				</table>
			</div>


		</div>
	</div>

</body>
</html>

