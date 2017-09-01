<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="X-UA-Compatible" content="IE=edge">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>登陆页面</title>
		<link href="${pageContext.request.contextPath}/css/all.css" type="text/css" rel="stylesheet">
		<link href="${pageContext.request.contextPath}/css/bootstrap.min.css" type="text/css" rel="stylesheet">
		<style type="text/css">
			.logo-text {
				font-size: 20px;
				color: #666;
				padding: 10px 0;
			}
			.forget{
				margin-left: 20px;
				color:#bdbdbd;
			}
		</style>
	</head>

	<body>
		<div class="container-fluid">
			<div class="row">
			<div class="col-md-6 col-xs-12 col-md-offset-3">
				<p class="col-md-12 text-center logo-text">成都师范学院教学评价系统</p>
				<div class="logo col-md-12 text-center">
					<img src="images/logo.jpg">
				</div>
			
				<form class="col-xs-12 col-md-6 col-md-offset-3" action="employee_login" method="post">
					<div class="form-group">
						<h3><s:actionerror/></h3>
						<label for="exampleInputEmail1">用户名</label>
						<input type="text" class="form-control" id="exampleInputEmail1" name="username" placeholder="请输入用户名">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">密码</label>
						<input type="password" class="form-control" id="exampleInputPassword1"  name ="password" placeholder="请输入密码">
					</div>
					<div class="checkbox">
						<label>
      						<input type="checkbox">记住我<span class="forget">忘记密码？<a href="#">去注册</a></span>
    					</label>
					</div>
					<button type="submit" class="col-md-12 col-xs-12 btn btn-success">登录</button>
					<s:fielderror />
				</form>

			</div>
			</div>
		</div>
		<script type="text/javascript" src="js/jquery-1.12.4.min.js">
		</script>
		<script type="text/javascript" src="js/bootstrap.min.js">
		</script>
	</body>
</html>