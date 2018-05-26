<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>师生列表</title>
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
	<script type="text/javascript">
        $(function () {
            // 在此完成代码
            var url = "/studentServlet";
            var params = {
                "method":"showStudent"
            };
            $.post(url, params, function (data) {
                for (var i = 0; i < data.length; i++) {
                    $("#showStudentId").append("<input type='button' value=\'"+data[i].name+"\'>");
                }
            },"json")
        });
	</script>
</head>
<body>
	<div class="container">
		<div class="panel panel-default">
			<div class="panel-heading text-center">
				<h2>学生列表</h2>
			</div>
			<div class="panel-heading ">
				<table class="table table-bookName">
					<thead>
						<tr>
							<th width="90" align="lift">&nbsp;</th>
							<th>
							</th>
						</tr>
					</thead>
				</table>
			</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>学生</th>
						</tr>
					</thead>
					<tbody>
						<tr id="showStudentId"></tr>
					</tbody>
				</table>
			</div>


		</div>
	</div>

</body>
</html>

