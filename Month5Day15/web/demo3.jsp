<%--
  Created by IntelliJ IDEA.
  User: XDerhuo
  Date: 2018/5/15
  Time: 10:34
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
        function editProduct(word) {
            alert(word);
        }
        function deleteProduct(word) {
            alert(word);
        }
        $(function () {
            var columnArr = [[
                {field:'pid',title:'商品编号',width:100},
                {field:'pname',title:'商品名称',width:100},
                {field:'price',title:'商品价钱',width:100},
                /*图片列*/
                {field:'pimage',title:'图片',width:100,
                    /*格式化图片*/
                    formatter:function (value, row, index) {
                        return "<img src= '"+value+"' style = 'height:50px' />";
                    }
                },
                /*操作列*/
                {field : 'aaa', title : '操作', width:100,
                    /*row属性代表整行信息*/
                    formatter:function (value, row) {
                        return "<a href='javascript:void(0)' onclick=\"editProduct(' "+row.pid+" ')\">修改</a>" +
                            " <a href='javascript:void(0)' onclick=\"deleteProduct(' "+row.pid+" ') \">删除</a>"
                    }
                },
            ]];
            var options = {
                "url":"data.json",       //确定加载数据的位置
                "columns" : columnArr,
                "pagination":true,
                "pageSize" : 10,
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
