package com.llanquihuetour.tours.data;
import com.llanquihuetour.tours.model.Tour;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.*;
import java.io.IOException;


public class GestorDatos {

    private final List<Tour> tours;

    public GestorDatos() {
        this.tours = new ArrayList<>();
    }

    public void cargarDesdeExcel(String resourcePath) throws IOException {
        try (InputStream inputStream = GestorDatos.class.getClassLoader().getResourceAsStream(resourcePath)) {
            if (inputStream == null) {
                System.out.println("No se encontro el archivo en resources: " + resourcePath);
                return;
            }
            try (Workbook workbook = new XSSFWorkbook(inputStream)) {
                Sheet hoja = workbook.getSheetAt(0);
                System.out.println("===Lectura dinámica desde resources (" + resourcePath + ")===");
                boolean primeraFila = true;

                for (Row row : hoja) {
                    if (primeraFila) {
                        primeraFila = false;
                        continue;
                    }
                    if (isEmptyRow(row)) {
                        continue;
                    }

                    tours.add(new Tour(
                            getStringValue(row.getCell(0)), // Nombre
                            getStringValue(row.getCell(1)), // Comuna
                            getNumericValue(row.getCell(2))  // Precio (Celda índice 2)
                    ));
                }
            }
        } catch (IOException ex) {
            System.out.println("Error al leer excel de tours: " + ex.getMessage());
            throw ex;
        }
    }

    public List<Tour> getToursCargados() {
        return new ArrayList<>(tours);
    }

    private boolean isEmptyRow(Row row) {

        for (int i = 0; i < 3; i++) {
            Cell cell = row.getCell(i);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

    private String getStringValue(Cell cell) {
        return cell == null ? "" : cell.toString().trim();
    }

    private double getNumericValue(Cell cell) {
        if (cell == null) {
            return 0;
        }
        return cell.getCellType() == CellType.NUMERIC ? cell.getNumericCellValue() : Double.parseDouble(cell.toString().trim());
    }
}