package com.ulsa.reports;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import java.awt.Color;
import java.io.IOException;

import com.ulsa.entity.Persona;
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

public class PersonPdf {

    private List<Persona> personas;

    public PersonPdf(List<Persona> personas) {
		super();
		this.personas = personas;
	}

    private void escribirCabeceraDeLaTabla(PdfPTable tabla) {
		PdfPCell celda = new PdfPCell();

		celda.setBackgroundColor(Color.BLUE);
		celda.setPadding(5);

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA);
		fuente.setColor(Color.WHITE);

		celda.setPhrase(new Phrase("ID", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Nombre", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Apellido Paterno", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Apellido Materno", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Edad", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Genero", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Fecha de nacimiento", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Email", fuente));
		tabla.addCell(celda);

		celda.setPhrase(new Phrase("Direccion", fuente));
		tabla.addCell(celda);		

		celda.setPhrase(new Phrase("Celular", fuente));
		tabla.addCell(celda);
	}

	private void escribirDatosDeLaTabla(PdfPTable tabla) {
		for (Persona personas : personas) {
			tabla.addCell(String.valueOf(personas.getId()));
			tabla.addCell(personas.getNombre());
			tabla.addCell(personas.getApeMat());
            tabla.addCell(personas.getApePat());
            tabla.addCell(String.valueOf(personas.getEdad()));
			tabla.addCell(personas.getGenero());  
			tabla.addCell(personas.getFecha_nacimiento().toString());          
			tabla.addCell(personas.getEmail());
            tabla.addCell(personas.getDireccion());
            tabla.addCell(personas.getCelular());
		}
	}

	public void exportar(HttpServletResponse response) throws DocumentException, IOException {
		Document documento = new Document(PageSize.A4);
		PdfWriter.getInstance(documento, response.getOutputStream());

		documento.open();

		Font fuente = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
		fuente.setColor(Color.BLUE);
		fuente.setSize(18);

		Paragraph titulo = new Paragraph("Lista de pacientes", fuente);
		titulo.setAlignment(Paragraph.ALIGN_CENTER);
		documento.add(titulo);

		PdfPTable tabla = new PdfPTable(10);
		tabla.setWidthPercentage(100);
		tabla.setSpacingBefore(15);
		tabla.setWidths(new float[] { 1.5f, 3f, 4f, 4f, 2f, 2.9f, 4f, 4f, 4f, 4f });
		tabla.setWidthPercentage(110);
		
		escribirCabeceraDeLaTabla(tabla);
		escribirDatosDeLaTabla(tabla);

		documento.add(tabla);
		documento.close();
	}
}
