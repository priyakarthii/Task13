package tests;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;


public class WriteExcel
{
    public static void main(String[] args) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Sheet 1");

        // Column headers
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("Name");
        headerRow.createCell(1).setCellValue("Age");
        headerRow.createCell(2).setCellValue("Email");

        // Data rows
        Object[][] data = {
                {"John Doe", 30, "john@test.com"},
                {"Jane Doe", 28, "jane@test.com"},
                {"Bob Smith", 35, "bob@example.com"},
                {"Swapnil", 37, "swapnil@example.com"}
        };

        int rowNum = 1;
        for (Object[] rowData : data) {
            Row row = sheet.createRow(rowNum++);
            int colNum = 0;
            for (Object field : rowData) {
                Cell cell = row.createCell(colNum++);
                if (field instanceof String) {
                    cell.setCellValue((String) field);
                } else if (field instanceof Integer) {
                    cell.setCellValue((Integer) field);
                }
            }
        }

        try (FileOutputStream fileOut = new FileOutputStream("data.xlsx")) {
            workbook.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel file created successfully.");

    }
}

