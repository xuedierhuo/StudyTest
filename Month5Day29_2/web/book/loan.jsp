<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>预约详情页</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="utf-8">

	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/bootstrap-theme.min.css" rel="stylesheet">
	<script type="text/javascript" src="js/jquery-1.11.3.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>

	<script type="text/javascript">
		/*检查借阅数量是否大于库存数量*/
		function checkNum(num) {
			var bookid = $("#bookid").val();
			$.post("${pageContext.request.contextPath}/LoanServlet",
				{"method":"checkNum","bookid":bookid,"loanNumber":num},
				function (data) {
					if(data == "yes"){
					    $("#checkNumMsg").html("可以借阅");
					}else{
                        $("#checkNumMsg").html("借阅数量有误，请重新输入！");
					}
                }
			)
        }
	</script>

</head>
<body>
<div class="container">
    <div class="panel panel-default">
        <div class="panel-heading text-center">
     	   	<h2>图书借阅</h2>
        </div>
		<form action="${pageContext.request.contextPath}/LoanServlet?method=addLoan" method="post">
			<div class="panel-body">
				<table class="table table-hover">
						<tbody>
							<div class="row">
							  <div class="col-md-2">
									<div class="form-group">
										<label for="bookid">图书ID</label>
										<input type="text" name="bookid" value="${book.bookid}" class="form-control" id="bookid" placeholder="图书ID">
									</div>
							  </div>
							  <div class="col-md-2">
									<div class="form-group">
										<label for="bookName">图书名称</label>
										<input type="text" name="bookName" value="${book.bookName}"  class="form-control" id="bookName" placeholder="图书名称">
									</div>
							  </div>
							  <div class="col-md-2">
									<div class="form-group">
										<label for="bookInfo">图书简介</label>
										<input type="text" name="bookInfo" value="${book.bookInfo}"  class="form-control" id="bookInfo" placeholder="图书简介">
									</div>
							  </div>
							  <div class="col-md-2">
									<div class="form-group">
										<label for="number">剩余数量</label>
										<input type="text" name="number" value="${book.number}" class="form-control" id="number" placeholder="剩余数量">
									</div>
							  </div>
							  <div class="col-md-2">
									<div class="form-group">
										<label for="loanNumber">借阅数量</label>
										<input type="text" name="loanNumber"  class="form-control" id="loanNumber" placeholder="借阅数量" onblur="checkNum(this.value)">
									</div>
								  	<div id="checkNumMsg">

									</div>
							  </div>

							</div>
						</tbody>

				 </table>
			   </div>
			   <div class="panel-body text-center">
					<%--<h2 class="text-danger">
						<span class="glyphicon"><a class="btn btn-primary btn-lg" href="appoint.html" >借阅</a></span>
					</h2>--%>
				   <div>${msg}</div>
				   <button type="submit" class="btn btn-primary btn-lg">
					   <span class="glyphicon glyphicon-education" aria-hidden="true"></span> 借　阅
				   </button>
				</div>
		</form>
    </div>	 	
            		  
</div>
  

</body>


</html>
