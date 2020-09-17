<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>MEMBER LOGIN</h1>
	<form action="${cp}/member/loginPro" method="post">
		<table>
			<tr>
				<td>ID</td>
				<td><input type="text" name="memId" ></td>
			</tr>
			<tr>
				<td>PW</td>
				<td><input type="text" name="memPw" ></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Login"></td>
			</tr>
		</table>
		
	</form>

	<p></p>
	<a href="${cp}/">MAIN</a>
</body>
</html>