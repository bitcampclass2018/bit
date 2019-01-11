<%@page import="java.net.URLEncoder"%>
<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>쿠키 삭제</h1>
<%
	Cookie[] cookies = request.getCookies();
	if(cookies!=null&&cookies.length>0){
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().equals("name")){
				Cookie c = new Cookie("name",URLEncoder.encode("Jsp프로그래밍","utf-8"));
				c.setMaxAge(0);
				response.addCookie(c);
				
				}
			}
		}else{
			%>
			저장된 쿠키 정보가 없습니다.
			<%
	}
%>
<h3>
	<a href="viewCookie.jsp">쿠키 정보 보기</a>
</h3>
</body>
</html>