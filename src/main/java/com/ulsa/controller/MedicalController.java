package com.ulsa.controller;

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
public class MedicalController {
	
	//private PacienteService pacienteService;
	private final PacienteRepository pacienteRepository;
	
	@Autowired
	public MedicalController(PacienteRepository pacienteRepository) {
		this.pacienteRepository = pacienteRepository;		
	}
	
	@GetMapping("/pacientes")
	public String indexPacientes(Model model) {
		System.out.println("&&&&& index´Pacientes &&&&&&");
		model.addAttribute("pacientes", pacienteRepository.findAll());
		return "design/index-paciente";
		
	}
	
	@PostMapping("/addpaciente")
	public String addPaciente(@Validated Paciente paciente, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "design/create-paciente";
		}
		pacienteRepository.save(paciente);
		model.addAttribute("pacientes", pacienteRepository.findAll());
		return "design/index-paciente";
	}
	
	@GetMapping("/new")
	public String showSignUpForm(Paciente paciente) {
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
