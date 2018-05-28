<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>申请记录</title>
    <link href="css/themes/default/easyui.css" rel="stylesheet" />
    <link href="css/themes/icon.css" rel="stylesheet" />
    <link href="css/themes/color.css" rel="stylesheet" />
      <style>
        body{
            font-size:12px;
            overflow-y:hidden;
        }
        input{
            width:100px;            
        }
        select{
            width:104px;
        }
        #sec{
            /*border:1px solid #0094ff;*/
            width:1000px;
            
        }
        #sec td{
            width:100px;
            height:20px;
            text-align:right
        }
    </style>
    <script src="script/jquery.min.js"></script>
    <script src="script/jquery.easyui.min.js"></script>
    <script src="script/easyui-lang-zh_CN.js"></script>
    <script type="text/javascript">
        $(function() {
            loadData();
        });
        
        function deleteExpress(eid){
        	/*eid  为快递id */
			alert(eid);
        }
        
        function loadData(pars) {
            $('#date').datagrid({
                url: '${pageContext.request.contextPath}/ExpressServlet?method=findExpressPage',
                width: ($(window).width()*0.90), 
                height:($(window).height()*0.99)-100, 
                loadMsg: '正在加载信息...',
                pagination: true,//是否有分页
                pageSize: 2,//每页多少条数据
                pageNumber: 1,//默认的页
                pageList: [2, 10, 20],
               /*  queryParams: pars, *///往后台传递参数
                columns: [[
                  
					{ field: 'addresser', title: '发件人', align: 'center', width: 100 },
					{ field: 'addresserPhone', title: '发件手机号', align: 'center', width: 100 },
                    { field: 'area', title: '快递区域', align: 'center', width: 100 },
                    { field: 'type', title: '快递类型', align: 'center', width: 100
                    },
                    { field: 'receiver', title: '收件人', align: 'center', width: 100},
					{ field: 'receiverPhone', title: '收件手机号', align: 'center', width: 100 },
					{ field: 'addr', title: '收件地址', align: 'center', width: 100 },
					{ field: 'remark', title: '备注', align: 'center', width: 100 },
                    {
                          field: 'eid', title: '操作', align: 'center', width: 150,
                          formatter: function (value, row, index) {
                              var str = "";
                              str += '<a href="/ExpressServlet?method=deleteExpress&id=' + value + '" class="easyui-linkbutton" style="width:50px">删除</a>';
                              return str;
                          }
                    }
                ]],
             
            });
        }
        
       
    </script>
  
</head>
<body >
        <table id="date" >   </table>
</body>
</html>
