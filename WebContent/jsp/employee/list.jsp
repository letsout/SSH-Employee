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
		<table>
			<tr>
				<td><a href="${pageContext.request.contextPath}/employee_save.action">添加</a></td>
			</tr>
		</table>
		<table align="center" border="1" cellspacing="0">
		<tr>
				<td>姓名</td>
				<td>性别</td>
				<td>生日</td>
				<td>入职时间</td>
				<td>工号</td>
				<td>账号</td>
				<td>密码</td>
				<td>所处部门</td>
				<td>删除</td>
				<td>编辑</td>
			</tr>
			<s:iterator value="list" var="e">
			<tr>
				<td><s:property value="#e.ename"/></td>
				<td><s:property value="#e.sex"/></td>
				<td><s:date name="#e.birthday" format="yyyy-MM-dd"/></td>
				<td><s:date name="#e.jionDate" format="yyyy-MM-dd"/></td>
				<td><s:property value="#e.eno"/></td>
				<td><s:property value="#e.username"/></td>
				<td><s:property value="#e.password"/></td>
				<td><s:property value="#e.department.dname"/></td>
				<td><a href="${pageContext.request.contextPath}/employee_delete.action?eid=<s:property value="#e.eid"/>">删除</a></td>
				<td><a href="${pageContext.request.contextPath}/employee_edit.action?eid=<s:property value="#e.eid"/>">修改</a></td>
			</tr>
			</s:iterator>
		</table>
		<table align="center">
			<tr>
				<td>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</td>
				<td>总纪录数<s:property value="totalCount"/> </td>
				<td>每页显示数<s:property value="pageSize"/> </td>
				<td>
					<s:if test="currPage!=1">
						<a href="${pageContext.request.contextPath}/employee_findAll.action?currPage=1">首页</a>
						<a href="${pageContext.request.contextPath}/employee_findAll.action?currPage=<s:property value="currPage-1"/>">上一页</a>
					</s:if>
					<s:if test="currPage!=totalPage">
						<a href="${pageContext.request.contextPath}/employee_findAll.action?currPage=<s:property value="currPage+1"/>">下一页</a>
						<a href="${pageContext.request.contextPath}/employee_findAll.action?currPage=<s:property value="totalPage"/>">尾页</a>
					</s:if>
				</td>
			</tr>
		</table>
</body>
</html>