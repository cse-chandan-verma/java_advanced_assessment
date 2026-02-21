package com.assessment.storageservicesystem;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component("cloudStorage")
@Primary
public class CloudStorageService implements Storage{

	public CloudStorageService() {
		System.out.println("Cloud Storage Servicee bean created");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Cloud Storage Service bean initialized");
	}
	
	@Override
	public void storeFile(String fileName) {
		System.out.println("File stored in the Cloud Storage"+ fileName);
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("Cloud Storage Service bean destroyed");
	}
}
