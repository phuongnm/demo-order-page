package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping
	public String main() {
		return "index";
	}

	@GetMapping("/manage-order")
	public String manageOrder() {

		return "manage-order";
	}
	
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	
}
