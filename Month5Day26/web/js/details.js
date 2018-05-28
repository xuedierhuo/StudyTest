$(function () {
    var bid;
    $(".detailsId").click(function () {
        //获取商品id
        bid = $(this).val();
        //设置路径
        var url = "/BusinessServlet";
        //设置参数
        var params = {
            "method":"findById",
            "bid":bid
        };
        //调用方法
        $.post(url,params,function (data) {
            $("#companyName").html("");
            $("#companyName").text(data.companyName);
            $("#companyMobilePhone").html("");
            $("#companyMobilePhone").text(data.companyMobilePhone);
            $("#companyPhone").html("");
            $("#companyPhone").text(data.companyPhone);
            $("#companyAddress").html("");
            $("#companyAddress").text(data.companyAddress);
            $("#contactName").html("");
            $("#contactName").text(data.contactName);
            $("#contactQq").html("");
            $("#contactQq").text(data.contactQq);
            $("#contactMobilePhone").html("");
            $("#contactMobilePhone").text(data.contactMobilePhone);
            $("#contactEmail").html("");
            $("#contactEmail").text(data.contactEmail);
            $("#businessNumber").html("");
            $("#businessNumber").text(data.businessNumber);
            $("#registrationNumber").html("");
            $("#registrationNumber").text(data.registrationNumber);
            $("#organizationCode").html("");
            $("#organizationCode").text(data.organizationCode);
            $("#legalRepresentative").html("");
            $("#legalRepresentative").text(data.legalRepresentative);
            $("#legalRepresentativeId").html("");
            $("#legalRepresentativeId").text(data.legalRepresentativeId);
            $("#bankName").html("");
            $("#bankName").text(data.bankName);
            $("#bankBranch").html("");
            $("#bankBranch").text(data.bankBranch);
            $("#bankAccount").html("");
            $("#bankAccount").text(data.bankAccount);
            $(".thisId").prop("value","");
        },"json");
    });

    $(".thisId").click(function () {
        //提交路径
        var url = "/BusinessServlet";
        //获取对应的值
        var val = $(this).data("bid");
        var tab = $(this).data("tab");
        //若为空，则返回
        if (val == ""||val == null){
            return;
        }
        //提交参数
        var params ={
            "method":"updata",
            "bid":bid,
            "val":val
        };

        //使用方法调用服务端方法
        $.post(url,params, function (data) {
        },"json");
        window.location.reload();
    });

});