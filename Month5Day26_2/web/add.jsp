<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <link href="css/themes/default/easyui.css" rel="stylesheet" />
    <link href="css/themes/icon.css" rel="stylesheet" />
    <link href="css/themes/color.css" rel="stylesheet" />
    <link href="css/apply.css" rel="stylesheet" />
    <script src="script/jquery.min.js"></script>
    <script src="script/jquery.easyui.min.js"></script>
    <title>添加快递</title>
    <style>

    </style>
</head>
<body>
    <div class="server">
        <h3 class="apply_title">添加快递</h3>
        
        <form action="${pageContext.request.contextPath}/ExpressServlet" method="post">
        <input hidden="hidden" name="method" value="add"/>
        <table class="table">
            <tr>
                <td colspan="6" class="head">发件人信息</td>
            </tr>
            <tr>
                <td class="first">发件人：</td>
                <td class="input"><input type="text" name="addresser"  /></td>
                <td class="first">手机：</td>
                <td class="input"><input type="text" name="addresserPhone"  /></td>
            </tr>
            <tr>
                <td colspan="6" class="head">收件人信息</td>

            </tr>
            <tr>
                <td class="first">收件人<span class="xing">*</span>：</td>
                <td class="input"><input type="text" name="receiver" /></td>
                <td class="first">手机<span class="xing">*</span>：</td>
                <td class="input" colspan="4"><input type="text" name="receiverPhone"  /></td>
            </tr>
            <tr>
                <td colspan="6" class="head">快递信息</td>

            </tr>
            <tr>
                <td class="first">快递区域<span class="xing">*</span>：</td>
                <td >
                 
                    <select name="area">
                        <option>请选择</option>
                        <option>北京</option>
                        <option>天津</option>
                        <option>上海</option>
                        <option>广州</option>
                        <option>福建</option>
                        <option>山东</option>
                        <option>辽宁</option>
                        <option>山西</option>
                        <option>河南</option>
                        <option>河北</option>
                        <option>黑龙江</option>
                        <option>大连</option>
                    </select>
                 
                </td>
                <td class="first">快递类型<span class="xing">*</span>：</td>
                <td class="input">
                    <select name="type">
                        <option >请选择</option>
                        <option value="1">文件</option>
                        <option value="2">其他</option>
                    </select>
                </td>
               
            </tr>
            <tr>
                <td class="first">邮编<span class="xing">*</span>：</td>
                <td class="input"><input type="text" name="postcode"  /></td>
                <td class="first">邮寄地址<span class="xing">*</span>：</td>
                <td colspan="4" class="input"><input class="addr" type="text" name="addr"  /></td>
                
            </tr>
          
            <tr>
                <td colspan="6" class="head">备注</td>
            </tr>
            <tr>
                <td class="secend" style="height:60px;" colspan="6">
                    <textarea  name="remark" rows="4" cols="131" style="resize:none;"></textarea>
                </td>
            </tr>
            <tr>
                <td colspan="6" style="height:40px;" align="center">
                 <button type="submit">提交</button>   
                </td>
            </tr>
        </table>
        </form>
    </div>
   
</body>
</html>