package com.Arriendo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Arriendo.entity.MyHostingClient;
import com.Arriendo.exception.MyHostingClientNotFoundException;
import com.Arriendo.service.MyHostingClientService;

@CrossOrigin(value = {"*"})
@RestController
public class MyHostingClientController {

	@Autowired
	private MyHostingClientService service;
	
	// find all the record of particular host 	
	@GetMapping("/myhostingclients/{uid}")
	public List<MyHostingClient> findAllRecordOfParticularHost(@PathVariable String uid) {
		List<MyHostingClient> clients = service.searchByUidStartsWith(uid);
		if(clients.size()==0) {
			throw new MyHostingClientNotFoundException("client not found");
		}
		return clients;
	}
	
	@PostMapping("/myhostingclients")
	public ResponseEntity save(@ModelAttribute MyHostingClient client) {
		// first check if the record is present with same user (ie with same gmail account )
		Optional<MyHostingClient> result = service.findById(client.getUid());
		if(result.isPresent()) {
			// throw exception here			
		} else {
			service.saveOrUpdate(client);
		}

		return ResponseEntity.ok().build();
	}
	
	@DeleteMapping("/myhostingclients/{uid}")
	public String delete(@PathVariable String uid) {
		service.delete(uid);
		return "deleted record with uid - "+uid;
	}
}
