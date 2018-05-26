<%--
  Created by IntelliJ IDEA.
  User: qiuyuanjie
  Date: 2018/5/16
  Time: 18:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/easyui/icon.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/easyui/default/easyui.css">
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        function addTabs(obj  , url){
            //1 获得标题，a标签文本值
            var title = $(obj).text();
            //2 是否存在，存在选中，否则添加
            // 2.1 判断
            var ex = $("#tt").tabs("exists",title);
            if(ex){
                // 2.2 选中
                $("#tt").tabs("select",title);
            } else {
                // 2.3 添加
                var options = {
                    "title" : title,
                    "content" : "<iframe src='"+url+"' frameborder='0' height='100%' width='100%'></iframe>",
                    "closable" : true,

                };
                $("#tt").tabs("add",options);
            }
        }
    </script>
</head>
<body class="easyui-layout">
    <div data-options="region:'north',split:false" style="height:40px;background: #7F99BE">
        <span style="color:#fff;font-size:25px;font-weight: bold;">
            <img alt="" src="${pageContext.request.contextPath}/img/blocks.gif" style="height: 25px;">
            管理系统
        </span>
        <span style="float:right">欢迎当前用户:使用帮助 修改密码 退出系统</span>
    </div>
    <div data-options="region:'south',split:true" style="height:100px;">
        系统版本号:发布日期:
    </div>
    <div data-options="region:'west',title:'导航菜单',split:false" style="width:200px;" class="easyui-accordion">
        <div title="教师管理" data-options="iconCls:'icon-large-smartart',selected:true" style="overflow:auto;padding:10px;">
            <a id="btn" href="javascript:void(0)" class="easyui-linkbutton" onclick="addTabs(this,'${pageContext.request.contextPath}/teacherList.jsp')" data-options="iconCls:'icon-search',plain:true" style="width:100%;text-align:left">教师信息</a>
            <a id="btn" href="javascript:void(0)" class="easyui-linkbutton" onclick="addTabs(this,'${pageContext.request.contextPath}/studentList.jsp')"  data-options="iconCls:'icon-search',plain:true "style="width:100%;text-align:left">学生信息</a>
        </div>
        <div title="其他管理" data-options="iconCls:'icon-large-smartart',selected:true" style="overflow:auto;padding:10px;"></div>
    </div>
    <div id="tt" data-options="region:'center'" style="" class="easyui-tabs">
        <div title="欢迎使用" >
            tab1
        </div>
    </div>
</body>
</html>
