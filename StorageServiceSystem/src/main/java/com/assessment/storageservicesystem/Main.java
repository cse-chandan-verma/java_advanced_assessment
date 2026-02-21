package com.assessment.storageservicesystem;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		System.out.println("\nContainer Started\n");
		
		Storage storage = context.getBean(Storage.class);
		storage.storeFile("report.pdf\n");
		
		System.out.println("Getting localStorage bean first time");
		
		Storage local1 = context.getBean("localStorage", Storage.class);
		local1.storeFile("localFile1.txt\n");
		
		System.out.println("Getting localStorage bean second time");
		
		Storage local2 = context.getBean("localStorage", Storage.class);
		local2.storeFile("localFile2.txt\n");
		
		System.out.println("Closing Container");
		
		context.close();
		
	}
}
