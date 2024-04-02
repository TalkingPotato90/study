<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>test_el</title>
	<script type = "text/javascript">
		// EL(Expression Language)은 JSP와 JavaScript의 문법이 같다. JSP가 우선한다.
		<% // scriptlet : JSP
			pageContext.setAttribute("name", "진수현");
		%>
		
		let name = "윤웅찬";
		alert(`내 이름은 ${name}입니다.`); // EL은 JSP와 문법이 같아서 이름이 출력되지 않는다.
		alert("내 이름은 " + name + "입니다."); // 기존의 문법을 사용하면 JavaScript의 변수를 사용한다.
	</script>
</head>
<body>

</body>
</html>