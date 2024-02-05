package utils.excelutils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelFile {

    private static final String EXCEL_PATH = System.getProperty("user.dir") + "/src/test/resources/excel/credentials.xlsx";

    FileInputStream workBookLocation;
    XSSFWorkbook workbook;
    XSSFSheet sheet;

    public ReadExcelFile(){
        try {
            workBookLocation = new FileInputStream(EXCEL_PATH);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            workbook = new XSSFWorkbook(workBookLocation);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String getExcelData(int sheetNumber, int rowNumber, int columnNumber){
        sheet = workbook.getSheetAt(sheetNumber);
        return sheet.getRow(rowNumber).getCell(columnNumber).getStringCellValue();
    }

    public int getRowCount(int sheetIndex){
        return workbook.getSheetAt(sheetIndex).getLastRowNum();
    }
}