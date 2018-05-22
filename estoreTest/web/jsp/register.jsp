<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!doctype html>
<html>
	<head></head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>会员注册</title>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" />
		<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/bootstrap.min.js" type="text/javascript"></script>
		<script src="${pageContext.request.contextPath}/js/jquery.extend.itcast.js" type="text/javascript"></script>
		<!-- 引入自定义css文件 style.css -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css"/>
		
		<script type="text/javascript">
			/* username */
			//1.页面加载成功，给input绑定失去焦点事件
			$(function(){
				$("#username").blur(function(){
					// 2 获得“用户名”
					var usernameVal = $(this).val();
					
					// 3 ajax发送请求，查询用户是否存在
					// 3.1 路径 
					var url = "${pageContext.request.contextPath}/UserServlet";
					// 3.2 参数
					var params = {
						"method":"check",	
						"username":usernameVal
					};
					// 3.3 发送
					$.myPost(url,params,function( data ){
						
						if(data.flag == 1){
							// 4.1 用户不存在，，可用，绿色显示，且按钮可用。
							$("#usernameErrorSpan").removeClass("btn-danger");		//删除红色
							$("#usernameErrorSpan").addClass("btn-success");		//添加绿色
							
							//控制按钮--按钮可用
							$("#submitInput").removeProp("disabled");
							
						} else if(data.flag == 2) {
							// 4.2 用户存在，不可用，红色显示，且按钮不可用。
							$("#usernameErrorSpan").removeClass("btn-success");		//删除绿色
							$("#usernameErrorSpan").addClass("btn-danger");			//添加红色
							
							//控制按钮-按钮不可用
							$("#submitInput").prop("disabled","disabled");
						}
						
						// 提示信息
						$("#usernameErrorSpan").html( data.msg );
						
					},function(){
						alert("失败");
					});
					
					
				});
			});
			
			//切换验证码
			function changeImg(){
				var url = "${pageContext.request.contextPath}/UserServlet?method=verifyCode&t=" + new Date();
				$("#verifyCodeImageId").attr("src",url);
			}
			
		</script>

<style>
  body{
   margin-top:20px;
   margin:0 auto;
 }
 .carousel-inner .item img{
	 width:100%;
	 height:300px;
 }
 .container .row div{ 
	 /* position:relative;
	 float:left; */
 }
 
font {
    color: #3164af;
    font-size: 18px;
    font-weight: normal;
    padding: 0 10px;
}
 </style>
</head>
<body>




			<!-- 包含头部页面 -->
			<%@include file="header.jsp" %>




<div class="container" style="width:100%;background:url('${pageContext.request.contextPath}/img/regist_bg.jpg');">
<div class="row"> 

	<div class="col-md-2"></div>
	
	


	<div class="col-md-8" style="background:#fff;padding:40px 80px;margin:30px;border:7px solid #ccc;">
		<font>会员注册</font>USER REGISTER <br/>
		<font style="color:#f00">${msg}</font>
		<form class="form-horizontal" action="${pageContext.request.contextPath}/UserServlet" method="post" style="margin-top:5px;">
			<input type="hidden" name="method" value="register"/>
			 <div class="form-group">
			    <label for="username" class="col-sm-2 control-label">用户名</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="username" name="username" placeholder="请输入用户名" value="${user.username}">
			    </div>
			    <div class="col-sm-4">
			    	<!-- 
			    		btn btn-xs btn-success
			    		btn btn-xs btn-danger
			    	 -->
			    	<span id="usernameErrorSpan" class="btn btn-xs"></span>
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="inputPassword3" class="col-sm-2 control-label">密码</label>
			    <div class="col-sm-6">
			      <input type="password" class="form-control" id="inputPassword3" name="password" placeholder="请输入密码"  value="${user.password}">
			    </div>
			  </div>
			   <div class="form-group">
			    <label for="confirmpwd" class="col-sm-2 control-label">确认密码</label>
			    <div class="col-sm-6">
			      <input type="password" class="form-control" id="confirmpwd" name="repassword" placeholder="请输入确认密码">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputEmail3" class="col-sm-2 control-label">Email</label>
			    <div class="col-sm-6">
			      <input type="email" class="form-control" id="inputEmail3" name="email" placeholder="Email" value="${user.email}">
			    </div>
			  </div>
			  <div class="form-group">
			    <label for="inputTelephone" class="col-sm-2 control-label">电话</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="inputTelephone" name="telephone" placeholder="电话" value="${user.telephone}">
			    </div>
			  </div>
			 <div class="form-group">
			    <label for="usercaption" class="col-sm-2 control-label">姓名</label>
			    <div class="col-sm-6">
			      <input type="text" class="form-control" id="usercaption" name="name" placeholder="请输入姓名" value="${user.name}">
			    </div>
			  </div>
			  <div class="form-group opt">  
			  <label for="inlineRadio1" class="col-sm-2 control-label">性别</label>  
			  <div class="col-sm-6">
			    <label class="radio-inline">
			  <input type="radio" id="inlineRadio1" name="sex" value="男" ${user.sex=="男"?" checked='checked' ":""}> 男
			</label>
			<label class="radio-inline">
			  <input type="radio" id="inlineRadio2" name="sex" value="女" ${user.sex=="女"?" checked='checked' ":""}> 女
			</label>
			</div>
			  </div>		
			  <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">出生日期</label>
			    <div class="col-sm-6">
			    	<!-- 使用时间格式化，日期进行处理，并存放到ub中 -->
			    	<fmt:formatDate value="${user.birthday}" pattern="yyyy-MM-dd" var="ub"/>
			      <input type="date" name="birthday" class="form-control"  value="${ub}" >		      
			    </div>
			  </div>
			  
			  <div class="form-group">
			    <label for="date" class="col-sm-2 control-label">验证码</label>
			    <div class="col-sm-3">
			      <input type="text" class="form-control" name="verifyCode" >
			    </div>
			    <div class="col-sm-2">
			    	<img src="${pageContext.request.contextPath}/UserServlet?method=verifyCode" id="verifyCodeImageId" onclick="changeImg()"/>
			    </div>
			    
			  </div>
			 
			  <div class="form-group">
			    <div class="col-sm-offset-2 col-sm-10">
			      <input type="submit" id="submitInput"  width="100" value="注册" border="0"
				    style="background: url('${pageContext.request.contextPath}/img/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0);
				    height:35px;width:100px;color:white;">
			    </div>
			  </div>
			</form>
	</div>
	
	<div class="col-md-2"></div>
  
</div>
</div>

	  
	
	<div style="margin-top:50px;">
			<img src="${pageContext.request.contextPath}/img/footer.jpg" width="100%" height="78" alt="我们的优势" title="我们的优势" />
		</div>

		<div style="text-align: center;margin-top: 5px;">
			<ul class="list-inline">
				<li><a href="${pageContext.request.contextPath}/jsp/info.jsp">关于我们</a></li>
				<li><a>联系我们</a></li>
				<li><a>招贤纳士</a></li>
				<li><a>法律声明</a></li>
				<li><a>友情链接</a></li>
				<li><a target="_blank">支付方式</a></li>
				<li><a target="_blank">配送方式</a></li>
				<li><a>服务声明</a></li>
				<li><a>广告声明</a></li>
			</ul>
		</div>
		<div style="text-align: center;margin-top: 5px;margin-bottom:20px;">
			Copyright &copy; 2005-2016 传智商城 版权所有
		</div>

</body></html>




