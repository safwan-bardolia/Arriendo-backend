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
		
		return service.findById(uid).get();
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
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping(value = "/hostings", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponseEntity updateHosting(@ModelAttribute Hosting hosting) {
		
		service.save(hosting);
		return ResponseEntity.ok().build();
	}
			
	@DeleteMapping("/hostings/{uid}")
	public String deleteById(@PathVariable String uid) {
		
		service.delete(uid);
		
		return "deleted record with uid - "+ uid;
	}
		
}
