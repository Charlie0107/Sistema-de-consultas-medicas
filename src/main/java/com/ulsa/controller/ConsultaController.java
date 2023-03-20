package com.ulsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ulsa.entity.Consulta;
import com.ulsa.repository.ConsultaRepository;

@Controller
public class ConsultaController {
	/*
private final ConsultaRepository consultaRepository;
	
	@Autowired
	public ConsultaController(ConsultaRepository consultaRepository) {
		this.consultaRepository = consultaRepository;		
	}

	
	
	@GetMapping("/consultas")
	public String indexConsultas(Model model) {
		System.out.println("&&&&& index´Consultas &&&&&&");
		model.addAttribute("consultas", consultaRepository.findAll());
		return "design/index-consulta";
		
	}
	
	@PostMapping("/addconsulta")
	public String addConsulta(@Validated Consulta consulta, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "design/create-consulta";
		}
		consultaRepository.save(consulta);
		model.addAttribute("consultas", consultaRepository.findAll());
		return "design/index-consulta";
	}
	
	@GetMapping("/newconsulta")
	public String showSignUpFormConsulta(Consulta consulta) {
		System.out.println("&&&&& showSignUpForm &&&&&&");
		return "design/create-consulta";
	}
	
	@GetMapping("/editConsulta/{id}")
	public String showUpdateFormConsulta(@PathVariable("id") long id, Model model) {
		Consulta consulta =
				consultaRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid consulta Id:" + id));
		model.addAttribute("paciente", consulta);
		return "design/update-consulta";
	}
	
	@GetMapping("/deleteConsulta/{id}")
	public String deleteConsulta(@PathVariable("id") long id, Model model) {
		Consulta consulta =
				consultaRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid consulta Id:" + id));
		consultaRepository.delete(consulta);
		model.addAttribute("consulta", consultaRepository.findAll());
		return "design/index-consulta";
	}
	
	@PostMapping("/updateConsulta/{id}")
	public String updateConsulta(@PathVariable("id") long id, @Validated Consulta consulta,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			consulta.setId(id);
			return "design/update-consulta";
		}
		consultaRepository.save(consulta);
		model.addAttribute("consultas", consultaRepository.findAll());
		return "design/index-consulta";
	}
	*/
}
