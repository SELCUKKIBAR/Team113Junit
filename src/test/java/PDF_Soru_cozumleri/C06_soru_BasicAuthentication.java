package PDF_Soru_cozumleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class C06_soru_BasicAuthentication extends TestBase {

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
        String expectedMesaj= "Congratulations! You must have the proper credentials.";
        String actualMesaj = driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(expectedMesaj,actualMesaj);
        Thread.sleep(1000);


    }
}
