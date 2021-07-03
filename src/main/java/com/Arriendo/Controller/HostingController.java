package com.Arriendo.Controller;


import java.util.List;
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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Arriendo.entity.Hosting;
import com.Arriendo.exception.HostingNotFoundException;
import com.Arriendo.service.HostingService;

//@CrossOrigin(origins = { “http://localhost:3000”, “http://localhost:4200” }) - Allow requests from specific origins
@CrossOrigin(value = {"*"}, exposedHeaders = {"Content-Disposition"})
@RestController
public class HostingController {
	
	@Autowired
	private HostingService service;

	private static final Logger logger  = LoggerFactory.getLogger(HostingController.class);
	
	// return list of Hosting data	
	@GetMapping("/hostings")
	public List<Hosting> findAll() {
		return service.findAll();
	}

	// return single Hosting record
	@GetMapping("/hostings/{uid}")
	public Hosting findById(@PathVariable String uid) {
		
		Optional<Hosting> result = service.findById(uid);
		
		// if record not found then throws an exception		
		if(!result.isPresent()) {
			throw new HostingNotFoundException("record not found");
		}
		
		return result.get();
	}
	
	@PostMapping(value = "/hostings", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity saveHosting(@ModelAttribute Hosting hosting) {
				
		// first check if the record is present with same user (ie with same gmail account )
		Optional<Hosting> result = service.findById(hosting.getUid());
		if(result.isPresent()) {
			// throw exception here			
		} else {
			service.save(hosting);
		}
		
		// send registration mail
		service.sendRegistrationEmail(hosting.getEmail(), hosting.getFullName());
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value = "/hostings", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity updateHosting(@ModelAttribute Hosting hosting) {
		
		service.update(hosting);
		return ResponseEntity.ok().build();
	}
	
	// for updating totalVehicles prop	
	@PatchMapping("/hostings")
	public ResponseEntity updateVehicleCount(@ModelAttribute Hosting hosting) {
		
		// first fetch the record		
		Hosting host = service.findById(hosting.getUid()).get();
		
		// update the require property
		host.setTotalVehicles(hosting.getTotalVehicles());
		
		service.updateVehicleCount(host);
		
		return ResponseEntity.ok().build();
	}
	
	// for updating verification prop
	@PatchMapping("/hostverification")
	public ResponseEntity updateVerification(@ModelAttribute Hosting hosting) {
		// first fetch the record		
		Hosting host = service.findById(hosting.getUid()).get();
		
		// update the require property
		host.setVerification(hosting.getVerification());
		
		service.updateVerification(host);

		return ResponseEntity.ok().build();
	}
			
	@DeleteMapping("/hostings/{uid}")
	public String deleteById(@PathVariable String uid) {
		
		service.delete(uid);
		
		return "deleted record with uid - "+ uid;
	}
		
	@GetMapping("/hostings/{hostMail}/{clientMail}/{fullName}/{mobile}")
	public ResponseEntity generateOtp(@PathVariable String hostMail, @PathVariable String clientMail, @PathVariable String fullName, @PathVariable String mobile) {
	
		service.generateOtp(hostMail, clientMail, fullName, mobile);
		
		return ResponseEntity.ok().build();
	}
}
