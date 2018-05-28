var flag;
$(function () {

    var attrElement = "<tr>\n" +
        "<td><input type=\"checkbox\" class=\"icheckbox_square-blue item\"></td>\n" +
        "<td><input name=\"attr-name\" class=\"form-control\" placeholder=\"属性名称\"></td>\n" +
        "<td>\n" +
        "<button id='delete-attr-element' type=\"button\" class=\"btn btn-default\" title=\"删除\"><i\n" +
        "class=\"fa fa-trash-o\"></i> 删除\n" +
        "</button>\n" +
        "</td>\n" +
        "</tr>";

    $("#new-template").click(function () {
        flag = 0;
    });

    $("#checkId").click(function () {
        $(".item").prop("checked", this.checked);
    });

    $("#add-element").click(function () {

        $("#attr-list").on("click", "button", function () {
            if ($(".item:checked").length > 1) {
                $(".item:checked").each(function () { // 遍历选中的checkbox
                    n = $(this).parents("tr").index();  // 获取checkbox所在行的顺序
                    $("tbody#attr-list").find("tr:eq(" + n + ")").remove();
                });
                $("#checkId").prop("checked", false);
            } else {
                $(this).parent().parent().remove();
            }
        });


        $("#attr-list").append(attrElement);
    });

    $("#delete-attr-element").click(function () {
        if ($(".item:checked").length > 1) {
            $(".item:checked").each(function () { // 遍历选中的checkbox
                n = $(this).parents("tr").index();  // 获取checkbox所在行的顺序
                $("tbody#attr-list").find("tr:eq(" + n + ")").remove();
            });
            $("#checkId").prop("checked", false);
        } else {
            $(this).parent().parent().remove();
        }
    });

    $("#save").click(function () {

        var attrName = "";
        $("input[name='attr-name']").each(function () {
            attrName += $(this).val() + ",";
        });

        var brands = "";
        $("input[name='brand']:checked").each(function () {
            brands += $(this).val() + ",";
        });

        var url = "/TypeTemplate";
        var params = {
            "method": "add",
            "productType": $("#product-type").val(),
            "brands": brands,
            "specification": $("#specification:checked").val(),
            "attrName": attrName,
            "flag": flag
        };
        $.post(url, params, function () {
            window.location.reload();
        });

        $("#attr-list").html(attrElement);
        $("#product-type").val("");
        $("input[name='brand']:checked").each(function () {
            $(this).prop("checked", false);
        });
        $("#specification:checked").prop("checked", false);

    });

    $("#selall").click(function () {
        $(".selall-item").prop("checked", this.checked);
    });

    $("#delete-template").click(function () {
        var template = "";
        $(".selall-item:checked").each(function () {
            template += $(this).val() + ",";
        });

        var params = {
            "method": "deleteTemplate",
            "templateId": template
        };

        var url = "/TypeTemplate";
        $.post(url, params, function () {
            window.location.reload();
        });
    });

    $("#search").click(function () {
        var searchContent = $("#search-content").val();
        var url = "/TypeTemplate";
        var params = {
            "method": "search",
            "searchContent": searchContent
        };
        $.post(url, params, function (res) {

            $("#template-list").html("");

            console.log(res);


            $(res).each(function (index) {

                var brandtList = [];
                brandtList = this.brandtList;
                var brands = "";
                $(brandtList).each(function (index) {
                    if (index < (brandtList.length - 1)) {
                        brands += this.brandName + ",";
                    } else {
                        brands += this.brandName;
                    }
                });

                var templateElement = "<tr>\n" +
                    "<td><input type=\"checkbox\" value=\"" + this.templateId + "\" class=\"selall-item\"></td>\n" +
                    "<td>" + (index + 1) + "</td>\n" +
                    "<td>" + this.classificationTemplateName + "</td>\n" +
                    "<td>\n" +
                    brands +
                    "</td>\n" +
                    "<td>" + this.specificationList.specificationName + "</td>\n" +
                    "<td>" + this.attributeName + "</td>\n" +
                    "<td class=\"text-center\">\n" +
                    "<button type=\"button\" class=\"btn bg-olive btn-xs\" data-toggle=\"modal\" data-target=\"#editModal\">\n" +
                    "修改\n" +
                    "</button>\n" +
                    "</td>\n" +
                    "</tr>";

                $("#template-list").append(templateElement);

            });

        }, "json");
    });


});

var edit = function (templateId) {
    flag = templateId;

    $("input[name='brand']").prop("checked", false);
    $("#specification").prop("checked", false);

    var url = "/TypeTemplate";
    $.post(url, {
        "method": "preEdit",
        "flag": flag
    }, function (res) {

        console.log(res);
        console.log($("#specification"));
        $("#product-type").val(res.classificationTemplateName);
        var brands = res.brandtList;
        $(brands).each(function () {
            var that = this;
            $("input[name='brand']").each(function () {
                if (that.brandId == $(this).val()){
                    $(this).prop("checked", true);
                    return false;
                }
            });

            $("input[name='specification']").each(function () {
                if ($(this).val() == res.specificationList.specificationId) {
                    $(this).prop("checked", true);
                    return false;
                }
            });

        });


    }, "json");
};
