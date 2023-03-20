package com.ulsa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ulsa.entity.Especialidad;
import com.ulsa.repository.EspecialidadRepository;

@Controller
public class EspecialidadController {
	/*
private final EspecialidadRepository especialidadRepository;
	
	@Autowired
	public EspecialidadController(EspecialidadRepository especialidadRepository) {
		this.especialidadRepository = especialidadRepository;		
	}
	

	
	@GetMapping("/especialidades")
	public String indexEspecialidad(Model model) {
		System.out.println("&&&&& index´Especialidad &&&&&&");
		model.addAttribute("especialidades", especialidadRepository.findAll());
		return "design/index-especialidad";
		
	}
	
	@PostMapping("/addespecialidad")
	public String addEspecialidad(@Validated Especialidad especialidad, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "design/create-especialidad";
		}
		especialidadRepository.save(especialidad);
		model.addAttribute("especialidad", especialidadRepository.findAll());
		return "design/index-especialidad";
	}
	
	@GetMapping("/newespecialidad")
	public String showSignUpFormEspecialidad(Especialidad especialidad) {
		System.out.println("&&&&& showSignUpForm &&&&&&");
		return "design/create-especialidad";
	}
	
	@GetMapping("/editEspecialidad/{id}")
	public String showUpdateFormEspecialidad(@PathVariable("id") long id, Model model) {
		Especialidad especialidad =
				especialidadRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid especialidad Id:" + id));
		model.addAttribute("especialidad", especialidad);
		return "design/update-especialidad";
	}
	
	@GetMapping("/deleteEspecialidad/{id}")
	public String deleteEspecialidad(@PathVariable("id") long id, Model model) {
		Especialidad especialidad =
			especialidadRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid paciente Id:" + id));
		especialidadRepository.delete(especialidad);
		model.addAttribute("especialidad", especialidadRepository.findAll());
		return "design/index-especialidad";
	}
	
	@PostMapping("/updateEspecialidad/{id}")
	public String updateEspecialidad(@PathVariable("id") long id, @Validated Especialidad especialidad,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			especialidad.setId(id);
			return "design/update-especialidad";
		}
		especialidadRepository.save(especialidad);
		model.addAttribute("pacientes", especialidadRepository.findAll());
		return "design/index-especialidad";
	}
*/
}
