package com.Arriendo.service;

import java.util.List;
import java.util.Optional;

import com.Arriendo.entity.HostingLocation;

public interface HostingLocationService {

	public void saveOrUpdate(HostingLocation hostingLocation);
		
	public List<HostingLocation> findAll();
	
	public Optional<HostingLocation> findById(String uid);
	
	public void delete(String uid);
	
	public void sendLocationConfirmationEmail(String email, String userName);
}
