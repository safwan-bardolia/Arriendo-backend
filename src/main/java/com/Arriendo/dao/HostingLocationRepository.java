package com.Arriendo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Arriendo.entity.HostingLocation;

// by extending jpa repository interface we get rest end-points out of the box
public interface HostingLocationRepository extends JpaRepository<HostingLocation, String> {

}
