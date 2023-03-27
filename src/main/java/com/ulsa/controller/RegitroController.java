package com.ulsa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegitroController {

    @GetMapping("/login")
	public String loginPage() {

		return "login";
	}

	@GetMapping("/")
	public String indexPage() {

		return "index";
	}
    
}
