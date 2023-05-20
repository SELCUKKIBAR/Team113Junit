package Selcuk_Day_10_ActionsClass_Faker_FileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_KlavyeActions extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        //2- https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");
        //3- Arama kutusuna actions method’larini kullanarak Samsung A71 yazdirin
        //   ve Enter’a basarak arama yaptirin

        Actions actions = new Actions(driver);

        WebElement aramaCubugu = driver.findElement(By.id("twotabsearchtextbox"));

        actions.click(aramaCubugu)
                .keyDown(Keys.SHIFT)
                .sendKeys("s")
                .keyUp(Keys.SHIFT)
                .sendKeys("amsung ")
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("71")
                .sendKeys(Keys.ENTER)
                .perform();

        Thread.sleep(2000);

        //4- aramanin gerceklestigini test edin
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@class='a-size-base s-desktop-toolbar a-text-normal']"));

        String expectedIcerik = "Samsung A71";
        String actualSonucYazisi= sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(expectedIcerik));

    }
}
