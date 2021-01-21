package com.Arriendo.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Arriendo.dao.HostingRepository;
import com.Arriendo.entity.Hosting;

@Service
public class HostingServiceImpl implements HostingService {

	@Autowired
	private HostingRepository repository;
	
	@Override
	public void save(Hosting hosting) {

		// setting user proof file
		hosting.setAadharFileName(hosting.getAadharFile().getOriginalFilename());
		hosting.setAadharFileType(hosting.getAadharFile().getContentType());
	
		// setting residential proof file
		hosting.setResidentialFileName(hosting.getResidentialFile().getOriginalFilename());
		hosting.setResidentialFileType(hosting.getResidentialFile().getContentType());
		
		// setting parking photo
		hosting.setParkingPhotoName(hosting.getParkingPhoto().getOriginalFilename());
		hosting.setParkingPhotoType(hosting.getParkingPhoto().getContentType());
		
		try {
			hosting.setAadharFileData(hosting.getAadharFile().getBytes());
			hosting.setResidentialFileData(hosting.getResidentialFile().getBytes());
			hosting.setParkingPhotoData(hosting.getParkingPhoto().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		repository.save(hosting);
	}

	@Override
	public List<Hosting> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Hosting> findById(String uid) {
		return repository.findById(uid);
	}

	@Override
	public void delete(String uid) {
		repository.deleteById(uid);
	}

}
