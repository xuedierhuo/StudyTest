<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
    <!-- 页面meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>商家搜索</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no" name="viewport">
    <link rel="stylesheet" href="../plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="../plugins/adminLTE/css/AdminLTE.css">
    <link rel="stylesheet" href="../plugins/adminLTE/css/skins/_all-skins.min.css">
    <link rel="stylesheet" href="../css/style.css">
    <script src="../plugins/jQuery/jquery-2.2.3.min.js"></script>
    <script src="../plugins/bootstrap/js/bootstrap.min.js"></script>
    <%--引入jq--%>
    <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
    <script type="text/javascript" src="../js/checkedAll.js"></script>
    <script type="text/javascript" src="../js/details.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#companyName").keyup(function () {
                var str = $("#companyName").val();
                var me = "companyName";
                topost(str,me);
            });

            $("#storeName").keyup(function () {
                var str = $("#storeName").val();
                var me = "storeName";
                topost(str,me);
            });

            function topost(str , me) {
                var url = "/BusinessServlet";
                var params = {
                    "method": "search",
                    "value": str,
                    "me": me
                };
                if (me == "companyName") {
                    $("#companyNameUl").html("");
                } else {
                    $("#storeNameUl").html("");
                }
                $.post(url, params, function (data) {
                    for (var i = 0; i < data.length; i++) {
                        var value;
                        if (me == "companyName") {
                            value = data[i].companyName;
                            $("#companyNameUl").append("<li>" + value + "</li>");
                        } else {
                            value = data[i].storeName;
                            $("#storeNameUl").append("<li>" + value + "</li>");
                        }
                    }
                }, "json");
            }
        });
    </script>
</head>

<body class="hold-transition skin-red sidebar-mini">
<!-- .box-body -->
<div class="box box-primary">
    <div class="box-header with-border">
        <h3 class="box-title">商家搜索</h3>
    </div>

    <div class="box-body">
        <!-- 数据表格 -->
        <div class="table-box">

            <!--工具栏-->

            <div class="box-tools pull-right">
                <div class="has-feedback">
                    <form action="${pageContext.request.contextPath}/BusinessServlet" method="post">
                        <input type="hidden" name="method" value="findSearch"/>
                        公司名称：<input type="text" name="companyName" id="companyName" data-search="0" value=""/>
                        <div>
                            <ul id="companyNameUl">
                            </ul>
                        </div>
                        店铺名称：<input type="text" name="storeName" id="storeName" data-search="1" value=""/>
                        <div>
                            <ul id="storeNameUl">
                            </ul>
                        </div>
                        <button class="btn btn-default">查询</button>
                    </form>
                </div>
                <div id="completeShowOne"
                     style="width: 160px;display: block;left: 54.5%;border: 1px solid #999;position: absolute; display: none;">
                    <ul id="itemulOne" class="list-group">
                        <li class="list-group-item">Cras justo odio1</li>
                    </ul>
                </div>
                <div id="completeShowTwo"
                     style="width: 160px;display: block;left: 77.5%;border: 1px solid #999;position: absolute; display: none;">
                    <ul id="itemulTwo" class="list-group">
                        <li class="list-group-item">Cras justo odio1</li>
                    </ul>
                </div>
            </div>
            <!--工具栏/-->

            <!--数据列表-->
            <table id="dataList" class="table table-bordered table-striped table-hover dataTable">
                <thead>
                <tr>
                    <th class="" style="padding-right:0px">
                        <input id="selall" type="checkbox" class="icheckbox_square-blue">
                    </th>
                    <th class="sorting_asc">商家ID</th>
                    <th class="sorting">公司名称</th>
                    <th class="sorting">店铺名称</th>
                    <th class="sorting">联系人姓名</th>
                    <th class="sorting">公司电话</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${listAll}" var="self" varStatus="num">
                    <tr>
                        <td><input class="all" type="checkbox"></td>
                        <td>${num.count}</td>
                        <td>${self.companyName}</td>
                        <td>${self.storeName}</td>
                        <td>${self.contactName}</td>
                        <td>${self.companyPhone}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</div>
<script>
    // 在此完成代码

</script>
</body>
</html>