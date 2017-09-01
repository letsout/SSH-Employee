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
	<span>欢迎：<s:property value="#session.existEmployee.ename"/></span>
	<table align="center" border="1">
		<tr>
			<td align="left">部门管理</td>
			<td align="right"><a href="${pageContext.request.contextPath }/department_saveDepartment.action">添加</a></td>
		</tr>
	</table>
	<table align="center" border="1">
		<tr>
			<td>部门名称</td>
			<td>编辑</td>
			<td>删除</td>
		</tr>
	<s:iterator value="list" var="d">
			<tr>
			<td align="center" width=""><s:property value="#d.dname"/></td>
			<td><a href="${pageContext.request.contextPath }/department_edit.action?did=<s:property value="#d.did"/>">修改</a></td>
			<td><a href="${pageContext.request.contextPath }/department_delete.action?did=<s:property value="#d.did"/>">删除</a></td>
			</tr>
		</s:iterator>
	</table>
	<table align="center" border="1">
		<tr>
			<td>
				<span>第<s:property value="currPage"/>/<s:property value="totalPage"/>页</span>&nbsp;&nbsp;
				<span>总记录数<s:property value="totalCount"/></span>&nbsp;&nbsp;每页显示<s:property value="pageSize"/>
				<span>
					<s:if test="currPage!=1">
						<a href="${pageContext.request.contextPath }/department_findAll.action?currPage=1">[首页]</a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="currPage-1"/>">[上一页]</a>&nbsp;&nbsp;
					</s:if>·
					<s:if test="currPage!=totalPage">
						<a href="${pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="currPage+1"/>">[下一页]</a>&nbsp;&nbsp;
						<a href="${pageContext.request.contextPath }/department_findAll.action?currPage=<s:property value="totalPage"/>">[尾页]</a>&nbsp;&nbsp;
					</s:if>
				</span>				
			</td>
		</tr>
	</table>
</body>
</html>