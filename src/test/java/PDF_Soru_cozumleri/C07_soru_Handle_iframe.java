package PDF_Soru_cozumleri;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C07_soru_Handle_iframe extends TestBase {


    @Test
    public void test01() throws InterruptedException {

        // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");

        //- “An IFrame containing….” textinin erisilebilir oldugunu test edin
        //   ve konsolda yazdirin.
        WebElement sayfaMesaji = driver.findElement(By.tagName("h3"));
        Thread.sleep(1000);
        Assert.assertTrue(sayfaMesaji.isDisplayed());
        Thread.sleep(1000);
        System.out.println(sayfaMesaji.getText());
        Thread.sleep(1000);

        //- Text Box’a “Merhaba Dunya!” yazin.
        WebElement frameElementi = driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(frameElementi);
        Thread.sleep(1000);

        WebElement textBoxElementi = driver.findElement(By.xpath("//*[@id='tinymce']"));
        Thread.sleep(1000);
        textBoxElementi.clear();
        Thread.sleep(1000);

        Thread.sleep(1000);
        textBoxElementi.sendKeys("Bebeğim Duygu ATAMAN KİBAR");
        Thread.sleep(1000);

        //- TextBox’in altinda bulunan “Elemental Selenium”
        // linkini textinin gorunur oldugunu dogrulayin ve  konsolda yazdirin.
        driver.switchTo().defaultContent();// içteki iframden çıkıyoruz..
        WebElement elementLinki = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(elementLinki.isDisplayed());
        System.out.println(elementLinki.getText());
        Thread.sleep(1000);







    }
}
