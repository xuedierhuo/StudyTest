<%--
  Created by IntelliJ IDEA.
  User: XDerhuo
  Date: 2018/5/14
  Time: 16:08
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
<body class="easyui-layout">
    <div data-options="region:'north',split:false" style="height:40px;background-color:#7F99BE;line-height: 38px;">
        <span style="color: #fff;font-size: 24px;font-weight: bold;">管理系统</span>
        <span style="float: right;">欢迎当前用户  ： 使用帮助  修改密码  退出登录</span>
    </div>
    <div data-options="region:'south',split:false" style="height:30px;">
        系统版本号
    </div>
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:200px;"  class="easyui-accordion">
        <div title="商品管理" data-options="iconCls:'icon-large-chart',selected:true" style="overflow:auto;padding:10px;">
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" style="width:100%;text-align:left;">11111</a>
            <a href="#" class="easyui-linkbutton" data-options="iconCls:'icon-search',plain:true" style="width:100%;text-align:left;">11123232</a>
        </div>
        <div title="分类管理" data-options="iconCls:'icon-large-chart'" style="padding:10px;">
            content2
        </div>
        <div title="用户管理" data-options="iconCls:'icon-large-chart'">
            content3
        </div>
        <div title="订单管理" data-options="iconCls:'icon-large-chart'">
            content4444
        </div>
    </div>
    <div data-options="region:'center'" style="padding:5px;background:#eee;">

    </div>
</body>
</html>
