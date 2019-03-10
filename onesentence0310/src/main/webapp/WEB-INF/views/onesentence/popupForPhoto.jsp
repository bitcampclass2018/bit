<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사진업로드</title>
</head>
<body>
	<form method="post" action="getSentence" enctype="multipart/form-data">
		<label for="photo">사진에서 찾기</label>
		 <input type="file" id="photo" name="photo"><br>
		 <input type="submit" value="찾기" id="btn">
	</form>
</body>
</html>