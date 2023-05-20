package PDF_Soru_cozumleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBaseBeforeCalss;

import java.util.ArrayList;
import java.util.List;

public class C03_soru_sayfa99Tekrar extends TestBaseBeforeCalss {


    //Handle Dropdown
    //● Bir class oluşturun: C3_DropDownAmazon ● https://www.amazon.com/ adresine gidin.
    @Test
    public void test01(){

        //- Test 1
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin
        driver.get("https://www.amazon.com");

        WebElement allBox = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(allBox);
        int expectedSayi = 45;
        int actualSayi = select.getOptions().size(); // actualSayiya allBox da kaç katagori varsa onun sayısını döndürür....
        Assert.assertEquals(expectedSayi,actualSayi);

    }
    @Test
    public void test02(){

        //-Test 2
        //1. Kategori menusunden Books secenegini secin
        WebElement allBox = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(allBox);
        select.selectByVisibleText("Books");

        // 2. Arama kutusuna Java yazin ve aratin
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("Java" + Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
        String  mesagge = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText(); //1-48 of over 4,000 results for "Java"
        String[]actualArr = mesagge.split(" "); //[1-48,of,over,4.000,results,for,"Java"]
        int sonucSayisi = Integer.parseInt(actualArr[3].replace(",","")); // 4,000'ü 4000 e çeviriyor....
        System.out.println("Arama sonucunda içerisinde Java geçen sonuç sayısı...: "+sonucSayisi);

        //4. Sonucun Java kelimesini icerdigini test edin
        String expectedSonuc = "Java";
        Assert.assertTrue(mesagge.contains(expectedSonuc));

    }
}
