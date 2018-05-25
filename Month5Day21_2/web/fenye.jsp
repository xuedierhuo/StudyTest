<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>用户管理</title>
    
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
    
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link rel="stylesheet" href="css/bootstrap-theme.min.css">
    <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
    <script type="text/javascript" src="js/bootstrap.min.js"></script>

	<script type="text/javascript">
		$(function () {
			function showUsers(pageNum , pageSize, name) {
			    var url = "/UserServlet";
			    var params = {
			        "method" : "findAll",
					"page" : pageNum,
					"rows" : pageSize,
					"name" : name
				};
				$.post(url,params,function ( data ) {
				    // data = eval(data);
				    var rows = data.rows;
				    var total = Math.ceil(data.total/pageSize);

				    $("#pages").html(total);
					$("#pageNum").val(pageNum);
					$("#allTh").html("");

					$("#nextpage").show();
					if (total == pageNum){
                        $("#nextpage").hide();
					};
                    $("#uppage").show();
                    if (pageNum == 1){
                        $("#uppage").hide();
                    }

                    for (var i = 0; i < rows.length; i++) {
                        var newTr = $("<tr></tr>");

                        var count = $("<td></td>").html(i+1);
                        newTr.append(count);

                        var id = $("<td></td>").html(rows[i].userId);
                        newTr.append(id);

                        var userName = $("<td></td>").html(rows[i].userName);
                        newTr.append(userName);

                        var userGender = $("<td></td>").html(rows[i].userGender);
                        newTr.append(userGender);

                        var userRegisterTime = $("<td></td>").html(rows[i].userRegisterTime.year+1900+"-"+rows[i].userRegisterTime.month+"-"+rows[i].userRegisterTime.day);
                        newTr.append(userRegisterTime);

                        var userLastLoginTime = $("<td></td>").html(rows[i].userLastLoginTime.year+1900+"-"+rows[i].userLastLoginTime.month+"-"+rows[i].userLastLoginTime.day);
                        newTr.append(userLastLoginTime);

                        var deptno = $("<td></td>").html(rows[i].dept.dname);
                        newTr.append(deptno);


						$("#allTh").append(newTr);
                    }


                },"json");
            }

            $("#first").click(function () {
                showUsers(1 , 5);
            });

            $("#end").click(function () {
                showUsers($("#pages").html() , 5);
            });

            $("#uppage").click(function () {
                var pageNum = parseInt($("#pageNum").val())-1;
                showUsers(pageNum , 5);
            });

            $("#nextpage").click(function () {
                var pageNum = parseInt($("#pageNum").val())+1;
                showUsers(pageNum , 5);
            });


            showUsers(1,5,"");

            $("#seachSub").click(function () {
				alert($(this).val());
				showUsers(1,5,$(this).val())
            })
        });
	</script>
  </head>
  
  <body>
  	 <div class="container">
	  	<div class="panel panel-info">
			 <div class="panel-heading">
				  <span class="glyphicon glyphicon-search" aria-hidden="true"></span> 信息查询
			 </div>
			 <div class="panel-body">

			 	<form action="${pageContext.request.contextPath }/UserServlet" method="post" class="form-inline">
			        <input type="hidden" name="method" value="search">
					<div class="form-group">
					    <label for="username">用户名：</label>
					    <input type="text" name="username" class="form-control" id="username" value="" placeholder="用户名">
					</div>
					
					<button type="button" class="btn btn-default" id="seachSub"> 查询 </button>
		        </form><hr>
			 
			      <table class="table table-striped table-bordered table-hover table-condensed" >
		            <tr>
		            	<th>行序号</th>
		            	<th>用户编号</th>
		            	<th>用户名称</th>
		            	<th>用户性别</th>
		            	<th>注册时间</th>
		            	<th>登录时间</th>
		            	<th>所属部门</th>
		            	<th>操作</th>
		            </tr>
					<tbody id="allTh">
						<%--<c:forEach items="${users}" var="user" varStatus="ind">--%>
							<%--<tr id="userstr">--%>
								<%--<th>${ind.count}</th>--%>
								<%--<th>${user.userId}</th>--%>
								<%--<th>${user.userName}</th>--%>
								<%--<th>${user.userGender}</th>--%>
								<%--<th>${user.userRegisterTime}</th>--%>
								<%--<th>${user.userLastLoginTime}</th>--%>
								<%--<th>${user.password}</th>--%>
								<%--<th></th>--%>
							<%--</tr>--%>
						<%--</c:forEach>--%>
					</tbody>

		        </table>
		        <div class="pager">
		        <ul>
		            <li>
		            	<a href="javascript:void(0)" onclick="" id="first">首页</a>
		            </li>
		            <li>
		            	<a href="javascript:void(0)" onclick="" id="uppage">上一页</a>
		            </li>
		            <li>
		            	<a href="javascript:void(0)" onclick="" id="nextpage">下一页</a>
		            </li>
		            <li>
		            	<a href="javascript:void(0)" onclick="" id="end">尾页</a>
		            </li>
		            <li>
		            	第<input name="pageNum" id="pageNum" type="text" value="" style="width: 40px;" >页
		            	/
						共  <span id="pages" ></span> 页
		            </li>
		        </ul>
		        </div>
			 </div>
		</div>
	 </div>
	 
	 <!-- 重置密码弹出框 -->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="gridSystemModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="gridSystemModalLabel">重置密码</h4>
	      </div>
	      <div class="modal-body">
	        <div class="row" style="padding-left: 16px;">
	          	<form class="form-horizontal">
				  <div class="form-group">
				    <label for="repwd1" class="col-sm-2 control-label">新密码</label>
				    <div class="col-sm-5">
				    	<input type="password" class="form-control" id="repwd1" placeholder="新密码">
				    </div>	
				  </div>
				  <div class="form-group">
				    <label for="repwd2" class="col-sm-2 control-label">确认密码</label>
				    <div class="col-sm-5">
				    	<input type="password" class="form-control" id="repwd2" placeholder="确认密码">
				    </div>
				  </div>
				</form>
	        </div>
	      </div>
	      <div class="modal-footer">
	     	<div>
	        	<input type="hidden" name="uid" value="">
	        	<button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	        	<button type="button" class="btn btn-primary" data-dismiss="modal" onclick="resetPwd()">确认</button>
	        </div>
	      </div>
	    </div>
	  </div>
	</div>
	 
  </body>
</html>