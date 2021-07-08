package com.example.demo.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping( {"/home","/"})
	public String main(Authentication authentication) {
		
		
//        return principal.getName();
		
		System.out.println("---->"+ authentication.getName());
		if(authentication.getName().equalsIgnoreCase("user")) {
			
			return "index";
		}else {
			return "cskh";
		}
		
		
	}

	@GetMapping("/manage-order")
	public String manageOrder() {

		return "manage-order";
	}
	
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	
	@GetMapping("/cskh/dashboard")
	public String cskh() {
		
		return "cskh";
	}
}
