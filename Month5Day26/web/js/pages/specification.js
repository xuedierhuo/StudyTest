//定义标记记录本次访问的方法
var key;
//规格id
var specId;

$(function () {
    /**
     * 全选全不选
     * */
    $("#selall").click(function () {
        $(".item").prop("checked", this.checked);
    });

    /**
     * 删除规格
     * */
    $("#deletespe").click(function () {
        var strId = "";
        $(".item").each(function () {
            if (this.checked) {
                strId += $(this).val() + ",";
            }
        });
        alert(strId);
        var url = "/SpecificationServlet";
        var param = {
            "method": "delete",
            "strId": strId
        };
        $.post(url, param, function () {
            window.location.reload();
        });
    });


    /**
     * 新建规格
     * */
    $("#new_spec").click(function () {
        key = 1;
    });

    $("#save_spec").click(function () {
        var spec_name = $("#spec_name").val();
        var url = "/SpecificationServlet";
        var params = {
            "method": "opt",
            "specId": specId,
            "key": key,
            "spec_name": spec_name
        };
        $.post(url, params, function () {
            window.location.reload();
        });
    });

    $("#search").keyup(function () {
        //获得关键字
        var word = $(this).val();
        //非空判断
        if (word == null || word == "") {
            $("#completeShow").hide();
            return false;
        }
        ;

        var url = "/SpecificationServlet";

        var params = {
            "method": "findByWord",
            "word": word
        };

        $.post(url, params, function (data) {
            $("#completeShow").show();
            $("#itemul").empty();

            $(data).each(function () {
                //处理后显示结果
                var v = this.specificationName;

                //高亮关键字 （sp 每一个都是红色）
                v = highlight(word,v);
                $("#itemul").append("<li class='list-group-item'>" + v + "</li>");
            });

        }, "json")

    });

});

function highlight(word,str){
    var start = "";	//记录不需要或已经替换后的内容
    var end = str;  //记录需要被替换的内容，默认是整个内容。循环一次后，为后半段没有被替换的。

    for(var i = 0 ; i < word.length ; i ++){
        // 1) 获得每一个关键字
        var w = word.substring(i , i +1);
        // 2) 从目标字符串中截取需要的内容，并进行替换，将字符串三分部：
        var index = end.indexOf(w);
        // * 前端：不需要或已经替换后的内容:shi
        start += end.substring(0,index);
        // * 需要使用<font>包裹内容:p  -->  <font ...>p</font>
        start += "<font color='red'>"+w+"</font>";
        // *后端：需要继续处理内容: in
        end = end.substring(index + 1 ,end.length );
    }
    // 追加最后不用处理数据
    start += end;

    return start;
}

/**
 * 修改规格方法
 * 给key进行赋值操作
 * */
updateButton = function (value) {
    specId = value;
    key = 2;
};