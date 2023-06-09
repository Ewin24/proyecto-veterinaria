package com.veterinaria.app.pdf;

import java.util.List;
import java.util.Map;

import com.veterinaria.app.entity.Paciente;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("listarPdf")
public class ListadoPDF extends AbstractPdfView {

    private static final String[] header = {"Id", "Nombre", "Especie", "Raza", "Edad"};

    protected void buildPdfDocument1(Map<String, Object> model, Document document, PdfWriter writer,
                                     HttpServletRequest request, HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        List<Paciente> listadoPacientes = (List<Paciente>) model.get("pacientes");

        document.setPageSize(PageSize.LETTER.rotate());
        document.open();

        PdfPTable tablaTitulo = new PdfPTable(1);
        PdfPCell celda = null;
        celda = new PdfPCell(new Phrase("Listado Pacientes"));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);

        tablaTitulo.addCell(celda);
        tablaTitulo.setSpacingAfter(30);

        PdfPTable tablaPacientes = new PdfPTable(5);

        for (int i = 0; i < header.length; i++) {
            tablaPacientes.addCell(header[i]);
        }

        listadoPacientes.forEach(paciente -> {

            tablaPacientes.addCell(paciente.getId().toString());
            tablaPacientes.addCell(paciente.getNombre());
            tablaPacientes.addCell(paciente.getEspecie());
            tablaPacientes.addCell(paciente.getRaza());
            tablaPacientes.addCell(paciente.getEdad().toString());

        });

        document.add(tablaTitulo);
        document.add(tablaPacientes);

    }

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
                                    HttpServletRequest request, HttpServletResponse response)
            throws Exception {

    }
}
