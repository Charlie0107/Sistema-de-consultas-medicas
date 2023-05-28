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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ulsa.entity.Medicamento;
import com.ulsa.entity.Receta;
import com.ulsa.repository.MedicamentoRepository;
import com.ulsa.repository.RecetaRepository;
import com.lowagie.text.DocumentException;
import com.ulsa.pagination.PageRender;
import com.ulsa.reports.RecetaExcel;
import com.ulsa.reports.RecetaPdf;

@Controller
public class RecetaController {

    @Autowired
	private RecetaRepository recetaRepository;

    @Autowired
	private MedicamentoRepository medicamentoRepository;
	
	@GetMapping("/recetas")
	public String indexReceta(Model model) {
		List<Receta> recetas = recetaRepository.findAll();
		System.out.println("&&&&& index´Receta &&&&&&");
		model.addAttribute("recetas", recetas);
		return "design/index-receta";		
	}
	
	@PostMapping("/addreceta")
	public String addReceta(@Validated Receta receta,BindingResult bindingResult,RedirectAttributes redirect,Model modelo) {
		if(bindingResult.hasErrors()) {
			modelo.addAttribute("receta", receta);
			return "redirect:/addreceta";
		}
		
		recetaRepository.save(receta);
		redirect.addFlashAttribute("msgExito", "La receta ha sido agregado con exito");
		return "design/index-receta";
		//return "design/index-medicamento";
	}
	
	@GetMapping("/newreceta")
	public String showSignUpFormReceta(Model model) {
        List<Medicamento> medicamentos = medicamentoRepository.findAll();
		model.addAttribute("medicamentos", medicamentos);
		model.addAttribute("receta", new Receta());
		System.out.println("&&&&& showSignUpForm &&&&&&");
		return "design/create-receta";
	}
	
	@GetMapping("/editreceta/{id}")
	public String showUpdateFormReceta(@PathVariable("id") long id, Model model) {
		Receta receta =
				recetaRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid receta Id:" + id));
		model.addAttribute("receta", receta);
		return "design/update-receta";
	}
	
	@GetMapping("/deletereceta/{id}")
	public String deleteReceta(@PathVariable("id") long id, Model model) {
		Receta receta =
				recetaRepository
				.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid receta Id:" + id));
		recetaRepository.delete(receta);
		model.addAttribute("receta", recetaRepository.findAll());
		return "design/index-receta";
	}
	
	@PostMapping("/updatereceta/{id}")
	public String updateReceta(@PathVariable("id") long id, @Validated Receta receta,
			BindingResult result, Model model) {
		if(result.hasErrors()) {
			receta.setId(id);
			return "design/update-receta";
		}
		recetaRepository.save(receta);
		model.addAttribute("recetas", recetaRepository.findAll());
		return "design/index-receta";
	}

	@GetMapping("/exportPDFRecetas")
	public void exportarListadoDeEmpleadosEnPDF(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/pdf");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Recetas_" + fechaActual + ".pdf";
		
		response.setHeader(cabecera, valor);
		
		List<Receta> recetas = recetaRepository.findAll();
		
		RecetaPdf exporter = new RecetaPdf(recetas);
		exporter.exportar(response);
	}

	@GetMapping("/exportExcelRecetas")
	public void exportarListadoDeEmpleadosEnExcel(HttpServletResponse response) throws DocumentException, IOException {
		response.setContentType("application/octet-stream");
		
		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
		String fechaActual = dateFormatter.format(new Date());
		
		String cabecera = "Content-Disposition";
		String valor = "attachment; filename=Recetas_" + fechaActual + ".xlsx";
		
		response.setHeader(cabecera, valor);
		
		List<Receta> recetas = recetaRepository.findAll();
		
		RecetaExcel exporter = new RecetaExcel(recetas);
		exporter.exportar(response);
	}
    
}

