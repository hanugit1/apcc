<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightblue">
	<center style="margin-top: 100px;">
		<h1 style="color: green;">Welcome to O2 Login Page</h1>
		<form action="o2Login" method="post">
			<fieldset
				style="height: 120px; width: 80px; color: darkblue; border-color: lightgreen">
				<table>
					<tr>
						<td>Account Number:</td>
						<td><input type="text" name="accNum" required
							style="height: 20px; width: 160px; font-size: 14px; color: darkblue;">
						</td>
					</tr>
					<tr>
						<td>Mobile Number:</td>
						<td><input type="number" name="mobNum" required
							style="height: 20px; width: 160px; font-size: 14px; color: darkblue;">
						</td>
					</tr>
					<tr>
						<td>Passwaord:</td>
						<td><input type="password" name="pass" required
							style="height: 20px; width: 160px; font-size: 14px; color: darkblue;">
						</td>
					</tr>
					<tr>
						<td></td>
						<td><input type="submit" name="Login" required
							style="height: 23px; width: 165px; font-size: 16px; color: darkblue;">
						</td>
					</tr>
				</table>
			</fieldset>
		</form>
	</center>

</body>
</html>