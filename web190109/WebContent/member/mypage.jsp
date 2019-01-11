<%@page import="member.MemberInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberInfo memberInfo = (MemberInfo)session.getAttribute("loginInfo"); //object타입으로 반환하므로 형변환 필수
	boolean login = memberInfo==null?false:true;
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Mypage</title>
</head>
<body>
	<%
		if(login){
			%>
			<h3><a href="Logout.jsp">로그아웃</a></h3>
			<h2> <%=memberInfo.getName() %>(<%=memberInfo.getId() %>)님  안녕하세요.</h2>
			<h2>${loginInfo.name}(${loginInfo.id})님  안녕하세요.</h2>
			<!-- EL사용하기 -->
			<%
		}else{
			%>
			<h2>회원전용 페이지 입니다. <a href="loginForm.jsp">로그인하기</a></h2>
			<%
		}
	%>
</body>
</html>