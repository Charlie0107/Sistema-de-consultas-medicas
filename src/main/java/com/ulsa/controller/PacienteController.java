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

import com.ulsa.entity.Paciente;
import com.ulsa.repository.PacienteRepository;



@Controller
public class PacienteController {
	
	//private PacienteService pacienteService;
	@Autowired
	private PacienteRepository pacienteRepository;
	
	@GetMapping("/pacientes")
	public String indexPacientes(Model model) {
		List<Paciente> pacientes = pacienteRepository.findAll();
		System.out.println("&&&&& index´Pacientes &&&&&&");
		model.addAttribute("pacientes", pacientes);
		return "design/index-paciente";
		
	}
	
	@PostMapping("/addpaciente")
	public String addPaciente(Paciente paciente) {
		pacienteRepository.save(paciente);
		return "redirect:/pacientes";
	}
	
	@GetMapping("/new")
	public String showSignUpForm(Model model) {
		model.addAttribute("pacientes", new Paciente());
		System.out.println("&&&&& showSignUpForm &&&&&&");
		return "design/create-paciente";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Paciente paciente =
				pacienteRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid paciente Id:" + id));
		model.addAttribute("paciente", paciente);
		return "design/update-paciente";
	}
	
	@GetMapping("/delete/{id}")
	public String deletePaciente(@PathVariable("id") long id, Model model) {
		Paciente paciente =
			pacienteRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid paciente Id:" + id));
		pacienteRepository.delete(paciente);
		model.addAttribute("paciente", pacienteRepository.findAll());
		return "design/index-paciente";
	}
	
	@PostMapping("/update/{id}")
	public String updatePaciente(@PathVariable("id") long id, @Validated Paciente paciente,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			paciente.setId(id);
			return "design/update-paciente";
		}
		pacienteRepository.save(paciente);
		model.addAttribute("pacientes", pacienteRepository.findAll());
		return "design/index-paciente";
	}
	
}
