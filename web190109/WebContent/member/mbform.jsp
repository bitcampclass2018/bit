<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h1>회원가입</h1>
<form action="regProcess.jsp" method="post">
	<table>
		<tr>
			<td><label for="uid">아이디</label></td>
			<td><input type="text" id="uid" name="id"></td>
		</tr>
		<tr>
			<td><label for="uname">이름</label></td>
			<td><input type="text" id="uname" name="name"></td>
		</tr>
		
		<tr>
			<td><label for="uemail">이메일</label></td>
			<td><input type="text" id="uemail" name="email"></td>
		</tr>
		<tr>
			<td><label for="uaddress">주소</label></td>
			<td><input type="text" id="uaddress" name="address"></td>
		</tr>
		<tr>
			<td><input type="submit" value="회원가입"></td>
		</tr>
	</table>
	</form>
</body>
</html>