package com.Arriendo.service;

import java.util.List;
import java.util.Optional;

import com.Arriendo.entity.Hosting;

public interface HostingService {

	public void save(Hosting hosting);
	
	public void update(Hosting hosting);
	
	public List<Hosting> findAll();
	
	public Optional<Hosting> findById(String uid);
	
	public void delete(String uid);
	
	public void sendRegistrationEmail(String email, String userName);
}
