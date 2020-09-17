<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Join</h1>
		<form action="joinPro" method="post">
			ID : <input type="text" name="id" >
			<p></p>
			PW : <input type="password" name="pw" >
			<p></p>
			NAME : <input type="text" name="name" >
			<p></p>
			<input type="submit" value="Join" >&nbsp;&nbsp;
			<input type="reset" value="Cancel" >
		</form>
		<p></p>
		<p></p>
		<a href="login">LOGIN</a> &nbsp;&nbsp; <a href="index">MAIN</a>
</body>
</html>