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
<h1>쿠키 정보 보기</h1>
<%
	Cookie[] cookies = request.getCookies();
	if(cookies!=null&&cookies.length>0){
		for(int i=0;i<cookies.length;i++){
			if(cookies[i].getName().equals("name")){
			%>
			<%=cookies[i].getName() %> : <%=URLDecoder.decode(cookies[i].getValue(),"utf-8") %>
			<br>
			${cookie.name.value }
			<!-- name의 getValue메서드 호출 -->
			<!-- 디코딩을 위한 JSTL사용 필요함. -->
			<% 
			}}
		}else{
			%>
			저장된 쿠키 정보가 없습니다.
			<%
	}
%>
<a href="addCookie.jsp">쿠키 수정하기</a><br>
<a href="deleteCookie.jsp">쿠키 삭제하기</a>
</body>
</html>