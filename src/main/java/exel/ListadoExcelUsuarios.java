package exel;


import java.awt.Font;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import entity.Usuario;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component("listarUsuariosExcel")
public class ListadoExcelUsuarios extends AbstractXlsxView {

    private static final String[] header = { "Id", "Nombre", "Email" };

    @Override
    protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
            HttpServletResponse response) throws Exception {

        @SuppressWarnings("unchecked")
        List<Usuario> listadoUsuarios = (List<Usuario>) model.get("usuarios");

        Sheet sheet = workbook.createSheet("ListadoUsuarios");
        sheet.setFitToPage(true);

        // EstiloNegrillaCentrado
        Font font = (Font) workbook.createFont();
        ((org.apache.poi.ss.usermodel.Font) font).setBold(true);
        CellStyle style = workbook.createCellStyle();
        style.setFont((org.apache.poi.ss.usermodel.Font) font);
        style.setAlignment(HorizontalAlignment.CENTER);

        Row rowHeader = sheet.createRow(0);

        for (int i = 0; i < header.length; i++) {
            Cell cell = rowHeader.createCell(i);
            cell.setCellValue(header[i]);
            cell.setCellStyle(style);
        }

        int rowCount = 1;

        for (Usuario usuario : listadoUsuarios) {
            Row row = sheet.createRow(rowCount++);
            row.createCell(0).setCellValue(usuario.getId());
            row.createCell(1).setCellValue(usuario.getNombre());
            row.createCell(2).setCellValue(usuario.getEmail());
        }

        sheet.setColumnWidth(0, 3000);

        for (int i = 1; i <= 2; i++) {
            sheet.autoSizeColumn(i);
        }

        response.setHeader("Content-Disposition", "attachment; filename=listadoUsuarios.xlsx");
    }
}
