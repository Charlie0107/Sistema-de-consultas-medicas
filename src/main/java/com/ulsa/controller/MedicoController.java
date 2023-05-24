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

import com.ulsa.entity.Medico;
import com.ulsa.entity.Persona;
import com.ulsa.repository.EspecialidadRepository;
import com.ulsa.repository.MedicoRepository;
import com.ulsa.repository.PersonaRepository;

@Controller
public class MedicoController {
	
	//private PacienteService pacienteService;
	@Autowired
	private MedicoRepository medicoRepository;

	@Autowired
	private EspecialidadRepository especialidadRepository;

	@Autowired
	private PersonaRepository personaRepository;
	
	/*
	@Autowired
	public MedicoController(MedicoRepository medicoRepository) {
		this.medicoRepository = medicoRepository;		
	}
	 */
	
	@GetMapping("/medicos")
	public String indexMedicos(Model model) {
		List<Medico> medicos = medicoRepository.findAll();
		System.out.println("&&&&& index´Medicos &&&&&&");
		model.addAttribute("medicos", medicos);
		//model.addAttribute("medicos", medicoRepository.findAll());
		return "design/index-medico";		
	}
	
	@PostMapping("/addmedico")
	public String addMedico(Medico medico) {
		medicoRepository.save(medico);
		return "redirect:/medicos";
		//return "design/index-medico";
	}
	
	@GetMapping("/newmedico")
	public String showSignUpFormMedico(Model model) {
		List<Persona> personas = personaRepository.findAll();
		model.addAttribute("personas", personas);
		model.addAttribute("medico", new Medico());
		System.out.println("&&&&& showSignUpForm &&&&&&");
		return "design/create-medico";
	}
	
	@GetMapping("/editMedico/{id}")
	public String showUpdateFormMedico(@PathVariable("id") long id, Model model) {
		Medico medico =
				medicoRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid medico Id:" + id));
		model.addAttribute("medico", medico);
		return "design/update-medico";
	}
	
	@GetMapping("/deleteMedico/{id}")
	public String deleteMedico(@PathVariable("id") long id, Model model) {
		Medico medico =
				medicoRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid medico Id:" + id));
		medicoRepository.delete(medico);
		model.addAttribute("medico", medicoRepository.findAll());
		return "design/index-medico";
	}
	
	@PostMapping("/updateMedico/{id}")
	public String updateMedico(@PathVariable("id") long id, @Validated Medico medico,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			medico.setId(id);
			return "design/update-medico";
		}
		medicoRepository.save(medico);
		model.addAttribute("medicos", medicoRepository.findAll());
		return "design/index-medico";
	}

}

