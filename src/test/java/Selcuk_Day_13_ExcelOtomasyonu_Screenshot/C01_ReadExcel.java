package Selcuk_Day_13_ExcelOtomasyonu_Screenshot;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C01_ReadExcel {

    @Test

    public void test01() throws IOException {

        // ulkeler.xlsx dosyasinda 16.satirdaki ulkenin
        // turkce isminin Barbados oldugunu test edin

        String dosyaYolu = System.getProperty("user.dir")+"/src/test/java/day12_webTables_excelOtomasyon/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        String actualIsim = workbook
                            .getSheet("Sayfa1")
                            .getRow(15)
                            .getCell(2)
                            .toString();

        String expectedIsim = "Barbados";
        Assert.assertEquals(expectedIsim,actualIsim);


        // Excel'de ingilizce ismi Benin olan bir ulke
        // olup olmadigini test edin

        int sonSatirIndexi = workbook.getSheet("Sayfa1").getLastRowNum();
        System.out.println("Son satırın index numarası...: "+sonSatirIndexi);

        boolean beninVarmi = false;

        for (int i = 1; i <=sonSatirIndexi ; i++) {

            actualIsim = workbook
                    .getSheet("Sayfa1")
                    .getRow(i)
                    .getCell(0)
                    .toString();

            if (actualIsim.equalsIgnoreCase("Benin")){
                beninVarmi = true;
                break;
            }

        }

        Assert.assertTrue(beninVarmi);


        // Sayfa2'de kullanilan satir sayisinin 7 oldugunu test edin
        int kullanilanSatirSayisi = workbook.getSheet("Sayfa2").getPhysicalNumberOfRows();
        int expectedSatirSayisi =8;

        Assert.assertEquals(expectedSatirSayisi,kullanilanSatirSayisi);


        // Sayfa1'deki tum ulke isimlerini
        // ve tum bilgileri bir Map olarak kaydedin
        // ingilizce isim key, geriye kalanlar ise birlestirilerek value olsun


        Map<String,String>ulkelerMAp = new TreeMap<>();

        Sheet sheet = workbook.getSheet("Sayfa1");

        for (int i = 1; i <=sonSatirIndexi ; i++) {

            String  key = sheet.getRow(i).getCell(0).toString();

            String  value = sheet.getRow(i).getCell(1).toString()+" ,"+
                            sheet.getRow(i).getCell(2).toString()+" ,"+
                            sheet.getRow(i).getCell(3).toString();

            ulkelerMAp.put(key,value);

        }
        System.out.println(ulkelerMAp);

        // Ismi Netherlands olan ulke var mi test edin

        Assert.assertTrue(ulkelerMAp.containsKey("Netherlands"));









    }
}
