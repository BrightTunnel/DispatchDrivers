<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>Trucks' Status</title>
<link rel="stylesheet" href="style.css">
</head>
<body>
	<h2>Trucks' Status</h2>
	<table>
		<tr>
			<th>Dock</th>
			<th>Driver</th>
			<th>Status</th>
		</tr>
		<%
			String outStr = "";
			Long rndInt;
			for (int ii = 0; ii < 9; ii++) {
				rndInt = Math.round(Math.random() * 6575);
				outStr += "<tr><td>000" + (ii + 1) + "</td><td>" + ((ii + 1) * 100000 + rndInt) + "</td><td> "
						+ (rndInt % 2 == 0 ? "Go" : "Loading") + "</td></tr>";
			}
			// for (String s : ss) {}
			out.println(outStr);
		%>
	</table>
	<br>Note:
	<%
		// String[] ss = (String[]) request.getReader().lines().collect(Collectors.joining());
		String attr;
		attr = (String) request.getAttribute("attr001");
		out.println("<br>Attribute: " + attr);
		attr = (String) request.getAttribute("attr002");
		out.println("<br>Attribute: " + attr);
		attr = (String) request.getAttribute("attr003");
		out.println("<br>Attribute: " + attr);
		attr = (String) request.getParameter("parInRqstStr"); // html address parameter {http://localhost:8082/DispatchDrivers/showView003?parInRqstStr=any}
		out.println("<br>Parameter: " + attr);
		attr = (String) request.getHeader("Accept-Encoding"); // {gzip, deflate} request's meta data
		out.println("<br>Header {Accept-Encoding}: " + attr);
	%>
	<br> <%-- The test jsp got the messageContent: ${messageContent} --%>
	<br>
	<a href="index.jsp">Home</a>
</body>
</html>