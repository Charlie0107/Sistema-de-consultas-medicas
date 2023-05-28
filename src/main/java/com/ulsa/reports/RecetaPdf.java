package com.ulsa.reports;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import java.awt.Color;
import java.io.IOException;

import com.ulsa.entity.Receta;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class RecetaPdf {

    private List<Receta> recetas;

    public RecetaPdf(List<Receta> recetas) {
		super();
		this.recetas = recetas;
	}

    private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
		PdfPCell celda = new PdfPCell();

		celda.setBackgroundColor(Color.BLUE);
		celda.setPadding(5);

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
		fuente.setColor(Color.WHITE);

		celda.setPhrase(new Phrase("ID", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Diagnóstico", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Duraciónd del tratamiento", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Farmaco", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Unidades", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Indicaciones", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Medicamento", fuente));
		tabla.addCell(celda);
	}

	private void escribirDatosDeLaTabla(PdfPTable tabla) {
		for (Receta recetas : recetas) {
			tabla.addCell(String.valueOf(recetas.getId()));
			tabla.addCell(recetas.getDiagnostico());
            tabla.addCell(recetas.getDuracion_tratamiento());
			tabla.addCell(recetas.getFarmaco());  
			tabla.addCell(String.valueOf(recetas.getUnidades()));          
			tabla.addCell(recetas.getIndicaciones());
            tabla.addCell(recetas.getMedicamento().toString());
		}
	}

	public void exportar(HttpServletResponse response) throws DocumentException, IOException {
		Document documento = new Document(PageSize.A4);
		PdfWriter.getInstance(documento, response.getOutputStream());

		documento.open();

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fuente.setColor(Color.BLUE);
		fuente.setSize(18);

		Paragraph titulo = new Paragraph("Lista de recetas", fuente);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		documento.add(titulo);

		PdfPTable tabla = new PdfPTable(8);
		tabla.setWidthPercentage(100);
		tabla.setSpacingBefore(15);
		tabla.setWidths(new float[] { 1.5f, 5f, 4f, 2f, 2f, 6f, 4f});
		tabla.setWidthPercentage(110);
		
		escribirCabeceraDeLaTabla(tabla);
		escribirDatosDeLaTabla(tabla);

		documento.add(tabla);
		documento.close();
	}
    
}
