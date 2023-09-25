package com.demoblaze.common.helpers.files;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelReader {
    static FileInputStream fis = null;

    public FileInputStream getFileInputStream() {
        String filepath = System.getProperty("user.dir") + "/src/test/java/data/TestData.xlsx";
        File srcFile = new File(filepath);

        try {
            fis = new FileInputStream(srcFile);
        } catch (FileNotFoundException e) {
            System.out.println("Test Data file not found. Terminating the process !! Check file path of TestData:" + e.getMessage());
            System.exit(0);
        }
        return fis;
    }

    // Method to get test data from Excel sheet by giving the SheetName and TestCase name while each row is a data for a different TestCase
    public Object[][] getTestData(String sheetName, String testCaseName) throws IOException {
        fis = getFileInputStream();
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet sheet = workbook.getSheet(sheetName);

        int rowCount = sheet.getLastRowNum();
        int columnCount = (sheet.getRow(0).getLastCellNum())-1;

        Object[][] data = new Object[1][columnCount];

        for (int i = 1; i <= rowCount; i++) {
            if (sheet.getRow(i).getCell(0).toString().equals(testCaseName)) {
                for (int j = 0; j < columnCount; j++) {
                    //data[0][j] = sheet.getRow(i).getCell(j + 1).toString();
                    XSSFCell cell = sheet.getRow(i).getCell(j + 1);
                    if (cell == null || cell.getCellType() == CellType.BLANK) {
                        data[0][j] = "";
                    } else {
                        data[0][j] = cell.toString();
                    }
                }
                break;
            }
        }
        workbook.close();
        return data;
    }

    public Object[][] getExcelData() throws IOException {
        fis = getFileInputStream();
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet = wb.getSheetAt(0);

        int TotalNumberOfRows = (sheet.getLastRowNum() + 1);
        int TotalNumberOfColumns = 4;

        String[][] arrayExcelData = new String[TotalNumberOfRows][TotalNumberOfColumns];

        for (int i = 0; i < TotalNumberOfRows; i++) {
            for (int j = 0; j < TotalNumberOfColumns; j++) {
                XSSFRow row = sheet.getRow(i);
                arrayExcelData[i][j] = row.getCell(j).toString();
            }
        }
        wb.close();
        return arrayExcelData;
    }
}


