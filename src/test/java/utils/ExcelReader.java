package utils;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {

    /*note: in here we are creating two static variable,
   so that i can use these variable among the methods where every i can  need it . note instead of static we  can have default also */
    static Workbook book;
    static Sheet sheet;

    public static void openExcel(String filePath){ // we are creating this method  to open the excel book/file
        try {
            FileInputStream fis = new FileInputStream(filePath);//navigate the file
            book = new XSSFWorkbook(fis); /* working with Excel we have two extension which is(xls & xlsx)for xls we use HSSFWorkbook and for .xlsx we will use XSSF.Both HSSF & XSSF
            are special class which is used to load/handle the files */
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getSheet(String sheetName){ //we are creating this method for opening the Excel sheet
        sheet = book.getSheet(sheetName);//open the sheet in which we have data with the help of getsheet()method
    }
    //this method will give the row count
    public static int getRowCount(){ //We are creating this method to k
        // how many rows actually contain the data in the sheet
        return sheet.getPhysicalNumberOfRows();//
    }
    //this method will give the column count
    public static int getColsCount(int rowIndex){
        return sheet.getRow(rowIndex).getPhysicalNumberOfCells();
    }

    //this method will give the cell data in string format
    public static String getCellData(int rowIndex, int colIndex){
        return sheet.getRow(rowIndex).getCell(colIndex).toString();
    }

//this method will return list of maps having all the data from excel file

    public static List<Map<String, String>> excelListIntoMap
            (String filePath, String sheetName){
        openExcel(filePath);
        getSheet(sheetName);

        //creating a list of maps for all the rows
        List<Map<String, String>> listData = new ArrayList<>();

        //loops - outer loop is always take care of rows
        for (int row=1; row<getRowCount(); row++){
            //creating a map for every row
            Map<String, String> map = new LinkedHashMap<>();

            for (int col=0; col<getColsCount(row); col++){ // A loop to go through all the cells
                map.put(getCellData(0, col), getCellData(row, col));
            }
            listData.add(map);
        }
        return listData;

    }

}
