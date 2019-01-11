<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>    
    
<!-- 빈즈객체 생성 -->   
<jsp:useBean id="memberInfo" class="member.MemberInfo" />  

<!-- 사용자 입력데이터 받기 -->
<!-- 빈즈클래스의 변수 이름과 폼 name 속성의 값이 같아야 한다! -->
<jsp:setProperty property="*" name="memberInfo"/>

<!-- 빈즈의 멤버에 값을 명시적으로 입력 -->
<jsp:setProperty name="memberInfo" property="password" value="<%=memberInfo.getId() %>"/>
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td{ padding:15px;}
</style>
</head>
<body>
<table border="1">
		<tr>
			<td><label for="uid">아이디</label></td>
			<td><jsp:getProperty property="id" name="memberInfo"/><br>
			<input type="text" id="uid" name="id" value="<%=memberInfo.getId()%>"></td>
		</tr>
		<tr>
			<td><label for="uname">이름</label></td>
			<td>
			액션태그사용:<jsp:getProperty property="name" name="memberInfo"/><br>
			표현식사용:<%= memberInfo.getName() %><br>
			EL사용:${memberInfo.name}
			<!-- EL사용:${memberInfo.name}: name은 변수가 아니라 메서드호출 의미 -->
			</td>
		</tr>
		
		<tr>
			<td><label for="uemail">이메일</label></td>
			<td><jsp:getProperty property="email" name="memberInfo"/></td>
		</tr>
		<tr>
			<td><label for="uaddress">주소</label></td>
			<td><jsp:getProperty property="address" name="memberInfo"/></td>
		</tr>
	</table>
</body>
</html>