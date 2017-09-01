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
	<s:form action="employee_update.action" method="post" theme="simple">
		<s:hidden name="eid" value="%{model.eid}"/>
		<table>
			<tr>
				<td>姓名：</td>
				<td><s:textfield name="ename" value="%{model.ename}"/></td>
			</tr>
			<tr>
				<td>性别：</td>
				<td><s:radio name="sex" list="{'男','女'}" value="%{model.sex}" /></td>
			</tr>
			<tr>
				<td>生日：</td>
				<td><input type="text" name="birthday" value="<s:date name="model.birthday" format="yyyy-MM-dd"/>"/></td>
			</tr>
			<tr>
				<td>入职时间：</td>
				<td><input type="text" name="jionDate" value="<s:date name="model.jionDate" format="yyyy-MM-dd"/>"/></td>
			</tr>
			<tr>
				<td>工号：</td>
				<td><s:textfield name="eno" value="%{model.eno}"/></td>
			</tr>
			<tr>
				<td>账号：</td>
				<td><s:textfield name="username" value="%{model.username}"/></td>
			</tr>
			<tr>
				<td>密码：</td>
				<td><s:textfield name="password" value="%{model.password}"/></td>
			</tr>
			<tr>
				<td>所属部门：</td>
				<td><s:select name="department.did" list="list" listKey="did"  value="%{model.department.did}" listValue="dname" headerKey="" headerValue="--请选折--"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="修改"/></td>
			</tr>
		</table>		
	</s:form>
</body>
</html>