<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form  action="department_save.action" method="post" namespace="/" theme="simple">
		<table border="0">
			<tr>
				<td>部门名称：</td>
				<td><s:textarea name="dname"/></td>
			</tr>
			<tr>
				<td >部门介绍：</td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><s:textarea rows="5" cols="30" name="ddesc"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="保存"></td>
			</tr>
		</table>
	</s:form>
</body>
</html>