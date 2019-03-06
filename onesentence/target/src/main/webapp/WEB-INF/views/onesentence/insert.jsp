<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한문장작성</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
<form method="post" action="./insert">

		<ul>
			<li>
			<label for="isbn">isbn(안보임)</label>
			<input type="text" id="isbn" name="isbn"></li>
			<li>
			<label for="userIdx">작성자(안보임)</label>
			<input type="text" id="userIdx" name="userIdx"></li>
			<li>
			<label for="page">페이지</label>
			<input type="text" id="page" name="page"></li>
			<li>
			<label for="oneSentence">한문장</label>
			<input type="text" id="oneSentence" name="oneSentence"></li>
			<li><input type="submit" value="작성" id="btn"></li>
		</ul>
</form>		
</body>
</html>