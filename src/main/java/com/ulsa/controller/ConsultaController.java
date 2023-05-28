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

import com.ulsa.entity.Consulta;
import com.ulsa.entity.Medico;
import com.ulsa.repository.ConsultaRepository;
import com.ulsa.repository.MedicoRepository;
import com.lowagie.text.DocumentException;
import com.ulsa.pagination.PageRender;
import com.ulsa.reports.ConsultaExcel;
import com.ulsa.reports.ConsultaPdf;

@Controller
public class ConsultaController {

@Autowired
private ConsultaRepository consultaRepository;
@Autowired
private MedicoRepository medicoRepository;
	
	/*
	@Autowired
	public ConsultaController(ConsultaRepository consultaRepository) {
		this.consultaRepository = consultaRepository;		
	}
 	*/
	
	
	@GetMapping("/consultas")
	public String indexConsultas(Model model) {
		List<Consulta> consultas = consultaRepository.findAll();
		System.out.println("&&&&& index´Consultas &&&&&&");
		model.addAttribute("consultas", consultas);
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
	public String showSignUpFormConsulta(Model model) {
		List<Medico> medicos = medicoRepository.findAll();
		model.addAttribute("consulta", new Consulta());
		model.addAttribute("medicos", medicos);
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

	@GetMapping("/exportPDFConsultas")
	public void exportarListadoDeEmpleadosEnPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Consultas_" + fechaActual + ".pdf";
		
		response.setHeader(cabecera, valor);
		
		List<Consulta> consultas = consultaRepository.findAll();
		
		ConsultaPdf exporter = new ConsultaPdf(consultas);
		exporter.exportar(response);
	}

	@GetMapping("/exportExcelConsultas")
	public void exportarListadoDeEmpleadosEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Consultas_" + fechaActual + ".xlsx";
		
		response.setHeader(cabecera, valor);
		
		List<Consulta> consultas = consultaRepository.findAll();
		
		ConsultaExcel exporter = new ConsultaExcel(consultas);
		exporter.exportar(response);
	}
	
}
