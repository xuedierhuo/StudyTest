<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>预约详情页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">

<link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">

<link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
     	   	<h2>新增图书</h2>
        </div>
        <div class="panel-body">
			<table class="table table-hover">
				<thead>
				<tr>
					<th>预定学号</th>
					<th>预约时间</th>
					<th>图书ID</th>
					<th>图书名称</th>
					<th>图书简介</th>
					<th>预约数量</th>
				</tr>
				</thead>
				<tbody>
				<c:forEach items="${loanList}" var="loan">
					<tr>
						<td>${loan.uid}</td>
						<td>${loan.loantime}</td>
						<td>${loan.book.bookid}</td>
						<td>${loan.book.bookName}</td>
						<td>${loan.book.bookInfo}</td>
						<td>${loan.loannumber}</td>
					</tr>
				</c:forEach>
				</tbody>
				<div class="panel-body text-center">
					<h2 class="text-danger">
						<span class="glyphicon"><a class="btn btn-primary btn-lg" href="${pageContext.request.contextPath}/LoanServlet?method=findAllBook" >继续借阅</a></span>
					</h2>
				</div>
			</table>
		</div>
            		  
</div>
  

</body>


</html>
