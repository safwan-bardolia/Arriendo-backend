package com.Arriendo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Arriendo.entity.MyBooking;

public interface MyBookingRepository extends JpaRepository<MyBooking, String> {

}
