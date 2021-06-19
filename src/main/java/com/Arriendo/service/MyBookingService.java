package com.Arriendo.service;

import java.util.Optional;

import com.Arriendo.entity.MyBooking;

public interface MyBookingService {

	public void save(MyBooking myBooking );
	
	public void updateConfirmation(MyBooking myBooking);
	
	public Optional<MyBooking> findById(String uid);
	
	public void delete(String uid);

}
