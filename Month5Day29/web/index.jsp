<%--
  Created by IntelliJ IDEA.
  User: XDerhuo
  Date: 2018/5/29
  Time: 8:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <link rel="stylesheet" type="text/css" href="/css/default/easyui.css"/>
    <link rel="stylesheet" type="text/css" href="/css/icon.css"/>
    <script src="/js/jquery-1.11.3.js" type="text/javascript"></script>
    <script src="/js/jquery.easyui.min.js" type="text/javascript"></script>
    <script>
      $(function () {
          var columns = [[
              {field:'code',title:'Code',width:100},
              {field:'name',title:'Name',width:100},
              {field:'price',title:'Price',width:100,align:'right'}
          ]];
          var option = {
              url:'datagrid_data.json',
              columns: columns,
              pagination:true,
          };
          $('#dg').datagrid( option );
      })
    </script>
  </head>
  <body>
  <table id="dg"></table>
  </body>
</html>
