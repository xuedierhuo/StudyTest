var reviewCode;
var url = "/ProductServlet";

$(function () {
    $("#productCheckbox").click(function () {
        $(".product-item").prop("checked", this.checked);
    });

    $(".product-item").click(function () {
        $("#productCheckbox").prop("checked", $(".product-item:checked").length == $(".product-item").length?true:false);
    });

    $("#reviewSuccess").click(function () {
        reviewCode = 1;

        var pid = $(this).data("id");

        var params = {
            "method": "review",
            "reviewCode": reviewCode,
            "pid": pid
        };
        $.post(url, params, function () {
            window.location.reload();
        });

        $("input[title='删除']").click(function () {
            var productId = "";
            $(".product-item:checked").each(function () {
                productId += $(this).val() + ",";
            });

            var params = {
                "method": "deleteProduct",
                "productId": productId
            };

            $.post(url, params, function () {
                window.location.reload();
            });
        });

    });

    $("#reviewFail").click(function () {
        reviewCode = 2;
        var pid = $(this).data("id");
        var params = {
            "method": "review",
            "reviewCode": reviewCode,
            "pid": pid
        };
        $.post(url, params, function () {
            window.location.reload();
        });
    });
});

detail = function (pid) {

    var params = {
        "method": "detail",
        "pid": pid
    };


    $.post(url, params, function (res) {
        $("#productName").html(res.productName);
        $("#productPrice").html(res.productPrice);

        $(res.productCategories).each(function () {
            if (this.level == 0) {
                $("#oneCategory").html(this.categoryName);
            }else {
                $("#twoCategory").html(this.categoryName);
            }
        });

        $("#threeCategory").html(res.productCategory.categoryName);

        $(".review").data("id", res.productId);

    }, "json");
};