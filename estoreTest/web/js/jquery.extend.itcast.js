/**
 * jQuery的ajax扩展
 * @Author 梁桐
 * @Email liangtong@itcast.cn
 * 
 *   data = data || {}   运行结果
 *   
 *   true ||  ...  		--> true
 *   false || true 		-->  true
 *   
 *   Object || ...  	--> Object
 *   false || Object2 	--> Object2
 *   
 *   undefined / null / 0 / false  转换boolean --> false
 *   
 */

/**
 * 全局函数 $.xxx()
 */
$.extend({
	/**
	 * 自定义 ajax，为了增强 $.post() 。提供了失败回调函数
	 * $.myPost(请求路径 , 请求参数 , 成功回调函数,失败回调函数, 响应数据类型);
	 * 	请求路径 ，必填
	 * 	请求参数 ，可选，没有参数
	 *  成功回调函数 ，可选，空函数
	 *  失败回调函数 ，可选，空函数
	 *  响应数据类型 ，可选，json
	 */
	"myPost" : function(url,data,callback,errorcallback,type){
		//处理数据
		data = data || {};								//如果data有数据使用data数据，如果data没有数据使用空数据{}
		callback = callback || function(){};			//默认空函数
		errorcallback = errorcallback || function(){};
		type = type || "json";							//默认json
		
		//发送ajax
		$.ajax({
			"url" : url,
			"data" : data,
			"success" : callback,
			"error" : errorcallback,
			"dataType" : type,
			"type" : "post"
		});
	},
	/**
	 * 打开一个窗口
	 * $.mywindow( 标识符 , 标题 , 窗口需显示内容路径 , 高 ,宽)
	 * 	标识符，必填，要求唯一，为了多个弹出框同时存在
	 *  标题，必填
	 *  窗口需显示内容路径，必填，内部使用<iframe>
	 *  高，可选，默认400px
	 *  宽，可选，默认600px
	 */
	"mywindow" : function(id,title,url,height,width){
		//1 创建div
		var newDiv = $("<div id='"+id+"'></div> ");
		$("body").append(newDiv);
		
		//处理数据
		height = height || 400;
		width = width || 600;
		
		
		//2 渲染window
		newDiv.window({
			"title":title,
			"content" :"<iframe src='"+url+"' frameborder='0' width='100%' height='100%'></iframe>",
			 "width":width,    		//宽
			 "height":height,    	//高
			 modal:true ,		//是否是模式窗口
		});
	},
	/**
	 * 将数据填充到表单中（自动回显）
	 * 要求：提供数据(json)，必须与表单元素name值保持一致，将一一回显。
	 * $.populate( 表单id , 数据或路径)
	 * 例如：
	 * 	 $.populate("formId", {"cid":"c001","cname":"xxx"});
	 * 		
	 * 	 处理后效果
	 * 	 <form id="formId">
	 * 		<input type="text" name="cid" value="c001" >
	 * 		<input type="text" name="cname" value="xxx" >
	 *   </form>
	 *  实现内容
	 *  	form("load", url)  ,jQuery easyui 提供组件
	 */
	"populate" : function(formId , url){   //url/data
		$("#" + formId).form("load",url);
	},
	/**
	 * 将指定表单内容清空（存在缺陷）
	 * 	清空两种数据：文本框<input>（不含隐藏域） 和 文本域 <textarea>
	 */
	"clear" : function (formId){
		//$("#" + formId).form("clear");
		// BaseServlet 存在隐藏字段，不允许情况
		$("#" + formId).find(":input").not(":hidden").val("");
		$("#" + formId).find("textarea").text("");
	},
	/**
	 * ajax 提交表单
	 * $.form( 表单id , 成功的回调函数 , 失败回调函数)
	 *    提交的位置：表单action确定
	 *    提交的方式：表单method确定，如果没有默认post
	 *    提交的数据：通过自定工具serializeJson()，将表单中所有的参数拼凑json
	 *    成功的回调函数：必填
	 *    失败回调函数：可选
	 */
	"form" : function(formId , callback , errorcallback){
		var formObj = $("#" + formId);
		var url = formObj.attr("action");
		var data = formObj.serializeJson();
		var type = formObj.attr("method");
		type = type || "post";
		errorcallback = errorcallback || function(){};
		$.ajax({
			"url" : url,
			"data" : data,
			"type" : type,
			"success" : callback,
			"error" : errorcallback,
			"dataType" : "json"
		});
	}
});

/**
 * 普通函数 $("#id").xxx()
 */

/**
 * serializeJson() : 将表单中所有的参数拼凑json，并返回json对象
 * var obj = $("#formId").serializeJson();
 * 例如：
 * 表单数据
 * <form id="formId">
 * 		<input type="text" name="cid" value="c001" >
 * 		<input type="text" name="cname" value="xxx" >
 * 		<input type="text" name="hobby" value="x" >
 * 		<input type="text" name="hobby" value="y" >
 * 		<input type="text" name="hobby" value="z" >
 *  </form>
 * 处理后结果
 * 	{
 * 		"cid":"c001",
 * 		"cname":"xxx",
 * 		"hobby":["x","y","z"],
 *  }
 * 
 */
jQuery.fn.serializeJson = function(){
	var dataArr = $(this).serializeArray();
	var obj = {};
	$(dataArr).each(function(){
		if(obj[this.name]){
			if(jQuery.isArray(obj[this.name])){
				obj[this.name].push(this.value);
			} else {
				obj[this.name] = [ obj[this.name] , this.value ];
			}
		} else  {
			obj[this.name] = this.value;
		}
	});
	return obj;
}















