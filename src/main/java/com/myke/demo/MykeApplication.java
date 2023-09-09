package com.myke.demo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myke.demo.repository.MykeRepository; 

@SpringBootApplication
@RestController
public class MykeApplication {

	@Autowired
	MykeRepository mykeRepository; 

	public static void main(String[] args) {
		SpringApplication.run(MykeApplication.class, args);
	}

	@GetMapping()
	public String hello(){
		return "Hello World";
	}


}
