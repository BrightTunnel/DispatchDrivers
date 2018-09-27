<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="com.dispatch.beans.PojoDock"%>
<%@ page import="java.util.HashMap"%>
<%@ page import="java.util.Map"%>
<!DOCTYPE html>
<html>
<head>
<title>Docks' Status</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<br>
	<h2>Docks' Status</h2>
	<br>
	<table>
		<tr>
			<th>DockID</th>
			<th>DriverID</th>
			<th>TruckPlate</th>
			<th>DockStatus</th>
			<th>DockName</th>
			<th>Notes</th>
			<th>BusyDate</th>
			<th>ReleaseDate</th>
		</tr>
		<%
			Map<Long, PojoDock> docks = (HashMap<Long, PojoDock>) request.getAttribute("objDocks");
			String outStr = "";
			PojoDock dr = null;
			for (Map.Entry<Long, PojoDock> entry : docks.entrySet()) {
				dr = new PojoDock();
				dr = entry.getValue();
				outStr += "<td>" + dr.getDockID() + "</td>";
				outStr += "<td>100" + dr.getDriverID() + "</td>";
				outStr += "<td>" + dr.getTruckPlate() + "</td>";
				outStr += "<td>" + dr.getDockStatus() + "</td>";
				outStr += "<td>" + dr.getDockName() + "</td>";
				outStr += "<td>" + dr.getNotes() + "</td>";
				outStr += "<td>" + (dr.getBusyDate() != null ? dr.getBusyDate() : "") + "</td>";
				outStr += "<td>" + (dr.getReleaseDate() != null ? dr.getReleaseDate() : "") + "</td>";
				outStr += "</tr>";
			}
			out.println(outStr);
		%>
	</table>
	<br>
	<br>
	<a href="index.jsp">Dashboard</a> |
	<a href="index.jsp">Add dock</a> |
	<a href="index.jsp">Edit dock</a> |
	<a href="index.jsp">Delete dock</a>
</body>
</html>