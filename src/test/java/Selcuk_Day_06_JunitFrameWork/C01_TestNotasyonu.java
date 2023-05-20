package Selcuk_Day_06_JunitFrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_TestNotasyonu {
    /*
        Bu class icerisinde 3 test calistiralim
        1- google anasayfaya gidip, url'in google icerdigini test edin
        2- wisequarter anasayfaya gidip url'in wisequarter icerdigini test edin
        3- amazon anasayfaya gidip, amazon logosunun gorundugunu test edin
     */

    /*
        JUnit'in bize sagladigi ilk ve belki de en onemli ozellik
        test method'larinin bagimsiz olarak calistirilabilmesini saglayan
        @Test notasyonudur.

        Junit ile class level'dan birden fazla test method'u calistirirsak
        hangi siralama ile calistiracagini ongoremeyiz ve yonetemeyiz

        Diyelim ki bir test method'u uzerinde calisiyorsunuz
        ve o method'un toplu calistirilmalarda kullanilmasini istemiyorsunuz
        bu durumda @Ignore kullanabilirsiniz

     */

    WebDriver driver;

    @Test @Ignore
    public void googleTest(){
        mahserin4Atlisi();
        //1- google anasayfaya gidip, url'in google icerdigini test edin
        driver.get("https://www.google.com");
        String expectedTitle = "google";
        String actualtitle = driver.getCurrentUrl();
        if (actualtitle.contains(expectedTitle)){
            System.out.println("Url google içeriyormu testi PASSED");
        }else{
            System.out.println("Url google içeriyormu testi FAİLED");
        }
        System.out.println("google test");

        driver.close();

    }


    @Test
    public void wiseTest(){
        mahserin4Atlisi();
        //2- wisequarter anasayfaya gidip url'in wisequarter icerdigini test edin
        driver.get("https://www.wisequarter.com");
        String expectedTitle = "wisequarter";
        String actualtitle = driver.getCurrentUrl();
        if (actualtitle.contains(expectedTitle)){
            System.out.println("Url wisequarter içeriyormu testi PASSED");
        }else{
            System.out.println("Url wisequarter içeriyormu testi FAİLED");
        }
        System.out.println("wise test");

        driver.close();

    }


    @Test
    public void amazonTest(){
        mahserin4Atlisi();
        //3- amazon anasayfaya gidip, amazon logosunun gorundugunu test edin
        driver.get("https://www.amazon.com");
        WebElement amazonLogoElementi = driver.findElement(By.id("nav-logo-sprites"));
        if (amazonLogoElementi.isDisplayed()){
            System.out.println("amazon testi PASSED");
        }
        else {
            System.out.println("amazon logosu görünmüyor FAİLED");
        }
        System.out.println("amazon test");

        driver.close();

    }


    public void mahserin4Atlisi(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

}
