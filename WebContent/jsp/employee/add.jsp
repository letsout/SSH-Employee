<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<s:form action="employee_add.action" method="post">
		<table>
			<tr>
				<td>姓名：</td>
				<td><input type="text" name="ename"/></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><s:radio name="sex" list="{'男','女'}"/></td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><input type="text" name="birthday"/></td>
			</tr>
			<tr>
				<td>入职时间：</td>
				<td><input type="text" name="jionDate"/></td>
			</tr>
			<tr>
				<td>工号：</td>
				<td><input type="text" name="eno"/></td>
			</tr>
			<tr>
				<td>账号：</td>
				<td><input type="text" name="username"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><input type="text" name="password"/></td>
			</tr>
			<tr>
				<td>所属部门：</td>
				<td><s:select name="department.did" list="list" listKey="did" listValue="dname" headerKey="" headerValue="--请选折--"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="添加"/></td>
			</tr>
		</table>
	</s:form>
</body>
</html>