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
		<h1 style="color: green;">Welcome to O2Login Page</h1>
		<form action="registerVerify" method="post">
			<table>
				<tr>
					<td><b style="margin-left: 50px; font: 40px; color: darkblue;">Mobile
							Number:</b></td>
					<td>${regFormData.mobNum}</td>
				</tr>
				<tr>
					<td><b style="margin-left: 50px; font: 40px; color: darkblue;">Card
							Number:</b></td>
					<td>${regFormData.cardNum}</td>
				</tr>
				<tr>
					<td><b style="margin-left: 50px; font: 40px; color: darkblue;">Cvv
							Number:</b></td>
					<td>"${regFormData.cvvNum}</td>
				</tr>
				<tr>
					<td><b style="margin-left: 50px; font: 40px; color: darkblue;">Expiry
							Date:</b></td>
					<td>${regFormData.cardNum}</td>
				</tr>
				<tr>
					<td><b style="margin-left: 50px; font: 40px; color: darkblue;">Name
							On Card:</b></td>
					<td>${regFormData.nameOnCard}</td>
				</tr>
				<tr>
					<td><a href="register"> <b
							style="margin-left: 50px; font: 40px; color: darkblue;">Back</b>
					</a></td>
					<td><a href="o2Login"> <b
							style="margin-left: 50px; font: 40px; color: darkblue;">Cancel</b>
					</a></td>

					<td><input type="submit" value="Submit"
						style="height: 19px; width: 90px; font-size: 13px; color: darkblue; background-color: lightgreen">
					</td>
				</tr>

			</table>
		</form>
	</center>
</body>
</html>