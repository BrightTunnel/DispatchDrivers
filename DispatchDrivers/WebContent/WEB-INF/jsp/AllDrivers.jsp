<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.dispatch.beans.PojoDriver"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<title>Drivers' Status</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<br>
	<h2>Drivers' Status</h2>
	<br>
	<table>
		<tr>
			<th>DriverID</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Email</th>
			<th>Phone</th>
			<th>Address</th>
			<th>Urgency</th>
			<th>IsAdmin</th>
			<th>DateCreated</th>
		</tr>
		<%
			Map<Long, PojoDriver> drivers = (HashMap<Long, PojoDriver>) request.getAttribute("objDrivers");
			String outStr = "";
			PojoDriver dr = null;
			for (Map.Entry<Long, PojoDriver> entry : drivers.entrySet()) {
				dr = new PojoDriver();
				dr = entry.getValue();
				outStr += "<td>100" + dr.getDriverID() + "</td>";
				outStr += "<td>" + dr.getFirstName() + "</td>";
				outStr += "<td>" + dr.getLastName() + "</td>";
				outStr += "<td>" + dr.getEmail() + "</td>";
				outStr += "<td>" + dr.getPhone() + "</td>";
				outStr += "<td>" + dr.getAddress() + "</td>";
				outStr += "<td>" + dr.getUrgency() + "</td>";
				outStr += "<td>" + dr.getIsAdmin() + "</td>";
				outStr += "<td>" + dr.getDateCreated() + "</td>";
				outStr += "</tr>";
			}
			out.println(outStr);
		%>
	</table>
	<br>
	<br>
	<a href="index.jsp">Dashboard</a> |
	<a href="index.jsp">Add driver</a> |
	<a href="index.jsp">Edit record</a> |
	<a href="index.jsp">Delete record</a>
</body>
</html>