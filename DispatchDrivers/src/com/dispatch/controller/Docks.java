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

import com.dispatch.beans.PojoDock;

@Controller
public class Docks {

	@RequestMapping("/Docks")
	public ModelAndView entryPoint() {
		// System.out.println("Starting Connection test");

		Map<Long, PojoDock> docks = new HashMap<Long, PojoDock>();

		try {
			Class.forName("net.sourceforge.jtds.jdbc.Driver");
			String url;
			url = "jdbc:jtds:sqlserver://USER-PC/DispatchDrivers;user=juser;password=juser;integrated security=false";
			Connection conn = DriverManager.getConnection(url, "juser", "juser");
			System.out.println("Connection successful");
			String query = "SELECT * FROM Dock";
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery(query);
			PojoDock dock = null;
			String _str = "";
			while (rs.next()) {
				dock = new PojoDock();
				dock.setDockID(rs.getLong("DockID"));
				dock.setDriverID(rs.getLong("DriverID"));
				dock.setTruckPlate(rs.getString("TruckPlate") == null ? "" : rs.getString("TruckPlate"));
				dock.setDockStatus(rs.getInt("DockStatus"));
				dock.setDockName(rs.getString("DockName") == null ? "" : rs.getString("DockName"));
				dock.setNotes(rs.getString("Notes") == null ? "" : rs.getString("Notes"));
				dock.setBusyDate(rs.getDate("BusyDate"));
				dock.setReleaseDate(rs.getDate("ReleaseDate"));
				docks.put(dock.getDockID(), dock);
			}
		} catch (Exception e) {
			System.err.println("Cannot connect to database server. Error: " + e.getMessage());
			e.printStackTrace();
		}
		ModelAndView mav = new ModelAndView();
		mav.addObject("objDocks", docks);
		mav.setViewName("AllDocks"); // AllDocks.jsp
		return mav;
	}
}