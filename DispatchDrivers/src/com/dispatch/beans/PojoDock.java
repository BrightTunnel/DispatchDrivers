package com.dispatch.beans;

import java.io.Serializable;
import java.util.Date;

public class PojoDock implements Serializable {
	private Long dockID;
	private Long driverID;
	private String truckPlate;
	private Integer dockStatus;
	private String dockName;
	private String notes;
	private Date busyDate;
	private Date releaseDate;

	public PojoDock() {
	}

	public Long getDockID() {
		return dockID;
	}

	public void setDockID(Long dockID) {
		this.dockID = dockID;
	}

	public Long getDriverID() {
		return driverID;
	}

	public void setDriverID(Long driverID) {
		this.driverID = driverID;
	}

	public String getTruckPlate() {
		return truckPlate;
	}

	public void setTruckPlate(String truckPlate) {
		this.truckPlate = truckPlate;
	}

	public Integer getDockStatus() {
		return dockStatus;
	}

	public void setDockStatus(Integer dockStatus) {
		this.dockStatus = dockStatus;
	}

	public String getDockName() {
		return dockName;
	}

	public void setDockName(String dockName) {
		this.dockName = dockName;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getBusyDate() {
		return busyDate;
	}

	public void setBusyDate(Date busyDate) {
		this.busyDate = busyDate;
	}

	public Date getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
}
