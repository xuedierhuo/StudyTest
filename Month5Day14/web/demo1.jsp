<%--
  Created by IntelliJ IDEA.
  User: XDerhuo
  Date: 2018/5/14
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <!--
      easyui.css 是easyui的总样式表
      icon.css是图标样式表
      jquery.min.js是jQuery支持，必须在EasyUI之前导入
      jquery.easyui.min.js是EasyUI组件
      easyui-lang-zh_CN.js是中文支持
    -->
    <link rel="stylesheet" type="text/css" href="css/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="css/default/icon.css">
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/easyui-lang-zh_CN.js"></script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',split:false" style="height:40px;background-color:#7F99BE;line-height: 38px;">
        <span style="color: #fff;font-size: 24px;font-weight: bold;">管理系统</span>
        <span style="float: right;">欢迎当前用户  ： 使用帮助  修改密码  退出登录</span>
    </div>
    <div data-options="region:'south'" style="height:30px;">
        系统版本号
    </div>
    <div data-options="region:'west',title:'导航菜单',split:true" style="width:200px;">

    </div>
    <div data-options="region:'center'" style="padding:5px;background:#eee;">

    </div>
</body>


</html>
