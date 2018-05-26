<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: XDerhuo
  Date: 2018/5/25
  Time: 8:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
    <script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-1.11.3.js"></script>
    <script>
        $(function () {
            $("#school").change(function () {
                var id = $(this).select().val();
                var url = "";
                var params = {
                    "method" : "findAll",
                    "id" : id
                };
                $.post(url , params , function (data) {

                })
            });
        })
    </script>
</head>
<body>
<select id="school" name="school">
    <option>----请选择-----</option>
    <c:forEach items="${schools}" var="school">
        <option value="${school.id}">${school.sname}</option>
    </c:forEach>
</select>
<select id="class" name="class">
    <option>----请选择-----</option>
</select>
<select id="student" name="student">
    <option>----请选择-----</option>
</select>
</body>
</html>