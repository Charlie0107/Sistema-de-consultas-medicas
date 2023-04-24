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

import com.ulsa.entity.Medicamento;
import com.ulsa.repository.MedicamentoRepository;

@Controller
public class MedicamentoController {

    @Autowired
	private MedicamentoRepository medicamentoRepository;
	
	@GetMapping("/medicamentos")
	public String indexMedicamento(Model model) {
		List<Medicamento> medicamentos = medicamentoRepository.findAll();
		System.out.println("&&&&& index´Medicamento &&&&&&");
		model.addAttribute("medicamentos", medicamentos);
		return "design/index-medicamento";		
	}
	
	@PostMapping("/addmedicamento")
	public String addMedicamento(@Validated Medicamento medicamento,BindingResult bindingResult,RedirectAttributes redirect,Model modelo) {
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("medicamento", medicamento);
			return "redirect:/addmedicamento";
		}
		
		medicamentoRepository.save(medicamento);
		redirect.addFlashAttribute("msgExito", "El medicamento ha sido agregado con exito");
		return "design/index-medicamento";
		//return "design/index-medicamento";
	}
	
	@GetMapping("/newmedicamento")
	public String showSignUpFormMedicamento(Model model) {
		model.addAttribute("medicamento", new Medicamento());
		System.out.println("&&&&& showSignUpForm &&&&&&");
		return "design/create-medicamento";
	}
	
	@GetMapping("/editmedicamento/{id}")
	public String showUpdateFormMedicamento(@PathVariable("id") long id, Model model) {
		Medicamento medicamento =
				medicamentoRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid medicamento Id:" + id));
		model.addAttribute("medicamento", medicamento);
		return "design/update-medicamento";
	}
	
	@GetMapping("/deletemedicamento/{id}")
	public String deleteMedicamento(@PathVariable("id") long id, Model model) {
		Medicamento medicamento =
				medicamentoRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid medicamento Id:" + id));
		medicamentoRepository.delete(medicamento);
		model.addAttribute("medicamento", medicamentoRepository.findAll());
		return "design/index-medico";
	}
	
	@PostMapping("/updatemedicamento/{id}")
	public String updateMedicamento(@PathVariable("id") long id, @Validated Medicamento medicamento,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			medicamento.setId(id);
			return "design/update-medicamento";
		}
		medicamentoRepository.save(medicamento);
		model.addAttribute("medicamentos", medicamentoRepository.findAll());
		return "design/index-medicamento";
	}
    
}
