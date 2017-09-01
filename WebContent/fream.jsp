<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 	<s:if test="#session.existEmployee != null"> --%>
	欢迎:<s:property value="#session.existEmployee.ename"/></br>
	<a href="${pageContext.request.contextPath}/department_findAll.action">部门管理</a>
	<a href="${pageContext.request.contextPath}/employee_findAll.action">员工管理</a>
	<%-- </s:if> --%>
	
	<%-- <s:if test="#session.existEmployee==null"> 
		请先<a href="${pageContext.request.contextPath}/login.jsp">登录</a>
	 </s:if> --%>
</body>
</html>