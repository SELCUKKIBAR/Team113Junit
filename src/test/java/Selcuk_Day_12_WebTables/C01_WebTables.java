package Selcuk_Day_12_WebTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;


public class C01_WebTables extends TestBase {


    @Test

    public void test01() throws InterruptedException {

        //1."https://www.amazon.com" adresine gidin
        driver.get("https://www.amazon.com");

        // 2.Sayfanin en altina inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END).perform();

        //3.Web table tum body’sini yazdirin
        Thread.sleep(2000);
        WebElement tumBodyElementi = driver.findElement(By.tagName("tbody"));
        System.out.println(tumBodyElementi.getText());

        //4.Web table’daki satir sayisinin 9 oldugunu test edin
        List<WebElement>satirElementleriList = driver.findElements(By.xpath("//tbody/tr"));
        int expectedSatirSayisi = 9;
        int actualSatirSayisi = satirElementleriList.size();

        Assert.assertEquals(expectedSatirSayisi,actualSatirSayisi);

        // 5.Tum satirlari yazdirin
        System.out.println("==============");
        for (WebElement eachSatir:satirElementleriList
             ) {
            System.out.println(eachSatir.getText());
            System.out.println("==============");
        }

        //6. Web table’daki sutun sayisinin 13 olduğunu test edin
        List<WebElement>sutunElemenleriList = driver.findElements(By.xpath("//tbody/tr[1]/td"));
        int expectedSutunSayisi = 13;
        int actualSutunSayisi = sutunElemenleriList.size();
        Assert.assertEquals(expectedSutunSayisi,actualSutunSayisi);

        //7. 5.sutunu yazdirin
        List<WebElement>besinciSatirElementleri = driver.findElements(By.xpath("//tbody/tr/td[5]"));
        for (WebElement eachdata:besinciSatirElementleri
             ) {
            System.out.println(eachdata.getText());
        }

        //8.Satir ve sutun sayisini parametre olarak alip,
        // hucredeki bilgiyi döndüren bir method olusturun


        System.out.println(dataGetir(3,5));
    }

    private String dataGetir(int satirNo, int sutunNo) {

        String dinamikXpath="";

        WebElement istenenDataElementi = driver.findElement(By.xpath("//tbody/tr["+satirNo+"]/td["+sutunNo+"]"));

        System.out.println("==================");
        return istenenDataElementi.getText();
    }


}
