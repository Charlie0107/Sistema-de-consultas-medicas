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

import com.ulsa.entity.Receta;

public class RecetaExcel {

    private XSSFWorkbook libro;
	private XSSFSheet hoja;

	private List<Receta> recetas;

	public RecetaExcel(List<Receta> recetas) {
		this.recetas = recetas;
		libro = new XSSFWorkbook();
		hoja = libro.createSheet("Recetas");
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
		celda.setCellValue("Diagnóstico");
		celda.setCellStyle(estilo);

        celda = fila.createCell(3);
		celda.setCellValue("Duración del tratamiento");
		celda.setCellStyle(estilo);

        celda = fila.createCell(4);
		celda.setCellValue("Farmaco");
		celda.setCellStyle(estilo);

        celda = fila.createCell(5);
		celda.setCellValue("Unidades");
		celda.setCellStyle(estilo);

        celda = fila.createCell(6);
		celda.setCellValue("Indicaciones");
		celda.setCellStyle(estilo);
		
		celda = fila.createCell(7);
		celda.setCellValue("Medicamento");
		celda.setCellStyle(estilo);
		
	}
	
	private void escribirDatosDeLaTabla() {
		int nueroFilas = 1;
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setFontHeight(14);
		estilo.setFont(fuente);
		
		for(Receta receta : recetas) {
			Row fila = hoja.createRow(nueroFilas ++);
			
			Cell celda = fila.createCell(0);
			celda.setCellValue(receta.getId());
			hoja.autoSizeColumn(0);
			celda.setCellStyle(estilo);
			/* 
			celda = fila.createCell(1);
			celda.setCellValue(receta.getPaciente().toString());
			hoja.autoSizeColumn(1);
			celda.setCellStyle(estilo);
			*/
			celda = fila.createCell(2);
			celda.setCellValue(receta.getDiagnostico());
			hoja.autoSizeColumn(2);
			celda.setCellStyle(estilo);

            celda = fila.createCell(3);
			celda.setCellValue(receta.getDuracion_tratamiento());
			hoja.autoSizeColumn(3);
			celda.setCellStyle(estilo);

            celda = fila.createCell(4);
			celda.setCellValue(receta.getFarmaco());
			hoja.autoSizeColumn(4);
			celda.setCellStyle(estilo);

            celda = fila.createCell(5);
			celda.setCellValue(receta.getUnidades());
			hoja.autoSizeColumn(5);
			celda.setCellStyle(estilo);

            celda = fila.createCell(6);
			celda.setCellValue(receta.getIndicaciones());
			hoja.autoSizeColumn(6);
			celda.setCellStyle(estilo);

            celda = fila.createCell(7);
			celda.setCellValue(receta.getMedicamento().toString());
			hoja.autoSizeColumn(7);
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
