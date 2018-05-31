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
    <script type="text/javascript" src="/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="/js/jquery.easyui.min.js"></script>
    <link href="/css/default/easyui.css" rel="stylesheet">
    <link href="/css/icon.css" rel="stylesheet">
    <script type="text/javascript">
        $(function () {
            var columns = [[
                {field:'bookid',title:'图书ID',width:200},
                {field:'bookName',title:'图书名称',width:200},
                {field:'bookInfo',title:'图书简介',width:200},
                {field:'number',title:'馆藏数量',width:200},
            ]];

            var d1 = {
                url:'/BookServlet?method=findAll',
                columns: columns,
                pageSize:2,
                pageList:[2,4,6,8],
                pagination : true
            };

            $('#tb').datagrid(d1);
            // var col = [[
            //     {field:'code',title:'Code',width:100},
            //     {field:'name',title:'Name',width:100},
            //     {field:'price',title:'Price',width:100,align:'right'}
            // ]];
            // var d1 = {
            //     url:'/BookServlet?method=findAll',
            //     columns: col,
            //     pagination : true,
            // };
            // $('#tb').datagrid(d1);
        })
    </script>
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
            <table class="table table-hover" id="tb">
                <%--<thead>
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
                        <td><a class="btn btn-info" href="${pageContext.request.contextPath}/LoanServlet?method=loan&bookid=${book.bookid}" >借阅</a></td>
                    </tr>
                </c:forEach>
                </tbody>--%>
            </table> 
        </div>

        
    </div>
</div>



<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</body>
</html>

