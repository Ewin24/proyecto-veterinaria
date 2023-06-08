package pdf;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.PageSize;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import entity.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("listarPdfUsuarios")
public class LIstadoPdfUsuarios extends AbstractPdfView {

    private static final String[] header = { "Id", "Nombre", "Email" };

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        List<Usuario> listadoUsuarios = (List<Usuario>) model.get("usuarios");

        document.setPageSize(PageSize.LETTER.rotate());
        document.open();

        PdfPTable tablaTitulo = new PdfPTable(1);
        PdfPCell celda = null;
        celda = new PdfPCell(new Phrase("Listado Usuarios"));
        celda.setHorizontalAlignment(Element.ALIGN_CENTER);

        tablaTitulo.addCell(celda);
        tablaTitulo.setSpacingAfter(30);

        PdfPTable tablaUsuarios = new PdfPTable(3);

        for (int i = 0; i < header.length; i++) {
            tablaUsuarios.addCell(header[i]);
        }

        listadoUsuarios.forEach(usuario -> {
            tablaUsuarios.addCell(usuario.getId().toString());
            tablaUsuarios.addCell(usuario.getNombre());
            tablaUsuarios.addCell(usuario.getEmail());
        });

        document.add(tablaTitulo);
        document.add(tablaUsuarios);
    }
}
