package Utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ExcelReader {
   public static List<Map<String,String>> read(String sheetName, String path){
        List<Map<String,String>>dataList=new ArrayList<>();
        FileInputStream fileInputStream=null;
        try{
            fileInputStream = new FileInputStream(path);
            // that special call which knows how to read the data from excel files
            XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fileInputStream);
            Sheet sheet = xssfWorkbook.getSheet(sheetName);
            //this row is just for keys
            Row headerRow = sheet.getRow(0);
            for(int i=1;i<sheet.getPhysicalNumberOfRows();i++){
          Row row=sheet.getRow(i);
          Map<String,String>rowMap=new LinkedHashMap<>();
                for (int col = 0; col < row.getPhysicalNumberOfCells(); col++){
                    String key= headerRow.getCell(col).toString();
                    String value =row.getCell(col).toString();
                    rowMap.put(key,value);

                }
                dataList.add(rowMap);
            }
        }catch (IOException io){
            io.printStackTrace();
        }finally {
            try {
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
            }catch(IOException e){
                    throw new RuntimeException(e);
                }
            }


        return dataList;
    }
}
