package com.Arriendo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Arriendo.dao.MyHostingClientRepository;
import com.Arriendo.entity.MyHostingClient;

@Service
public class MyHostingClientServiceImpl implements MyHostingClientService {

	@Autowired
	private MyHostingClientRepository repository;
	
	@Override
	public void saveOrUpdate(MyHostingClient myHostingClient) {
		repository.save(myHostingClient);
	}

	@Override
	public List<MyHostingClient> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<MyHostingClient> findById(String uid) {
		return repository.findById(uid);
	}

	@Override
	public void delete(String uid) {
		repository.deleteById(uid);
	}

	@Override
	public List<MyHostingClient> searchByUidStartsWith(String id) {
		return repository.searchByUidStartsWith(id);
	}

}
