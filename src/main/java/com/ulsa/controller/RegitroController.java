package com.ulsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.ulsa.security.UserService;

@Controller
public class RegitroController {

	@Autowired
	private UserService servicio;

    @GetMapping("/login")
	public String loginPage() {

		return "login";
	}
	
	
	@GetMapping("/")
	public String indexPage() {

		return "index";
	}
	 

	 /*
	 @GetMapping("/")
	public String showPageUser(Model model) {
		model.addAttribute("usuarios", servicio.listarUsuarios());
		return "design/index-usuario";
	}
	 */
    
}
