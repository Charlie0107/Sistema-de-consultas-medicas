package com.ulsa.controller;

import java.util.List;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.io.IOException;

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
import com.lowagie.text.DocumentException;
import com.ulsa.pagination.PageRender;
import com.ulsa.reports.PacienteExcel;
import com.ulsa.reports.PacientePdf;



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

	@GetMapping("/exportPDFPacientes")
	public void exportarListadoDeEmpleadosEnPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Pacientes_" + fechaActual + ".pdf";
		
		response.setHeader(cabecera, valor);
		
		List<Paciente> pacientes = pacienteRepository.findAll();
		
		PacientePdf exporter = new PacientePdf(pacientes);
		exporter.exportar(response);
	}

	@GetMapping("/exportExcelPacientes")
	public void exportarListadoDeEmpleadosEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Pacientes_" + fechaActual + ".xlsx";
		
		response.setHeader(cabecera, valor);
		
		List<Paciente> pacientes = pacienteRepository.findAll();
		
		PacienteExcel exporter = new PacienteExcel(pacientes);
		exporter.exportar(response);
	}
	
}
