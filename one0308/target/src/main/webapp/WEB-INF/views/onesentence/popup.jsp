<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="../update">
		글번호(변경x) <input type="text" name="oneSentenceIdx" id="oneSentenceIdx" value="${onesentence.oneSentenceIdx}"><br>
		isbn(변경x) <input type="text" name="isbn" value="${onesentence.isbn}"><br>
		oneSentence <input type="text" name="oneSentence" value="${onesentence.oneSentence}"><br>
		page <input type="text" name="page" value="${onesentence.page}"><br>
		
		<input type="submit" value="수정완료">
	</form>
</body>
</html>