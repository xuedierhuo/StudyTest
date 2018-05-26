<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>图书列表</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">

<link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">

<link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap-theme.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
            <h2>图书列表</h2>
        </div>
        <form name="firstForm" action="/books/search" method="post">
        	<div class="panel-heading ">
        	    <table class="table table-bookName">
        	       <thead>
        	       		<tr> 
        					<%--<th width="90" align="lift">图书名称：</th>
        					<th width="150" align="lift">
        						<input type="text" name="name" class="allInput" value="" placeholder="输入检索书名" />
        					</th>
        					<th> 
        						<input type="submit" id="tabSub" value="检索" /> 
        					</th> --%>
        				</tr> 
        	       </thead> 
        	    </table> 
         	</div>
        </form>
       
        
        <div class="panel-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>图书ID</th>
                    <th>图书名称</th>
                    <th>图书简介</th>
                    <th>馆藏数量</th>
                    <th>预约</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${bookList}" var="book">
                    <tr>
                        <td>${book.bookid}</td>
                        <td>${book.bookName}</td>
                        <td>${book.bookInfo}</td>
                        <td>${book.number}</td>
                        <td><a class="btn btn-info" href="${pageContext.request.contextPath}/BookServlet?method=loan&bookid=${book.bookid}" >借阅</a></td>
                    </tr>
                </c:forEach>
                </tbody>
            </table> 
        </div>

        
    </div>
</div>



<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>

<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>

