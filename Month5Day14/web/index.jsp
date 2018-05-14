<%--
  Created by IntelliJ IDEA.
  User: XDerhuo
  Date: 2018/5/14
  Time: 15:04
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
  <body>
    <h2>Basic TextBox</h2>
    <p>The textbox allows a user to enter information.</p>
    <div style="margin:20px 0;"></div>
    <div class="easyui-panel" title="Register" style="width:400px;padding:30px 60px">
      <div style="margin-bottom:20px">
        <div>Email:</div>
        <input class="easyui-textbox" data-options="prompt:'Enter a email address...',validType:'email'" style="width:100%;height:32px">
      </div>
      <div style="margin-bottom:20px">
        <div>First Name:</div>
        <input class="easyui-textbox" style="width:100%;height:32px">
      </div>
      <div style="margin-bottom:20px">
        <div>Last Name:</div>
        <input class="easyui-textbox" style="width:100%;height:32px">
      </div>
      <div style="margin-bottom:20px">
        <div>Company:</div>
        <input class="easyui-textbox" style="width:100%;height:32px">
      </div>

      <div>
        <a href="#" class="easyui-linkbutton" iconCls="icon-ok" style="width:100%;height:32px">Register</a>
      </div>
    </div>
  </body>
</html>
