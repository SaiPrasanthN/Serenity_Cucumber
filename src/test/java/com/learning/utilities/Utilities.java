package com.learning.utilities;

import com.learning.base.BaseClass;
import net.serenitybdd.screenplay.targets.Target;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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
}
