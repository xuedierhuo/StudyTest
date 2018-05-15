<%--
  Created by IntelliJ IDEA.
  User: XDerhuo
  Date: 2018/5/15
  Time: 9:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/css/easyui/default/easyui.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/css/easyui/icon.css" rel="stylesheet" type="text/css"/>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
    <script>
        $(function () {
            var columnArr = [[
                {field:'pid',title:'商品编号',width:100},
                {field:'pname',title:'商品名称',width:100},
                {field:'price',title:'商品价钱',width:100},
            ]];
            var options = {
                "url":"data.json",       //确定加载数据的位置
                "columns" : columnArr,
                "pagination":true,
                "pageSize" : 5,
                "pageList" : [5,10,15],
            };
            //渲染table
            $("#dg").datagrid( options );
        })
    </script>
</head>
<body>
    <table id="dg"></table>
</body>
</html>
