package Selcuk_Day_09_SwitchgWindiw_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.TestBase;
import utilities.TestBaseBeforeCalss;

public class C01_newWindow extends TestBase {

    // gerekli ayarlamaları yapıp amazon anasayfaya gidin
    // tittin amazon kelimesi içerdiğini test edin
    // Yeni bir tab açarak wisequarter ana sayfasına gidin
    // url'nin wisequarter içerdiğini test edin...

    @Test
    public void test01() throws InterruptedException {
        // amazon anasayfaya gidin
        driver.get("https://www.amazon.com/");
        String amazonHandel = driver.getWindowHandle();
        String expectedTitle = "Amazon";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        Thread.sleep(1000);

        driver.switchTo().newWindow(WindowType.TAB).get("https://wisequarter.com/");
        String wiseHandel =driver.getWindowHandle();
        Thread.sleep(1000);
        String expectedUrl ="wisequarter";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));

        // tekrar amazon açık olduğu sayfaya geçin
        // ve url in amazon içerdiğnii test edin...

        Thread.sleep(1000);
        driver.switchTo().window(amazonHandel);
        System.out.println("amazona geri döndüm aga");
        Thread.sleep(1000);
        String expectedUrlamazon ="amazon";
        String actualUrlamazon = driver.getCurrentUrl();
        Assert.assertTrue(actualUrlamazon.contains(expectedUrlamazon));
    }

}
