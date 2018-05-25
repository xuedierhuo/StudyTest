<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- css2个 ， icon 、default/easyui.css  -->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/easyui/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/easyui/default/easyui.css">
	
	<!-- js2个，jQuery、easyui -->
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/easyui-lang-zh_CN.js"></script>
	
	<script type="text/javascript">
		//$(".easyui-linkbutton").hover( over , out );
		//$(".easyui-linkbutton").mouseover( over ).mouseout( out );
		
		function addTabs(obj  , url){
			//1 获得标题，a标签文本值 
			var title = $(obj).text();
			//2 是否存在，存在选中，否则添加
			// 2.1 判断 
			var ex = $("#tt").tabs("exists",title);
			if(ex){
				// 2.2 选中
				$("#tt").tabs("select",title);
				// 让选项卡 刷新 ？？
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
	<!-- 布局、分类、按钮、选项卡 -->
	
	<div data-options="region:'north',split:false" style="height:40px;background-color:#7F99BE;line-height: 38px;">
		<span style="color: #fff; font-size: 25px;font-weight: bold;">
			<img alt="" src="${pageContext.request.contextPath}/img/blocks.gif" style="height: 25px;">
			管理系统
		
		</span>
		<span style="float:right">欢迎当前用户： 使用帮助 修改密码 退出系统</span>
	</div>   
    <div data-options="region:'south',split:true" style="height:30px;">
    	系统版本号：发布日期：
    </div>   
    <div data-options="region:'west',title:'导航菜单',split:false" style="width:200px;" class="easyui-accordion">
    	
    	<div title="分类管理" data-options="iconCls:'icon-large-smartart',selected:true" style="overflow:auto;padding:10px;">   
	        
	        <a id="btn" href="javascript:void(0)" class="easyui-linkbutton" onclick="addTabs(this,'${pageContext.request.contextPath}/admin/category/add.jsp')" data-options="iconCls:'icon-search',plain:true" style="width:100%;text-align:left">添加分类</a> 
	        <a id="btn" href="javascript:void(0)" class="easyui-linkbutton" onclick="addTabs(this,'${pageContext.request.contextPath}/admin/category/list.jsp')"  data-options="iconCls:'icon-search',plain:true "style="width:100%;text-align:left">分类列表</a> 
	    </div> 
	     <div title="商品管理" data-options="iconCls:'icon-large-smartart'" style="overflow:auto;padding:10px;">
			 <a id="btn" href="javascript:void(0)" class="easyui-linkbutton" onclick="addTabs(this,'${pageContext.request.contextPath}/admin/product/list.jsp')" data-options="iconCls:'icon-search',plain:true" style="width:100%;text-align:left">查看商品</a>
	    </div>     
	    <div title="用户管理" data-options="iconCls:'icon-large-smartart'" style="padding:10px;">   
	        content3333   
	    </div>   
	    <div title="订单管理" data-options="iconCls:'icon-large-smartart'">   
	        content4444   
	    </div>   
    	
    
    </div>   
    <div id="tt" data-options="region:'center'" style="" class="easyui-tabs">
    	<div title="欢迎使用" >   
	        tab1    
	    </div> 
    </div>   
	
</body>
</html>