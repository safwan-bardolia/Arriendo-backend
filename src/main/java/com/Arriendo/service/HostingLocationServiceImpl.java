package com.Arriendo.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.Arriendo.dao.HostingLocationRepository;
import com.Arriendo.entity.HostingLocation;

@Service
public class HostingLocationServiceImpl implements HostingLocationService {

	@Autowired
	private HostingLocationRepository repository;
	
	// for sending mail	
	@Autowired
	private JavaMailSender javaMailSender;

	@Value("${msg.registration.location.subject}")
	private String subject;
	
	@Value("${msg.registration.location.text}")
	private String text;
	
	private static final Logger logger = LoggerFactory.getLogger(HostingLocationServiceImpl.class);
	
	@Override
	public void saveOrUpdate(HostingLocation hostingLocation) {
		repository.save(hostingLocation);
	}

	@Override
	public List<HostingLocation> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<HostingLocation> findById(String uid) {
		return repository.findById(uid);
	}

	@Override
	public void delete(String uid) {
		repository.deleteById(uid);
	}

	@Override
	public void sendLocationConfirmationEmail(String email, String userName) {
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
