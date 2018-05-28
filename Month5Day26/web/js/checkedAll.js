$(function () {
    //   全选操作
    $("#selall").click(function () {
        $(".all").prop("checked",this.checked);
    });
    //  取消全选
    $("input[type='checkbox']").bind("click",function () {
            //获取选中的所有
            var checkedSize = $(".all:checked").size();
            //所有复选框
            var sum = $(".all").size();
           if (checkedSize != sum){
               $("#selall").prop("checked",false);
           }else {
               $("#selall").prop("checked",true);
           }
        });
});
