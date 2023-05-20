package PDF_Soru_cozumleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.awt.*;
import java.time.Duration;
import java.util.List;

public class C09_webTables_soru extends TestBase {

    @Test

    public void test01() throws InterruptedException {

        // amazona git
        driver.get("https://www.amazon.com/");
        // sayfanın altına in
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(3000);

        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement> sayfaSatirSayisi = driver.findElements(By.xpath("//tbody/tr/td[3]"));

        int satirSayisi = 9;
        int resultSatirSayisi = sayfaSatirSayisi.size();

        Assert.assertEquals(satirSayisi,resultSatirSayisi);

        //5.Tum satirlari yazdirin

        for (WebElement eachWeb:sayfaSatirSayisi
             ) {
            System.out.println("=============");
            System.out.println(eachWeb.getText());

        }











    }
}
