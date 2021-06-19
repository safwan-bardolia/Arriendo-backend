package com.Arriendo.Controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Arriendo.entity.Hosting;
import com.Arriendo.entity.MyBooking;
import com.Arriendo.exception.MyBookingNotFoundException;
import com.Arriendo.service.MyBookingService;

@CrossOrigin(value = {"*"})
@RestController
public class MyBookingController {

	@Autowired
	private MyBookingService service;
	
	private static final Logger logger  = LoggerFactory.getLogger(MyBookingController.class);
	
	// return single record
	@GetMapping("/mybookings/{uid}")
	public MyBooking findById(@PathVariable String uid) {
		
		Optional<MyBooking> result = service.findById(uid);
		
		// if record not found then throw an exception
		if(!result.isPresent()) {
			throw new MyBookingNotFoundException("record not found");
		}
		
		return result.get();
	}


	@PostMapping(value = "/mybookings", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity save(@ModelAttribute MyBooking myBooking) {
		// first check if the record is present with same user (ie with same gmail account )
		Optional<MyBooking> result = service.findById(myBooking.getC_uid());
		if(result.isPresent()) {
			// throw exception here			
		} else {
			service.save(myBooking);
		}

		return ResponseEntity.ok().build();
	}
	
	// for updating confirmation property
	@PatchMapping("/mybookings")
	public ResponseEntity updateConfirmation(@ModelAttribute MyBooking myBooking) {
		//first fetch the record
		MyBooking booking = service.findById(myBooking.getC_uid()).get();
		
		//update the required property
		booking.setConfirmation(myBooking.getConfirmation());
		booking.setFinal_confirmation(myBooking.getFinal_confirmation());
		
		service.updateConfirmation(booking);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/mybookings/{uid}")
	public String deleteById(@PathVariable String uid) {
		service.delete(uid);
		return "deleted record with uid - "+uid;
	}
}
