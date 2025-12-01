package Utilities;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExcelUtils {

    // Cache: sheetName → (testDataKey → (columnName → value))
    private static Map<String, Map<String, Map<String, String>>> masterData = new HashMap<>();

    public static String getData(String sheetName, String testDataKey, String columnName) {

        // if sheet not loaded yet → load
        if (!masterData.containsKey(sheetName)) {
            loadSheet(sheetName);
        }

        Map<String, Map<String, String>> sheetMap = masterData.get(sheetName);
        if (sheetMap == null || !sheetMap.containsKey(testDataKey))
            return null;

        return sheetMap.get(testDataKey).get(columnName);
    }


    private static void loadSheet(String sheetName) {
        try (FileInputStream fis = new FileInputStream(FileFolderUtils.excelTestDataPath);
             XSSFWorkbook workbook = new XSSFWorkbook(fis)) {

            XSSFSheet sheet = workbook.getSheet(sheetName);
            if (sheet == null) {
                System.err.println("Sheet not found: " + sheetName);
                return;
            }

            int lastRow = sheet.getLastRowNum();
            int totalCols = sheet.getRow(0).getLastCellNum();

            // read header columns
            List<String> headers = new ArrayList<>();
            for (int c = 0; c < totalCols; c++) {
                headers.add(sheet.getRow(0).getCell(c).getStringCellValue());
            }

            // sheet wise container
            Map<String, Map<String, String>> sheetData = new HashMap<>();

            for (int r = 1; r <= lastRow; r++) {

                String refKey = getCellValue(sheet.getRow(r).getCell(0));

                Map<String, String> rowData = new HashMap<>();

                for (int c = 1; c < totalCols; c++) {
                    String colName = headers.get(c);
                    String value = getCellValue(sheet.getRow(r).getCell(c));
                    rowData.put(colName, value);
                }

                sheetData.put(refKey, rowData);
            }

            masterData.put(sheetName, sheetData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static String getCellValue(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:  return cell.getStringCellValue().trim();
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue()).replaceAll("\\.0$", "");
            case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
            default: return "";
        }
    }
}
