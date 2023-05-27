package com.ulsa.reports;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ulsa.entity.Persona;

public class PersonExcel {

    private XSSFWorkbook libro;
	private XSSFSheet hoja;

	private List<Persona> personas;

	public PersonExcel(List<Persona> personas) {
		this.personas = personas;
		libro = new XSSFWorkbook();
		hoja = libro.createSheet("Personas");
	}

	private void escribirCabeceraDeTabla() {
		Row fila = hoja.createRow(0);
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setBold(true);
		fuente.setFontHeight(16);
		estilo.setFont(fuente);
		
		Cell celda = fila.createCell(0);
		celda.setCellValue("ID");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(1);
		celda.setCellValue("Nombre");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(2);
		celda.setCellValue("Apellido Paterno");
		celda.setCellStyle(estilo);

        celda = fila.createCell(3);
		celda.setCellValue("Apellido Materno");
		celda.setCellStyle(estilo);

        celda = fila.createCell(4);
		celda.setCellValue("Edad");
		celda.setCellStyle(estilo);

        celda = fila.createCell(5);
		celda.setCellValue("Genero");
		celda.setCellStyle(estilo);

        celda = fila.createCell(6);
		celda.setCellValue("Fecha de nacimiento");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(7);
		celda.setCellValue("Email");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(8);
		celda.setCellValue("Direccion");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(9);
		celda.setCellValue("Celular");
		celda.setCellStyle(estilo);
		
	}
	
	private void escribirDatosDeLaTabla() {
		int nueroFilas = 1;
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setFontHeight(14);
		estilo.setFont(fuente);
		
		for(Persona persona : personas) {
			Row fila = hoja.createRow(nueroFilas ++);
			
			Cell celda = fila.createCell(0);
			celda.setCellValue(persona.getId());
			hoja.autoSizeColumn(0);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(1);
			celda.setCellValue(persona.getNombre());
			hoja.autoSizeColumn(1);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(2);
			celda.setCellValue(persona.getApeMat());
			hoja.autoSizeColumn(2);
			celda.setCellStyle(estilo);

            celda = fila.createCell(3);
			celda.setCellValue(persona.getApePat());
			hoja.autoSizeColumn(3);
			celda.setCellStyle(estilo);

            celda = fila.createCell(4);
			celda.setCellValue(persona.getEdad());
			hoja.autoSizeColumn(4);
			celda.setCellStyle(estilo);

            celda = fila.createCell(5);
			celda.setCellValue(persona.getGenero());
			hoja.autoSizeColumn(5);
			celda.setCellStyle(estilo);

            celda = fila.createCell(6);
			celda.setCellValue(persona.getFecha_nacimiento().toString());
			hoja.autoSizeColumn(6);
			celda.setCellStyle(estilo);

            celda = fila.createCell(7);
			celda.setCellValue(persona.getEmail());
			hoja.autoSizeColumn(7);
			celda.setCellStyle(estilo);

            celda = fila.createCell(8);
			celda.setCellValue(persona.getDireccion());
			hoja.autoSizeColumn(8);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(9);
			celda.setCellValue(persona.getCelular());
			hoja.autoSizeColumn(9);
			celda.setCellStyle(estilo);
		}
	}
	
	public void exportar(HttpServletResponse response) throws IOException {
		escribirCabeceraDeTabla();
		escribirDatosDeLaTabla();
		
		ServletOutputStream outPutStream = response.getOutputStream();
		libro.write(outPutStream);
		
		libro.close();
		outPutStream.close();
	}
    
}
