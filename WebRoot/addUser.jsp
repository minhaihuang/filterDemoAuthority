<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加用户的页面</title>
</head>
<body>
<div align="center">
<h3>添加用户页面</h3>
<hr/>
<form action="AddUserServlet.auth">

<label>用户名：</label><input type="text" name="username" /><br/>
<label>密   码：</label><input type="password" name="password" /><br/>
<input type="submit" value="添加用户" />
</form>
</div>
</body>
</html>