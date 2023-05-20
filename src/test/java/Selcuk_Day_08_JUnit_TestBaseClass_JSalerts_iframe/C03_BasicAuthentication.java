package Selcuk_Day_08_JUnit_TestBaseClass_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_BasicAuthentication extends TestBase {


    @Test
    public void test01() throws InterruptedException {
        //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //Html komutu : https://username:password@URL
        //Username    : admin
        //password     : admin
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        Thread.sleep(1000);


        //4- Basarili sekilde sayfaya girildigini dogrulayin
        WebElement congratyazielementi= driver.findElement(By.tagName("p"));
        Assert.assertTrue(congratyazielementi.isDisplayed());
        Thread.sleep(1000);
    }
}
