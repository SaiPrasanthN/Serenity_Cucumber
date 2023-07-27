package com.learning.utilities;

import com.learning.base.BaseClass;
import net.serenitybdd.screenplay.targets.Target;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities extends BaseClass {

    public String getCurrentTitle() {
        return driver.getTitle();
    }


    public void waitForNoMoreThan(Target target, int seconds) {
        target.waitingForNoMoreThan(Duration.ofSeconds(seconds));
    }


    public Map<String, String> readData_Excel(String fileName) throws IOException {
        String path=System.getProperty("user.dir")+File.separator+"src"+File.separator
                +"test"+File.separator+"resources"+File.separator+fileName;
        Map<String, String> values = new HashMap<>();
        FileInputStream fils = new FileInputStream(new File(path));
        String key = "";
        String value = "";
        XSSFWorkbook xssfWorkbook = new XSSFWorkbook(fils);
        XSSFSheet sheet = xssfWorkbook.getSheet("Sheet1");
        Iterator<Row> rowIterator = sheet.rowIterator();


        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();


            while (cellIterator.hasNext()) {
                Cell cell = cellIterator.next();
                int index = cell.getColumnIndex();
                DataFormatter dataFormatter = new DataFormatter();
                value = dataFormatter.formatCellValue(row.getCell(index));

                if (index == 0) {
                    key = value;
                }


            }


            values.put(key, value);


        }


        return values;
    }

    public void writeToTextFile(String text) throws IOException {
        String path=System.getProperty("user.dir")+File.separator+"src"+File.separator+
                "test"+File.separator+"resources"+File.separator+ "TestData.txt";

        FileWriter fileWriter=new FileWriter(path,true);
        fileWriter.write(text);
        fileWriter.close();
    }

    public Map<String,String> readFromTextFile() throws IOException {
        String path=System.getProperty("user.dir")+File.separator+"src"+File.separator+
                "test"+File.separator+"resources"+File.separator+ "TestData.txt";
Map<String,String> data=new HashMap<>();
        String totalText=new String(Files.readAllBytes(Paths.get(path)));
String [] array=totalText.split("\n");
for(String string :array){

    String key= StringUtils.substringBefore(string,"=");
    String value= StringUtils.substringAfter(string,"=");
    data.put(key,value);
}
return data;


    }
}
