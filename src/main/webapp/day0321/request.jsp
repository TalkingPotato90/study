<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- back-end 입력값을 받아서 업무로직을 처리한다. -->
	<!-- 응답화면을 만든다. -->
	<strong>${ param.id eq '윤웅찬'?'반장':'평민' }</strong>님 어서오고!
</body>
</html>