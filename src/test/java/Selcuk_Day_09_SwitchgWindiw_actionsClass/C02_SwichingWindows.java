package Selcuk_Day_09_SwitchgWindiw_actionsClass;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C02_SwichingWindows extends TestBase {


    @Test

    public void test01() throws InterruptedException {

        // ● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaHandle = driver.getWindowHandle();
        Thread.sleep(1000);

        // ● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement openYazi = driver.findElement(By.tagName("h3"));
        String expectedYazi = "Opening a new window";
        String actualYazi = openYazi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);
        Thread.sleep(1000);

        // ● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        Thread.sleep(1000);

        // ● Click Here butonuna basın.
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();
        // 36. satır itibari ile newwindow açıldı ve artık 2 window var,
        Thread.sleep(1000);

        Set<String>windowHandelDegerleri = driver.getWindowHandles();

        String ikinciSayfaHandelDegeri ="";
        for (String eachWHandel:windowHandelDegerleri
             ) {
            if (!eachWHandel.equals(ilkSayfaHandle)){
                ikinciSayfaHandelDegeri=eachWHandel;
            }
        }


        // bu satır itibari ile 2.sayfanın handel değerine sahibiz....



        // ● Acilan yeni pencerenin sayfa başlığının (title) “New Window”
        // oldugunu dogrulayin.
        driver.switchTo().window(ikinciSayfaHandelDegeri);
        System.out.println(driver.getTitle());

        // ● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String expectedYeniSayfaTxt = "New Window";
        String actualYeniSayfaTxt = driver.findElement(By.tagName("h3")).getText();
        Assert.assertEquals(expectedTitle,actualTitle);

        // ● Bir önceki pencereye geri döndükten sonra sayfa başlığının
        // “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandle);
         expectedTitle = "The Internet";
         actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle,actualTitle);
        Thread.sleep(1000);
    }
}
