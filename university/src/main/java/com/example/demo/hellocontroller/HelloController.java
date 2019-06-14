package com.example.demo.hellocontroller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloController {

	@RequestMapping("/hello")
	
	//If 2nd param is not specified in RequestMapping, the default is get
	public String greet(){
		return "Koushik's tutorial's are really good.";
	}
	
	
}
