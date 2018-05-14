<%--
  Created by IntelliJ IDEA.
  User: XDerhuo
  Date: 2018/5/14
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="css/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="css/default/icon.css">
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>

</head>
<body>
    <div id="aa" class="easyui-accordion" style="width:300px;height:200px;">
        <div title="Title1" data-options="iconCls:'icon-save'" style="overflow:auto;padding:10px;">
            <h3 style="color:#0099FF;">Accordion for jQuery</h3>
            <p>Accordion is a part of easyui framework for jQuery.
                It lets you define your accordion component on web page more easily.</p>
        </div>
        <div title="Title2" data-options="iconCls:'icon-reload',selected:true" style="padding:10px;">
            content2
        </div>
        <div title="Title3">
            content3
        </div>
    </div>

</body>
</html>
