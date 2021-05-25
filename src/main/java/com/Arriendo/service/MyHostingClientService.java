package com.Arriendo.service;

import java.util.List;
import java.util.Optional;
import com.Arriendo.entity.MyHostingClient;

public interface MyHostingClientService {
	
	public void saveOrUpdate(MyHostingClient myHostingClient);
	
	// may be not needed	
	public List<MyHostingClient> findAll();

	public Optional<MyHostingClient> findById(String uid);
	
	public void delete(String uid);

	// find all the record of particular host 		
	public List<MyHostingClient> searchByUidStartsWith(String id);
}
