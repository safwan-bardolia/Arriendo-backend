package com.Arriendo;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class ArriendoApplication {

	// System.getProperty("user.dir") it will point to root of this project in workplace	
	// & then we are appending sub-directory to it	
	public static String uploadDirectory = System.getProperty("user.dir")+"/uploads";
	
	public static void main(String[] args) {
		
		// create directory if not present
		new File(uploadDirectory).mkdir();
		
		SpringApplication.run(ArriendoApplication.class, args);
	}

}
