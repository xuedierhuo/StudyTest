//定义标记记录本次访问的方法
var key;
// 模板id
var templateId;
// 规格
var specificationId;
//商品id
var brandId;
/**
 * 全选全不选
 * */
$(function () {
    $("#selall").click(function () {
        $(".item").prop("checked", this.checked);
    });

    /**
     * 删除品牌
     * */
    $("#deleteBrand").click(function () {
        var strId = "";
        $(".item").each(function () {
            if (this.checked) {
                strId += $(this).val() + ",";
            }
        })
        var url = "/BrandServlet";
        var param = {
            "method": "delete",
            "strId": strId
        };
        $.post(url, param, function () {
            window.location.reload();
        });
    });


    /**
     * 点击新建发送ajax
     * 查询数据库中所有模板
     * */
    $("#new_brand").click(function () {
        key = 1;
        var url = "/BrandServlet";
        var param = {
            "method": "findTemplate"
        };
        $("#templateSelectId").html("<option>-选择模板-</option>")
        $.post(url, param, function (data) {
            $(data).each(function () {
                $("#templateSelectId").append("<option value='" + this.templateId + "'>" + this.classificationTemplateName + "</option>")
            })
        }, "json");
    });
    /**
     * 点击新建时发送ajax
     * 查询数据库中所有规格
     * */
    $("#new_brand").click(function () {
        var url = "/SpecificationServlet";
        var param = {
            "method": "allSpecification"
        };
        $("#specificationId").html("<option>-选择规格-</option>")
        $.post(url, param, function (data) {
            $(data).each(function () {
                $("#specificationId").append("<option value='" + this.specificationId + "'>" + this.specificationName + "</option>")
            })
        }, "json");
    });

    /**-----------------------------------------*/
    /**
     * 点击修改时发送ajax
     * 查询数据库中所有模板
     * */
    $("#update_brand").click(function () {
        key = 1;
        var url = "/BrandServlet";
        var param = {
            "method": "findTemplate"
        };
        $("#templateSelectId").html("<option>-选择模板-</option>")
        $.post(url, param, function (data) {
            $(data).each(function () {
                $("#templateSelectId").append("<option value='" + this.templateId + "'>" + this.classificationTemplateName + "</option>")
            })
        }, "json");
    });
    /**
     * 点击修改发送ajax
     * 查询数据库中所有规格
     * */
    $("#update_brand").click(function () {
        var url = "/SpecificationServlet";
        var param = {
            "method": "allSpecification"
        };
        $("#specificationId").html("<option>-选择规格-</option>")
        $.post(url, param, function (data) {
            $(data).each(function () {
                $("#specificationId").append("<option value='" + this.specificationId + "'>" + this.specificationName + "</option>")
            })
        }, "json");
    });

    /**
     * 获取本次选中规格id
     * */
    $("#specificationId").change(function () {
        specificationId = $(this).val();
    });
    /**
     * 获取本次选中模板id
     * */
    $("#templateSelectId").change(function () {
        templateId = $(this).val();
    });

    $("#save_brand").click(function () {
        console.log("品牌id:" + brandId);
        var brandname = $("#brand_name").val();
        var brandFirstLetter = $("#brandFirstLetter").val();

        var url = "/BrandServlet";
        var params = {
            "method": "opt",
            "key": key,
            "brandId": brandId,
            "brandName": brandname,
            "brandFirstLetter": brandFirstLetter,
            "templateId": templateId,
            "specificationId": specificationId
        };
        $.post(url, params, function () {
            window.location.reload();
        });
    });

});
/**
 * 修改品牌方法
 * 给key进行赋值操作
 * */
updateButton = function (value) {
    brandId = value;
    key = 2;
};




