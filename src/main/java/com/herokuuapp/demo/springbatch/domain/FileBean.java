package com.herokuuapp.demo.springbatch.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FileBean {
    private String id, fileName, userLocation, userEmail;

	public FileBean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FileBean(String id, String fileName, String userLocation, String userEmail) {
		super();
		this.id = id;
		this.fileName = fileName;
		this.userLocation = userLocation;
		this.userEmail = userEmail;
	}

	@Id
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getUserLocation() {
		return userLocation;
	}

	public void setUserLocation(String userLocation) {
		this.userLocation = userLocation;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
    
    
}
