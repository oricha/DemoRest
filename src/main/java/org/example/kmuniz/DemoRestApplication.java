package org.example.kmuniz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoRestApplication {
	
	private static final Logger log = LoggerFactory.getLogger(DemoRestApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(DemoRestApplication.class, args);
    }
    
   
}
