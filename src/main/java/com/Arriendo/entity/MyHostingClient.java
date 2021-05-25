package com.Arriendo.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class MyHostingClient {

	@Id
	private String uid;
	
	// it maps to 'MyBooking'	
	private String driver_uid;

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public String getDriver_uid() {
		return driver_uid;
	}

	public void setDriver_uid(String driver_uid) {
		this.driver_uid = driver_uid;
	}

	@Override
	public String toString() {
		return "MyHostingClient [uid=" + uid + ", driver_uid=" + driver_uid + "]";
	}
}
