<%--
  Created by IntelliJ IDEA.
  User: XDerhuo
  Date: 2018/5/14
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="css/icon.css">
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
    <div id="tt" class="easyui-tabs" style="width:500px;height:250px;">
        <div title="Tab1">
            tab1
        </div>
        <div title="Tab2" data-options="closable:true">
            tab2
        </div>
        <div title="Tab3" data-options="iconCls:'icon-reload',closable:true">
            tab3
        </div>
    </div>
</body>
</html>
