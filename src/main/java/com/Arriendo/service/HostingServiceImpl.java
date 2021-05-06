package com.Arriendo.service;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.Arriendo.ArriendoApplication;
import com.Arriendo.dao.HostingRepository;
import com.Arriendo.entity.Hosting;

@Service
public class HostingServiceImpl implements HostingService {

	// for sending mail	
	@Autowired
	private JavaMailSender javaMailSender; 
	
	@Autowired
	private HostingRepository repository;
	
	@Value("${msg.registration.subject}")
	private String subject;

	@Value("${msg.registration.text}")
	private String text;
	
	private static final Logger logger = LoggerFactory.getLogger(HostingServiceImpl.class);
	
	@Override
	public void save(Hosting hosting) {

		try {
			hosting.setAadharFileUri(saveFileInDirectory(hosting.getAadharFile().getOriginalFilename(), hosting.getAadharFile().getBytes()));
			hosting.setResidentialFileUri(saveFileInDirectory(hosting.getResidentialFile().getOriginalFilename(), hosting.getResidentialFile().getBytes()));
			hosting.setParkingPhotoUri(saveFileInDirectory(hosting.getParkingPhoto().getOriginalFilename(), hosting.getParkingPhoto().getBytes()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		repository.save(hosting);
	}
	
	@Override
	public void update(Hosting hosting) {
		
		// 1st fetch the record in order to delete old file of current user		
		Hosting hosting1 = repository.findById(hosting.getUid()).get();
		
		// deleting old files		
		deleteFileFromDirectory(hosting1.getAadharFileUri());
		deleteFileFromDirectory(hosting1.getResidentialFileUri());
		deleteFileFromDirectory(hosting1.getParkingPhotoUri());

		// save new files		
		try {
			hosting.setAadharFileUri(saveFileInDirectory(hosting.getAadharFile().getOriginalFilename(), hosting.getAadharFile().getBytes()));
			hosting.setResidentialFileUri(saveFileInDirectory(hosting.getResidentialFile().getOriginalFilename(), hosting.getResidentialFile().getBytes()));
			hosting.setParkingPhotoUri(saveFileInDirectory(hosting.getParkingPhoto().getOriginalFilename(), hosting.getParkingPhoto().getBytes()));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// finally update the record		
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
		
		// 1st fetch the record in order to delete file from directory		
		Hosting hosting = repository.findById(uid).get();
		
		deleteFileFromDirectory(hosting.getAadharFileUri());
		deleteFileFromDirectory(hosting.getResidentialFileUri());
		deleteFileFromDirectory(hosting.getParkingPhotoUri());
		
		repository.deleteById(uid);
	}

	public String saveFileInDirectory(String fileName, byte[] bytes) {
		// construct path in a file system using a directory and a filename	
		Path fileNameAndPath = Paths.get(ArriendoApplication.uploadDirectory,fileName);
			
		try {
			// save into directory			
			Files.write(fileNameAndPath, bytes);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		logger.info(String.format("File name '%s' upload successfully.", fileName));
		
		return fileNameAndPath.toUri().toString();
	}
	
	public void deleteFileFromDirectory(String filePath) {
		
		try {
			URI uri = new URI(filePath);
			Path path = Paths.get(uri);
			try {
				Files.deleteIfExists(path);
				logger.info(String.format("File '%s' deleted successfully.", filePath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (URISyntaxException e1) {
			e1.printStackTrace();
		}
		
		
		
	}

	@Override
	public void sendRegistrationEmail(String email, String userName) {	
				
		String mailtxt = "Dear "+userName+"\n\n"+text;
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setTo(email);
		message.setSubject(subject);
		message.setText(mailtxt);
	
		logger.info(String.format("Sending mail to '%s' .",email));
		javaMailSender.send(message);
		logger.info(String.format("Mail successfully send to '%s' .",email));
	}
}
