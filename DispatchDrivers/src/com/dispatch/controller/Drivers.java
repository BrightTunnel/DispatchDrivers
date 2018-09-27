package com.dispatch.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dispatch.beans.PojoDriver;

@Controller
public class Drivers {

	@RequestMapping("/Drivers")
	public ModelAndView entryPoint() {
		// System.out.println("Starting Connection test");

		Map<Long, PojoDriver> drivers = new HashMap<Long, PojoDriver>();

		try {
			// Class.forName("net.sourceforge.jtds.jdbc.Driver");
			// Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			String url;
			url = "jdbc:jtds:sqlserver://localhost:1433;databaseName=Temp";
			url = "jdbc:jtds:sqlserver://USER-PC/temp;domain=myDomain;instance=SQLEXPRESS;integrated security=false";
			url = "jdbc:jtds:sqlserver://USER-PC;databaseName=Temp";
			url = "jdbc:jtds:sqlserver://USER-PC/DispatchDrivers;user=juser;password=juser;integrated security=false";
			// Connection connection = DriverManager.getConnection(url);
			Connection conn = DriverManager.getConnection(url, "juser", "juser");
			System.out.println("Connection successful");
			String query = "SELECT * FROM Driver";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			PojoDriver driver = null;
			String _str = "";
			while (rs.next()) {
				driver = new PojoDriver();
				driver.setDriverID(rs.getLong("DriverID"));
				driver.setFirstName(rs.getString("FirstName") == null ? "" : rs.getString("FirstName"));
				driver.setLastName(rs.getString("LastName") == null ? "" : rs.getString("LastName"));
				driver.setEmail(rs.getString("Email") == null ? "" : rs.getString("Email"));
				driver.setPhone(rs.getString("Phone") == null ? "" : rs.getString("Phone"));
				driver.setAddress(rs.getString("Address") == null ? "" : rs.getString("Address"));
				driver.setUrgency(rs.getInt("Urgency"));
				driver.setIsAdmin(rs.getInt("IsAdmin"));
				driver.setDateCreated(rs.getDate("DateCreated"));
				drivers.put(driver.getDriverID(), driver);
			}
		} catch (Exception e) {
			System.err.println("Cannot connect to database server. Error: " + e.getMessage());
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("objDrivers", drivers);
		mav.setViewName("AllDrivers"); // AllDrivers.jsp
		return mav;
	}
}