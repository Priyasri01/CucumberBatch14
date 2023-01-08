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
   so that i can use these variable among the methods where every i need it . note instead of static we  can have default also*/
    static Workbook book;
    static Sheet sheet;
//this method will open the excelfile.
    public static void openExcel(String filePath){ // we are creating this method  to open the excel book/file
        try {
            FileInputStream fis = new FileInputStream(filePath);//navigate the file
            book = new XSSFWorkbook(fis); /* working with Excel we have two extension which is(xls & xlsx)for xls we use HSSFWorkbook and
             for ".xlsx" we will use XSSF. And Both HSSF & XSSF are special class which is used to load/handle the files */
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getSheet(String sheetName){ //we are creating this method for opening the Excel sheet
        sheet = book.getSheet(sheetName);//from the "book"(workbook) open the sheet  in which we have data with the help of getsheet()method  and store the sheet in the reference variable.
    }
    //this method will give the row count
    public static int getRowCount(){ /*We are creating this method to know
      how many rows actually contain the data in the sheet */
        return sheet.getPhysicalNumberOfRows();//
    }
    //this method will give the column count
    public static int getColsCount(int rowIndex){ //in here we are find out in each row how many cells/colm are filled with data's. that's why we pass argument rowinte

        return sheet.getRow(rowIndex).getPhysicalNumberOfCells();
    }

    //this method will give the cell data in string format
    public static String getCellData(int rowIndex, int colIndex){ /* after we're  done with  above part  our finall part is to get data from each cell.
    so we created this method .  see we need to coordinate with two stuff/element to get the cell data one is my rowindex & other one is cloIndex,
    therefore we passed both inside the parameter.And also note: we usually  read/get  the data in the form string so created data type to string  */
        return sheet.getRow(rowIndex).getCell(colIndex).toString(); // after we're getting the cell data we are converting them into string with the help of string method(.toString).
    }

    //note now this is the time to club all the above method together  retrieve data
//this method will return list of maps having all the data from excel file

    public static List<Map<String, String>> excelListIntoMap
            (String filePath, String sheetName){ // in here return tpye is list of Map which contain string and passing two parameter(file path & sheet name).
        // note inside this method , the first step is openExcel & second step get the sheet so basically we are calling the both method.
        openExcel(filePath);
        getSheet(sheetName);

        //creating a list of maps for all the rows.
        List<Map<String, String>> listData = new ArrayList<>(); /* basically in here we are creating container to keep all the data which we retrieve from each map and store it here, note we stored in arraylist because it's faster,
         and we can retrieve data through index and also it has get method .so we can get any specify data directly whereas "set" don't have get method and we have use iterator/loop to retrieve the data..  */

        //loops - outer loop is always take care of rows
        for (int row=1; row<getRowCount(); row++){ /* a loop that goes through all the rows that contains data. but note we start with  "row=1" .
             Because ROW(0) We already extracted information before the for loop .since the data will be the same, and we are using this row(o) as key*/

            //creating a map for every row
            Map<String, String> map = new LinkedHashMap<>(); /*note we're creating this map inside the loop, because we need separate map for each row.
         Because as we know key always will be unique .so if we create all the individual row in single map(outside the loop). it won't create separate rather it will overwrite. that's why we are creating map list
         inside the loop , so that it will create separate map for each row while it's iterator*/

            for (int col=0; col<getColsCount(row); col++){ // inner loop will take care the cell . this loop  will  go through all the cells
                map.put(getCellData(0, col), getCellData(row, col)); /*basically in here we take cell data from excel  and putting/adding the data into the map.
                 first getCellData() is for key and second cellData() is for value.*/
            }
            listData.add(map); // once we retrieve the data then we are store the data in ArrayList. note we put this code inside the loop, so that we will add the data in every iteration.
        }
        return listData;

    }

}
