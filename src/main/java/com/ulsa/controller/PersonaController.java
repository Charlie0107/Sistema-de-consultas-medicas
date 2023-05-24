package com.ulsa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ulsa.entity.Persona;
import com.ulsa.repository.PersonaRepository;



@Controller
public class PersonaController {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@GetMapping("/personas")
	public String indexPersonas(Model model) {
		List<Persona> personas = personaRepository.findAll();
		System.out.println("&&&&& index´Medicamento &&&&&&");
		model.addAttribute("personas", personas);
		return "design/index-persona";		
	}
	
	@PostMapping("/addpersona")
	public String addPersona(@Validated Persona persona,BindingResult bindingResult,RedirectAttributes redirect,Model modelo) {
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("persona", persona);
			return "redirect:/addpersona";
		}
		
		personaRepository.save(persona);
		redirect.addFlashAttribute("msgExito", "La información ha sido agregado con exito");
		return "redirect:/personas";
		//return "design/index-persona";
		//return "design/index-medicamento";
	}
	
	@GetMapping("/newpersona")
	public String showSignUpFormPersona(Model model) {
		model.addAttribute("persona", new Persona());
		System.out.println("&&&&& showSignUpForm &&&&&&");
		return "design/create-persona";
	}
	
	@GetMapping("/editpersona/{id}")
	public String showUpdateFormPersona(@PathVariable("id") long id, Model model) {
		Persona persona =
				personaRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid persona Id:" + id));
		model.addAttribute("persona", persona);
		return "design/update-persona";
	}
	
	@GetMapping("/deletepersona/{id}")
	public String deletePersona(@PathVariable("id") long id, Model model) {
		Persona persona =
				personaRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid persona Id:" + id));
		personaRepository.delete(persona);
		model.addAttribute("persona", personaRepository.findAll());
		return "design/index-persona";
	}
	
	@PostMapping("/updatepersona/{id}")
	public String updatePersona(@PathVariable("id") long id, @Validated Persona persona,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			persona.setId(id);
			return "design/update-persona";
		}
		personaRepository.save(persona);
		model.addAttribute("personas", personaRepository.findAll());
		return "design/index-persona";
	}
	
}
