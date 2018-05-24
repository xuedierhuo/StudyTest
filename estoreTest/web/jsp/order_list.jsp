﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!doctype html>
<html>

	<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员登录</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>

		<style>
			body {
				margin-top: 20px;
				margin: 0 auto;
			}
			
			.carousel-inner .item img {
				width: 100%;
				height: 300px;
			}
		</style>
	</head>

	<body>

			<!-- 包含头部页面 -->
			<%@include file="header.jsp" %>

		<div class="container">
			<div class="row">

				<div style="margin:0 auto; margin-top:10px;width:950px;">
					<strong>我的订单</strong>
					<table class="table table-bordered">
						<c:forEach items="${pageInfo.list}" var="orders">
							<tbody>
								<tr class="success">
									<th colspan="2">订单编号:${orders.oid} </th>
									<th colspan="2">创建时间:${orders.ordertime} </th>
									<th colspan="1">创建用户:${orders.user.username} </th>
								</tr>
								<tr class="warning">
									<th>图片</th>
									<th>商品</th>
									<th>价格</th>
									<th>数量</th>
									<th>小计</th>
								</tr>
								<c:forEach items="${orders.orderItems}" var="item">
									<tr class="active">
										<td width="60" width="40%">
											<input type="hidden" name="id" value="22">
											<img src="${pageContext.request.contextPath}/${item.product.pimage}" width="70" height="60">
										</td>
										<td width="30%">
											<a target="_blank"> ${item.product.pname}</a>
										</td>
										<td width="20%">
											￥${item.product.shopPrice}
										</td>
										<td width="10%">
											${item.count}
										</td>
										<td width="15%">
											<span class="subtotal">￥${item.subtotal}</span>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</c:forEach>
					</table>
				</div>
			</div>
			<div style="text-align: center;">
				<ul class="pagination">
					<li><a href="${pageContext.request.contextPath}/OrderServlet?method=findByUid&pageNum=${pageInfo.firstPage}" aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
					<c:if test="${pageInfo.prePage > 0 }">
						<li><a href="${pageContext.request.contextPath}/OrderServlet?method=findByUid&pageNum=${pageInfo.prePage}" aria-label="Previous"><span aria-hidden="true"><</span></a></li>
					</c:if>
					<c:forEach begin="${begin}" end="${end}" var="index">
						<li class="${index == pageInfo.pageNum ? 'active' : ''}"><a href="${pageContext.request.contextPath}/OrderServlet?method=findByUid&pageNum=${index}">${index}</a></li>
					</c:forEach>
					<c:if test="${pageInfo.pageNum < pageInfo.pages}">
						<li>
							<a href="${pageContext.request.contextPath}/OrderServlet?method=findByUid&pageNum=${pageInfo.nextPage}" aria-label="Next">
								<span aria-hidden="true">></span>
							</a>
						</li>
					</c:if>
					<li>
						<a href="${pageContext.request.contextPath}/OrderServlet?method=findByUid&pageNum=${pageInfo.lastPage}"  aria-label="Next">
							<span aria-hidden="true">&raquo;</span>
						</a>
					</li>
				</ul>
			</div>
		</div>

		<div style="margin-top:50px;">
			<img src="${pageContext.request.contextPath}/img/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
		</div>

		<div style="text-align: center;margin-top: 5px;">
			<ul class="list-inline">
				<li><a href="${pageContext.request.contextPath}/jsp/info.jsp">关于我们</a></li>
				<li><a>联系我们</a></li>
				<li><a>招贤纳士</a></li>
				<li><a>法律声明</a></li>
				<li><a>友情链接</a></li>
				<li><a target="_blank">支付方式</a></li>
				<li><a target="_blank">配送方式</a></li>
				<li><a>服务声明</a></li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2005-2016 传智商城 版权所有
		</div>
	</body>

</html>