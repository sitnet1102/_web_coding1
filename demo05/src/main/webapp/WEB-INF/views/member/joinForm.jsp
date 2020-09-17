<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="${cp}/resources/css/normal.css" />
</head>
<body>
	<h1>MEMBER JOIN</h1>	
	<form action="${cp}/member/joinPro" method="post">
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
				<td>MAIL</td>
				<td><input type="text" name="memMail" ></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="Join" >
					<input type="reset" value="Cancel" >
				</td>
			</tr>
		</table>			
	</form>
	<p></p>
	<a href="${cp}/">MAIN</a>
</body>
</html>