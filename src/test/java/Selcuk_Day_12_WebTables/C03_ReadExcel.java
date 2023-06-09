package Selcuk_Day_12_WebTables;

import org.apache.hc.core5.util.Asserts;
import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C03_ReadExcel {

    @Test
    public void testt01() throws IOException {

        // bilgisayarimizda olan bir dosyaya erisebilmek icin FileInputStream Class'indan obje olusturalim
        String dosyaYolu = System.getProperty("user.dir")+"/src/test/java/Selcuk_Day_12_WebTables/ulkeler1.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        // projemize ekledigimiz POI kutuphanelerini kullanarak
        // class'imizin icinde istenen excel'in bir kopyasini olusturalim

        Workbook workbook = WorkbookFactory.create(fis);
        Sheet sheet = workbook.getSheet("Sayfa1");
        Row row = sheet.getRow(12);
        Cell cell = row.getCell(3);

        System.out.println(cell);

        // 5.index'deki satirin, 1.index'indeki datanin "Luanda" oldugunu test edin

        row= sheet.getRow(5);
        cell= row.getCell(1);

        String expectedData= "Luanda";

        // cell objesinin data turu Cell
        // Java'da farkli data turlerindeki variable'lari equals ile KULLANAMAYIZ
        Assert.assertEquals(expectedData,cell.toString());


        // 12.satir,2.sutundaki bilginin "Baku" oldugunu test edin

        String actualData= sheet.getRow(11).getCell(1).toString();
        expectedData = "Baku";

        Assert.assertEquals(expectedData,actualData);








    }
}
