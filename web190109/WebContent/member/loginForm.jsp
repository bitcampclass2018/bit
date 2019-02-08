<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login Form</title>
</head>
<body>
<h1>Login Form</h1>
<form action="Login.jsp" method="post">
<table>
	<tr>
		<td>ID</td>
		<td><input type="text" name="uid"></td>
	</tr>
	<tr>
		<td>PW</td>
		<td><input type="password" name="upw"></td>
	</tr>
	<tr>
		<td colspan="2"><input type="submit" value="로그인"></td>
	</tr>
</table>
</form>
</body>
</html>