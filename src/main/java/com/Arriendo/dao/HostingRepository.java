package com.Arriendo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Arriendo.entity.Hosting;

//by extending JpaRepository we have access to its CRUD method for given Entity without writing actual implementation

public interface HostingRepository extends JpaRepository<Hosting, String> {

}
