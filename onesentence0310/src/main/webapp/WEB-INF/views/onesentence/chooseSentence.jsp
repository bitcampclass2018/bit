<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사진에서 추출한 문장선택</title>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
</head>
<body>
	<h3>한문장을 선택하세요.</h3>
	<ul>
	<c:forTokens var="OneSentence" items ="${OneSentenceList}" delims="." >
		<li><input type="radio" name="sentence" value="${OneSentence}">${OneSentence}</li>
	</c:forTokens>	
	<li><input type="submit" value="선택" id="choose"></li>
	</ul>
<script>
	$('#choose').on('click',function(){
		opener.document.getElementById("oneSentence").value=$('input:checked').val();
		window.close();
	});

</script>	
</body>
</html>