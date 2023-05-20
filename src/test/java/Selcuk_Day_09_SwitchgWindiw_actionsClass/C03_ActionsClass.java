package Selcuk_Day_09_SwitchgWindiw_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import javax.swing.*;
import java.util.Set;


public class C03_ActionsClass extends TestBase {



    @Test
    public void test01() throws InterruptedException {

        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String ilkSayfaHandle = driver.getWindowHandle();
        Thread.sleep(1000);

        //3- Cizili alan uzerinde sag click yapin

        WebElement ciziliAlan = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);

        actions.contextClick(ciziliAlan).perform();


        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedAlertYazisi = "You selected a context menu";
        String actualAlertYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazi);
        Thread.sleep(1000);

        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();
        Thread.sleep(1000);

        //6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.linkText("Elemental Selenium")).click();
        Set<String>wHandelDegerleri = driver.getWindowHandles();
        String ikinciSayfaHandle = "";
        for (String eachHandel:wHandelDegerleri
             ) {
            if (!eachHandel.equals(ikinciSayfaHandle)){
                ikinciSayfaHandle = eachHandel;
            }
        }
        driver.switchTo().window(ikinciSayfaHandle);
        Thread.sleep(1000);

        //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        String expectedH1Tagi = "Elemental Selenium";
        String actualH1Tagi = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(expectedAlertYazisi,actualAlertYazi);
        Thread.sleep(1000);

    }



}
