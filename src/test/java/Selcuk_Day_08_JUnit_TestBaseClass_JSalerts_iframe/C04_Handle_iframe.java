package Selcuk_Day_08_JUnit_TestBaseClass_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_Handle_iframe extends TestBase {



    @Test
    public void test01() throws InterruptedException {
        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //- “An IFrame containing….” textinin erisilebilir oldugunu test edin
        //   ve konsolda yazdirin.
        WebElement iFrameYaziElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(iFrameYaziElementi.isDisplayed());
        System.out.println(iFrameYaziElementi.getText());



        //- Text Box’a “Merhaba Dunya!” yazin.
        WebElement frameElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElementi);
        WebElement textBoxElementi = driver.findElement(By.xpath("//body[@id='tinymce']"));
        Thread.sleep(2000);
        textBoxElementi.clear();

        textBoxElementi.sendKeys("Merhaba Dünya");
        Thread.sleep(2000);
        //- TextBox’in altinda bulunan “Elemental Selenium”
        // linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        driver.switchTo().defaultContent();
        WebElement elementLinki = driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(elementLinki.isDisplayed());
        System.out.println(elementLinki.getText());
    }


}
