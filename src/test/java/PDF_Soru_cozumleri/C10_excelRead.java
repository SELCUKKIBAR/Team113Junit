package PDF_Soru_cozumleri;

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

public class C10_excelRead {


    @Test
    public void test01() throws IOException {

        // 166. satırdaki ülkenin başkentinin türkçe okunuşunu getiriniz... ve Bern olduğunu doğrulayın
        String dosyaYolu = System.getProperty("user.dir")+"/src/test/java/day12_webTables_excelOtomasyon/ulkeler.xlsx";

        FileInputStream fis = new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        String sehirIsmi = workbook.getSheet("Sayfa1").getRow(165).getCell(3).toString();
        System.out.println("İsviçrenin Başkenti...: "+sehirIsmi);

        String expectedBaskent = "Bern";

        Assert.assertEquals(expectedBaskent,sehirIsmi);

        // Sayfa1'deki tum ulke isimlerini
        // ve tum bilgileri bir Map olarak kaydedin
        // ingilizce isim key, geriye kalanlar ise birlestirilerek value olsun

        int sonSatirIndexi = workbook.getSheet("Sayfa1").getLastRowNum();

        Map<String,String> ulkeIsimleriMap = new TreeMap<>();
        Sheet sheet = workbook.getSheet("Sayfa1");

        for (int i = 1; i <=sonSatirIndexi ; i++) {

            String key = sheet.getRow(i).getCell(0).toString();

            String value = sheet.getRow(i).getCell(1).toString()+", "+
                           sheet.getRow(i).getCell(2).toString()+", "+
                           sheet.getRow(i).getCell(3).toString();

            ulkeIsimleriMap.put(key,value);

        }
        System.out.println(ulkeIsimleriMap);

        // Ismi Netherlands olan ulke var mi test edin

        Assert.assertTrue(ulkeIsimleriMap.containsKey("Netherlands"));
    }
}
