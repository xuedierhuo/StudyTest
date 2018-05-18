<%@ page language="java" pageEncoding="UTF-8"%>
<HTML>
	<HEAD>
		<meta http-equiv="Content-Language" content="zh-cn">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<LINK href="${pageContext.request.contextPath}/css/Style1.css" type="text/css" rel="stylesheet">
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.extend.itcast.js"></script>
		
		<%-- el获得请求参数，需要内置对象 param 
			例如：${param.cid}
		--%>
		<script type="text/javascript">
			$(function(){
				// 页面加载成功 ，发送ajax 查询详情
				//1 路径
				var url = "${pageContext.request.contextPath}/AdminCategoryServlet";
				//2 请求参数
				var params = {
					"method" : "editUI",
					"cid" : "${param.cid}"
				};
				//3 发送
				$.post(url,params,function(data){
					//查询结果，添加到表单中
					$.populate("category_edit", data);
				},"json");
				
				
			});
			
			
			//一个页面中，运行出现多个页面加载的方法
			$(function(){

				//表单绑定提交事件
				$("#category_edit").submit(function(){
					
					$.form("category_edit",function(data){
						alert(data.msg);
						location.href = "${pageContext.request.contextPath}/admin/category/list.jsp";
					});
					
					
					return false;
				});
			});
			
			
		
		</script>
	</HEAD>
	
	<body>
	
		<form id="category_edit" name="Form1" action="${pageContext.request.contextPath}/AdminCategoryServlet" method="post">
			<input type="hidden" name="method" value="edit"/>
			<input type="hidden" name="cid" value=""/>
			&nbsp;
			<table cellSpacing="1" cellPadding="5" width="100%" align="center" bgColor="#eeeeee" style="border: 1px solid #8ba7e3" border="0">
				<tr>
					<td class="ta_01" align="center" bgColor="#afd1f3" colSpan="4"
						height="26">
						<STRONG>编辑分类</STRONG>
						
					</td>
				</tr>

				<tr>
					<td width="18%" align="center" bgColor="#f5fafe" class="ta_01">
						分类名称：
					</td>
					<td class="ta_01" bgColor="#ffffff" colspan="3">
						<input type="text" name="cname" value="" id="userAction_save_do_logonName" class="bg"/>
						</td>
				</tr>
			
				<tr>
					<td class="ta_01" style="WIDTH: 100%" align="center"
						bgColor="#f5fafe" colSpan="4">
						<button type="submit" id="userAction_save_do_submit" value="确定" class="button_ok">
							&#30830;&#23450;
						</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<button type="reset" value="重置" class="button_cancel">&#37325;&#32622;</button>

						<FONT face="宋体">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</FONT>
						<INPUT class="button_ok" type="button" onclick="history.go(-1)" value="返回"/>
						<span id="Label1"></span>
					</td>
				</tr>
			</table>
		</form>
	</body>
</HTML>