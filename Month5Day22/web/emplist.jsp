<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

	<head>
		<meta charset="UTF-8">
		<title></title>

		<link rel="stylesheet" href="css/amazeui.min.css">
		<link rel="stylesheet" href="css/admin.css">
		<link rel="stylesheet" href="css/app.css">
	</head>

	<body>

		<div class="am-cf admin-main">
			<!-- content start -->
			<div class="admin-content">
				<div class="admin-content-body">
					<div class="am-cf am-padding am-padding-bottom-0">
						<div class="am-fl am-cf">
							<strong class="am-text-primary am-text-lg"> </strong><small>
								<i class="icon-home"></i> &gt; 首页 &gt; 员工管理</small>
						</div>
					</div>
					<hr>
					<div class="container">
						<div class="am-g">
							<div class="am-u-sm-12 am-u-md-6">
								<div class="am-btn-toolbar">
									<div class="am-btn-group am-btn-group-xs">
										<%--<button type="button" class="am-btn am-btn-default btnAdd">--%>
											<%--<span class="icon-plus"></span> --%>
										<a href="${pageContext.request.contextPath}/dept?method=toAdd">添加员工</a>
										<%--</button>--%>
									</div>
								</div>
							</div>
						</div>
						<div class="am-g" style="margin-top: -30px;">
							<div class="am-u-sm-12">
								<form class="am-form" action="user/delAll.action">
									<table class="am-table am-table-striped am-table-hover table-main">
										<thead>
											<tr>
												<th class="table-check">
													<input id="chkAll" type="checkbox">
												</th>
												<th class="table-id">
													ID
												</th>
												
												<th class="table-title">
													员工姓名
												</th>
												<th>
													性别
												</th>
												<th>
													部门名称
												</th>
												<th>
													邮箱
												</th>
												<th class="table-set">
													操作
												</th>
											</tr>
										</thead>
										<tbody id="tUser">
											<c:forEach items="${list}" var="emp">
												<tr>
													<td><input name="ids" value="1" type="checkbox"></td>
													<td>${emp.empno}</td>
													<td>
														<a href="#">${emp.ename}</a>
													</td>
													<td><span class="am-badge am-badge-secondary">${emp.sex}</span></td>
													<td>${emp.dept.dname}</td>
													<td>${emp.email}</td>
													<td>
														<div class="am-btn-toolbar">
															<button type="button"> 编辑</button>
															<button type="button"> 删除</button>
														</div>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>

								</form>
							</div>
						</div>
					</div>

				</div>
				<!-- content end -->
			</div>
		</div>

		<!--[if lt IE 9]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="assets/js/amazeui.ie8polyfill.min.js"></script>
<![endif]-->

		<!--[if (gte IE 9)|!(IE)]><!-->
		<script src="js/jquery-1.11.3.min.js"></script>
		<!--<![endif]-->
		<script type="text/javascript" src="myplugs/js/plugs.js"></script>
			
	</body>

</html>