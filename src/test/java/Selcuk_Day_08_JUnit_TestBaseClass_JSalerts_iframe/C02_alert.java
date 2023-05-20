package Selcuk_Day_08_JUnit_TestBaseClass_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;
import utilities.TestBaseBeforeCalss;

public class C02_alert extends TestBaseBeforeCalss {
    /*
        Otomasyon yaparken iki tür alert ile karşılaşabiliriz.
        1- HTML alerts:
                HTML kodları ile oluşturulmuş alert'lerdir.
                HTML ile oluşturulduğu için inspect edilebilir,
                Locate edilebilir ve driver ile kullanilabilir.

        2- JavaScript Alerts:
                Bunlar inspect yapılamaz
                Locate edilemez.
                teslerimiz sırasında JSalerts ile karşılaşırsak
                driver.swicthTo.alert methodlarinı kullanarak
                alaerte geçiş yapabilir ve alert üzerinde
                ok-cancel-alert yazsını alma(getText) ve alerte yazı yollama
                yapabiliriz(sendKeys) methodlarını kullanabilirz....

         */

    @Test
    public void test01() throws InterruptedException {





 //      1. Test
 // https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        Thread.sleep(1000);
 // 1.alert’e tiklayin
        driver.findElement(By.xpath("//*[@onclick='jsAlert()']")).click();
        Thread.sleep(1000);
 // Alert’deki yazinin “I am a JS Alert” oldugunu test edin
        String expectedAlertYazisi = "I am a JS Alert";
        Thread.sleep(1000);

        String actualAlertYazisi = driver.switchTo().alert().getText();
        Thread.sleep(1000);
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazisi);
        Thread.sleep(1000);

 // OK tusuna basip alert’i kapatin
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

    }
    @Test
    public void test02() throws InterruptedException {
        //2.Test
        //            - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        //            - 2.alert'e tiklayalim
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        //            - Cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(1000);
        String expectedSonucYazisi= "You clicked: Cancel";
        String actualSonucYazisi=driver.findElement(By.xpath("//*[@id='result']")).getText();
        Assert.assertEquals(expectedSonucYazisi,actualSonucYazisi);

    }
    @Test
    public void test03() throws InterruptedException {
       //3.Test
       //        - https://the-internet.herokuapp.com/javascript_alerts adresine gidin
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
       //- 3.alert’e tiklayalim
        driver.findElement(By.xpath("//*[@onclick='jsPrompt()']")).click();
        Thread.sleep(1000);

       //- Cikan prompt ekranina “Abdullah” yazdiralim
        driver.switchTo().alert().sendKeys("Abdullah");
        Thread.sleep(1000);
       //        - OK tusuna basarak alert’i kapatalim
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
       //- Cikan sonuc yazisinin Abdullah icerdigini test edelim
        String expectedIcerik = "Abdullah";
        String actualIcerik = driver.findElement(By.xpath("//*[@id='result']")).getText();

        Assert.assertTrue(actualIcerik.contains(expectedIcerik));
    }
}
