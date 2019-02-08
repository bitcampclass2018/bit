
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	/* 저장할 데이터를 가지는 쿠키 객체 생성 */
	/* 쿠키에 저장되는 값은 한글 처리 불가:인코딩 후 저장 */
	Cookie cookie= new Cookie("name",URLEncoder.encode("유은선","UTF-8")); 

	/* 응답 객체에 쿠키를 전달 */
	response.addCookie(cookie);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>쿠키생성</h1>
	<h3>
		<%=cookie.getName() %> 쿠키에 저장된값 : <%=cookie.getValue() %>
		<br><br>
	</h3>
	<a href="viewCookie.jsp">쿠키 정보 보기</a>
</body>
</html>