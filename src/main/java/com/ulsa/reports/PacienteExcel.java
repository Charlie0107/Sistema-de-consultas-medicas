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

import com.ulsa.entity.Paciente;

public class PacienteExcel {
    private XSSFWorkbook libro;
	private XSSFSheet hoja;

	private List<Paciente> pacientes;

	public PacienteExcel(List<Paciente> pacientes) {
		this.pacientes = pacientes;
		libro = new XSSFWorkbook();
		hoja = libro.createSheet("Pacientes");
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
		celda.setCellValue("Paciente");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(2);
		celda.setCellValue("Peso");
		celda.setCellStyle(estilo);

        celda = fila.createCell(3);
		celda.setCellValue("Altura");
		celda.setCellStyle(estilo);

        celda = fila.createCell(4);
		celda.setCellValue("Temperatura");
		celda.setCellStyle(estilo);

        celda = fila.createCell(5);
		celda.setCellValue("Presión");
		celda.setCellStyle(estilo);

        celda = fila.createCell(6);
		celda.setCellValue("Alergias");
		celda.setCellStyle(estilo);
		
	}
	
	private void escribirDatosDeLaTabla() {
		int nueroFilas = 1;
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setFontHeight(14);
		estilo.setFont(fuente);
		
		for(Paciente paciente : pacientes) {
			Row fila = hoja.createRow(nueroFilas ++);
			
			Cell celda = fila.createCell(0);
			celda.setCellValue(paciente.getId());
			hoja.autoSizeColumn(0);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(1);
			celda.setCellValue(/*paciente.getPaciente()*/" ");
			hoja.autoSizeColumn(1);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(2);
			celda.setCellValue(paciente.getPeso());
			hoja.autoSizeColumn(2);
			celda.setCellStyle(estilo);

            celda = fila.createCell(3);
			celda.setCellValue(paciente.getAltura());
			hoja.autoSizeColumn(3);
			celda.setCellStyle(estilo);

            celda = fila.createCell(4);
			celda.setCellValue(paciente.getTemperatura());
			hoja.autoSizeColumn(4);
			celda.setCellStyle(estilo);

            celda = fila.createCell(5);
			celda.setCellValue(paciente.getPresion());
			hoja.autoSizeColumn(5);
			celda.setCellStyle(estilo);

            celda = fila.createCell(6);
			celda.setCellValue(paciente.getAlergias());
			hoja.autoSizeColumn(6);
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
