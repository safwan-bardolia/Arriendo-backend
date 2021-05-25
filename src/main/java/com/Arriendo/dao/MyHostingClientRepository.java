package com.Arriendo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.Arriendo.entity.MyHostingClient;

public interface MyHostingClientRepository extends JpaRepository<MyHostingClient, String> {

	// pk is host_id+driver_id, so we find all the record of particular host	
	@Query("SELECT h FROM MyHostingClient h WHERE h.uid LIKE ?1%")
	public List<MyHostingClient> searchByUidStartsWith(String id);
}
