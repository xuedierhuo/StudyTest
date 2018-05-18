<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- el内置对象 : 在el表达式中可以直接使用的变量名，就是内置对象。
				除了内置对象，其他内容都是从作用域获取数据自定义变量。 
		${xxxx}  
		
		el共有11个，学了6.
		${pageContext}
		
		${pageScope}   获得page作用域数据
		${requestScope.name}   获得request作用域数据  （servlet如何设置？this.getRequest().setAttribute(name,value)）
		${sessionScope.name}   获得session作用域数据 （servlet如何设置？this.getSession().setAttribute(name,value)）
		${applicationScope.name}   获得application作用域数据 （servlet如何设置？this.getServletContext().setAttribute(name,value)）
		
		${cookie.cookeName.value}			cookie创建的  new Cookie(cookeName, 值)
		
		获得请求
		${param.参数名}				
		
		servlet如何获得请求参数？
			获得一个  this.getRequest().getParameter( name );
			获得一组  this.getRequest().getParameterValues( name );
			获得所有  this.getRequest().getParameterMap();
		
	--%>
</body>
</html>