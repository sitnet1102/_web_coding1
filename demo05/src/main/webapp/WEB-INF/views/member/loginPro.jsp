<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1> MEMBER LOGIN OK </h1>
	
	ID : ${member.memId}<br />
	PW : ${member.memPw}<br />
		
	<a href="${cp}/"> MAIN </a>
</body>
</html>