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
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.extend.itcast.js"></script>
	<script type="text/javascript">
		$(function(){
			
			var columnArr = [[
			                  {field:'cid',title:'分类编号',width:100},    
			                  {field:'cname',title:'分类名称',width:100},    
			                  {field:'opt',title:'操作',width:100,
			                	  formatter:function(value,row,index){
			                		  return "<a href='javascript:void(0)' onclick=\"editCategory('"+row.cid+"')\">修改</a> &nbsp;&nbsp;&nbsp;&nbsp;" + 
			                		  		 "<a href='javascript:void(0)' onclick=\"deleteCategory('"+row.cid+"')\">删除</a>";
			                	  }
			                  },    
			                  ]];
			
			var options = {
				"url" : "${pageContext.request.contextPath}/AdminCategoryServlet?method=findAll",
				"columns" : columnArr,
				"pagination" : true	,							//分页工具栏
				"pageSize" : 2 , 								//分页初始化页面大小 （注意：必须是pageList设置列表中一个值）
				"pageList" :  [2,5,10,15]	,						//分页选择列表（一维数组）
				"striped" : true	,							//隔行换色（斑马线效果）
				"idField" : "pid",								//标识列
				"rownumbers": true,								//显示行号
					
			};
			
			$("#categoryList").datagrid( options );
		});
		
		/* 编辑分类
		*/
		function editCategory(cid){
			location.href = "${pageContext.request.contextPath}/admin/category/edit.jsp?cid=" + cid;
		}
		
		/** 删除分类
		*/
		function deleteCategory(cid){
			//提示
			if(!confirm("您确定要删除吗？")){
				return ;
			}
			
			//方式1：手动发送ajax
			/*
			//1 路径
			var url = "${pageContext.request.contextPath}/AdminCategoryServlet";
			//2 参数
			var params = {
				"method" : "delete",
				"cid" : cid
			};
			//3 发送
			$.post(url,params ,function(data){
				alert(data.msg);
				location.href = "${pageContext.request.contextPath}/admin/category/list.jsp";
			},"json");
			*/
			
			//方式2：创建一个表单，发送ajax
			//将cid填充表单
			$("#cid").val(cid);
			$.form("deleteCategory" ,function(data){
				alert(data.msg);
				location.href = "${pageContext.request.contextPath}/admin/category/list.jsp";
			})
			
		}
	
	</script>
</head>
<body>
	<table id="categoryList"></table> 
	
	
	<form id="deleteCategory" action="${pageContext.request.contextPath}/AdminCategoryServlet" method="post">
		<input type="hidden" name="method" value="delete" />
		<input type="hidden" id="cid" name="cid" value="" />
	</form>
</body>
</html>