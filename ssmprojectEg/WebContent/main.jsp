<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>welcome</title>
</head>
<body>
<h2>Testing</h2>
userName:${user.userName}<br>
userId:${user.userId}<br>
userEmail:${user.userEmail}<br>
userPassword:${user.userPassword}<br>

<a href="MVC/GetList">开始</a>
<p/>
<a href="MVC/Pagelist2?name=小小&page=1">test</a>

</body>
</html>