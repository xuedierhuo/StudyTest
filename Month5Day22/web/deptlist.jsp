<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
							<i class="icon-home"></i> &gt; 首页 &gt; 部门管理
						</small>
					</div>
				</div>
				<hr>
				<div class="container">
					<div class="am-g">
						<div class="am-u-sm-12 am-u-md-6">
							<div class="am-btn-toolbar"></div>
						</div>
						<div class="am-u-sm-12 am-u-md-3">
							<form action="${pageContext.request.contextPath}/dept" method="post">
								<input name="method" hidden="hidden" value="findDeptList"/>
								<div class="am-input-group am-input-group-sm">
									<input class="am-form-field" name="dname"
										placeholder="请输入部门名称" type="text"> <span
										class="am-input-group-btn">
										<button class="am-btn am-btn-default" type="submit">搜索</button>
									</span>
								</div>
							</form>
						</div>
					</div>

					<div class="am-g" style="margin-top: -30px;">
						<div class="am-u-sm-12">
							<form class="am-form">
								<table
									class="am-table am-table-striped am-table-hover table-main">
									<thead>
										<tr>
											<th class="table-check"><input id="chkAll"
												type="checkbox"></th>
											<th class="table-id">ID</th>
											<th class="table-title">部门名称</th>
											<th class="table-title">部门所在地</th>
											<th class="table-set">操作</th>
										</tr>
									</thead>
									<tbody id="tUser">
									
											<c:forEach items="${list}" var="dept" >
												<tr>
													<td><input name="chks" value="27" type="checkbox"></td>
													<td>${dept.deptno}</td>
													<td>${dept.dname}</td>
													<td>${dept.loc}</td>
													<td>
														<div class="am-btn-toolbar">
															<button type="button">编辑</button>
															<button type="button">删除</button>
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

	<script>
		$(function() {
			$(".btnedit").click(function() {
				$.jq_Panel({
					title : "修改部门",
					iframeWidth : 500,
					iframeHeight : 300,
					url : "addDepart.html"
				});
			});
			$(".btnAdd").click(function() {

				$.jq_Panel({
					title : "添加部门",
					iframeWidth : 500,
					iframeHeight : 300,
					url : "addDepart.html"
				});
			});
		});
	</script>
</body>

</html>