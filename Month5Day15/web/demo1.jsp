<%--
  Created by IntelliJ IDEA.
  User: XDerhuo
  Date: 2018/5/15
  Time: 8:17
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
</head>
<body class="easyui-layout">
<div data-options="region:'north',title:'North Title',split:true" style="height:100px;"></div>
<div data-options="region:'south',title:'South Title',split:true" style="height:100px;"></div>
<div data-options="region:'east',iconCls:'icon-reload',title:'East',split:true" style="width:100px;"></div>
<div data-options="region:'west',title:'West',split:true" style="width:100px;"></div>
<div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;"></div>
</body>

</html>
