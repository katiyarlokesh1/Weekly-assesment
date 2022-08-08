<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
welcome<h5><% String fname=(String)request.getAttribute("fname3");
        out.println(fname+"!!!");
    %></h5>
<h1> Login Here</h1><body bgcolor="cyan">

<form action=" log" method="post">
		<table style="with: 50%">

			<tr>
				<td>UserName</td>
				<td><input type="text" name="usname1" /></td>
			</tr>
				<tr>
				<td>Password</td>
				<td><input type="password" name="passrd1" /></td>
			</tr>
		</table>
		<input type="submit" value="Login" /></form>
</body>

</html>