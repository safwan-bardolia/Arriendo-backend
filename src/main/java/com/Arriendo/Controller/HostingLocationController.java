package com.Arriendo.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Arriendo.entity.HostingLocation;
import com.Arriendo.exception.HostingLocationNotFoundException;
import com.Arriendo.service.HostingLocationService;

@CrossOrigin(value = {"*"})
@RestController
public class HostingLocationController {

	@Autowired
	private HostingLocationService service;
	
	private static final Logger logger = LoggerFactory.getLogger(HostingLocationController.class);
	
	// return list of all the location
	@GetMapping("/hostinglocations")
	public List<HostingLocation> findAll() {
		return service.findAll();
	}
	
	// return single location
	@GetMapping("/hostinglocations/{uid}")
	public HostingLocation findById(@PathVariable String uid) {
		Optional<HostingLocation> result = service.findById(uid);
		
		// if record is not present then throw an exception
		if(!result.isPresent()) {
			throw new HostingLocationNotFoundException("no location was found");
		}
		
		return result.get();
	}
	
	@PostMapping("/hostinglocations")
	public ResponseEntity save(@ModelAttribute HostingLocation hostingLocation) throws Exception {
		
		// first check if the record is present with same user (i.e same gmail account)	
		Optional<HostingLocation> result = service.findById(hostingLocation.getUid());
		
		if(result.isPresent()) {
			throw new Exception("location already present (duplication found)");
		} else {
			service.saveOrUpdate(hostingLocation);
		}
		
		service.sendLocationConfirmationEmail(hostingLocation.getEmail(), hostingLocation.getFullName());
		
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/hostinglocations")
	public ResponseEntity update(@ModelAttribute HostingLocation hostingLocation) {
		
		// first fetch the record from the db. and If record not found then throw an exception
		Optional<HostingLocation> result = service.findById(hostingLocation.getUid());
		
		// if record is not present then throw an exception
		if(!result.isPresent()) {
			throw new HostingLocationNotFoundException("no location was found");
		}
		
		service.saveOrUpdate(hostingLocation);
		
		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/hostinglocations/{uid}")
	public String delete(@PathVariable String uid) {
		service.delete(uid);
		
		return "location deleted with uid - "+uid;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
