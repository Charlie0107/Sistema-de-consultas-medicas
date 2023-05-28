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

import com.ulsa.entity.Consulta;

public class ConsultaExcel {
    private XSSFWorkbook libro;
	private XSSFSheet hoja;

	private List<Consulta> consultas;

	public ConsultaExcel(List<Consulta> consultas) {
		this.consultas = consultas;
		libro = new XSSFWorkbook();
		hoja = libro.createSheet("Consultas");
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
		celda.setCellValue("Servicio");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(2);
		celda.setCellValue("Fecha");
		celda.setCellStyle(estilo);

        celda = fila.createCell(3);
		celda.setCellValue("Pago");
		celda.setCellStyle(estilo);

        celda = fila.createCell(4);
		celda.setCellValue("Médico");
		celda.setCellStyle(estilo);
		
	}
	
	private void escribirDatosDeLaTabla() {
		int nueroFilas = 1;
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setFontHeight(14);
		estilo.setFont(fuente);
		
		for(Consulta consulta : consultas) {
			Row fila = hoja.createRow(nueroFilas ++);
			
			Cell celda = fila.createCell(0);
			celda.setCellValue(consulta.getId());
			hoja.autoSizeColumn(0);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(1);
			celda.setCellValue(consulta.getServicio());
			hoja.autoSizeColumn(1);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(2);
			celda.setCellValue(consulta.getFecha_atencion().toString());
			hoja.autoSizeColumn(2);
			celda.setCellStyle(estilo);

            celda = fila.createCell(3);
			celda.setCellValue(consulta.getPago());
			hoja.autoSizeColumn(3);
			celda.setCellStyle(estilo);

            celda = fila.createCell(4);
			celda.setCellValue(consulta.getMedico().toString());
			hoja.autoSizeColumn(4);
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
