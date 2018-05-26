<%--
  Created by IntelliJ IDEA.
  User: 周迪
  Date: 2018/5/5
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="bootstrap/js/jquery-1.12.4.js"></script>
    <script type="text/javascript">
        $(function () {
            // 在此处完成代码
            $("#logiNname").blur(function () {
                var name = $("#logiNname").val();
                var url = "${pageContext.request.contextPath}/UserServlet";
                var params = {
                    "method" : "checkUsername",
                    "loginname" : name
                };
                $.post(url , params , function (data) {
                    $("#loginnameSpan").html(data.message);
                    if (data.exist == false){
                        $("#submit-btn").attr("type","button");
                    }else {
                        $("#submit-btn").attr("type","submit");
                    }
                },"json");
            });
        })
    </script>

</head>
<body>
<form action="${pageContext.request.contextPath}/UserServlet" method="post" >
    <input type="hidden" name="method" value="login" />
    登陆名:<input type="text" name="loginname" id="logiNname"><span id="loginnameSpan" class="label"></span><br />
    密码:<input type="text" name="password"><br />
    用户名:<input type="text" name="username">
    <input type="submit" value="提交" id="submit-btn">

    <%--<font color="red">${message2}</font>--%>

</form>
</body>
</html>
