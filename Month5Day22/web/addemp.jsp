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
		<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
		<style>
			.admin-main {
				padding-top: 100px;
			}
		</style>
		<script type="text/javascript">
		     $(function(){
		    	
		    	
		     })
		</script>
	</head>

	<body>

		<div class="am-cf admin-main">
			<!-- content start -->
			<div class="admin-content">
				<div class="admin-content-body">
					<div class="am-g">
						<form class="am-form am-form-horizontal" action="/emp" method="post" style="padding-top: 30px;">
							<input value="add" name="method" type="hidden">
							
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
								姓名
								</label>
								<div class="am-u-sm-9">
									<input id="roleName" required="" placeholder="请输入姓名"  name="ename" type="text">
									
								</div>
							</div>
							
							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
								邮箱
								</label>
								<div class="am-u-sm-9">
									<input id="roleName"  placeholder="请输入邮箱"  name="email" type="text">
									
								</div>
							</div>

							<div class="am-form-group">
								<label for="user-name" class="am-u-sm-3 am-form-label">
									
									</label>
								<div class="am-u-sm-9" style="line-height: 30px;">
									<input type="radio"  name="sex" value="男" />
									<label for="man">
											男
										</label> &nbsp;&nbsp;&nbsp;&nbsp;
									<input type="radio" name="sex" value="女" />
									<label for="woman">
											女
										</label>
									<br />
									
								</div>
							</div>

							<div class="am-form-group">
								<label for="user-email" class="am-u-sm-3 am-form-label">
										部门
									</label>
								<div class="am-u-sm-9">
									<select name="deptno"  id="deptnoSelect">
										<option >请选择部门</option>
										<c:forEach items="${list}" var="dept" varStatus="s">
											<option value="${s.count*10}">${dept.dname}</option>
										</c:forEach>
									</select>
									
								</div>
							</div>
							<div class="am-form-group">
								<div class="am-u-sm-9 am-u-sm-push-3">
									<input id="addRole" class="am-btn am-btn-success" value="添加员工" type="submit">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</body>

</html>