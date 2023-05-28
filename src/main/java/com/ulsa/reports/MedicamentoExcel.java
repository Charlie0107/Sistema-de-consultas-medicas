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

import com.ulsa.entity.Medicamento;

public class MedicamentoExcel {
    private XSSFWorkbook libro;
	private XSSFSheet hoja;

	private List<Medicamento> medicamentos;

	public MedicamentoExcel(List<Medicamento> medicamentos) {
		this.medicamentos = medicamentos;
		libro = new XSSFWorkbook();
		hoja = libro.createSheet("Medicamentos");
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

        celda = fila.createCell(3);
		celda.setCellValue("Fecha de caducidad");
		celda.setCellStyle(estilo);

        celda = fila.createCell(2);
		celda.setCellValue("Cantidad contenida");
		celda.setCellStyle(estilo);

        celda = fila.createCell(4);
		celda.setCellValue("Num. Serie");
		celda.setCellStyle(estilo);

        celda = fila.createCell(5);
		celda.setCellValue("Laboratorio");
		celda.setCellStyle(estilo);
		
	}
	
	private void escribirDatosDeLaTabla() {
		int nueroFilas = 1;
		
		CellStyle estilo = libro.createCellStyle();
		XSSFFont fuente = libro.createFont();
		fuente.setFontHeight(14);
		estilo.setFont(fuente);
		
		for(Medicamento medicamento : medicamentos) {
			Row fila = hoja.createRow(nueroFilas ++);
			
			Cell celda = fila.createCell(0);
			celda.setCellValue(medicamento.getId());
			hoja.autoSizeColumn(0);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(1);
			celda.setCellValue(medicamento.getNombre());
			hoja.autoSizeColumn(1);
			celda.setCellStyle(estilo);
			
			celda = fila.createCell(2);
			celda.setCellValue(medicamento.getCantidad_contenida());
			hoja.autoSizeColumn(2);
			celda.setCellStyle(estilo);

            celda = fila.createCell(3);
			celda.setCellValue(medicamento.getCaducidad().toString());
			hoja.autoSizeColumn(3);
			celda.setCellStyle(estilo);

            celda = fila.createCell(4);
			celda.setCellValue(medicamento.getNum_serie());
			hoja.autoSizeColumn(4);
			celda.setCellStyle(estilo);

            celda = fila.createCell(5);
			celda.setCellValue(medicamento.getLaboratorio());
			hoja.autoSizeColumn(5);
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
