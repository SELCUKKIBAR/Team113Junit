package Selcuk_Day_12_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {


    @Test
    public void test01(){


        //1. “https://demoqa.com/webtables” sayfasina gidin
        driver.get("https://demoqa.com/webtables");

        //2. Headers da bulunan basliklari yazdirin
        List<WebElement> basliklarList = driver.findElements(By.xpath("//div[@role = 'columnheader']"));
        for (WebElement eachHeder:basliklarList
             ) {
            System.out.println(eachHeder.getText());
        }
        //3. 3.sutunun basligini yazdirin
        System.out.println("3.Sütün Başlığı...: "+basliklarList.get(3).getText());

        //4. Tablodaki tum datalari yazdirin
        System.out.println("********************");
        List<WebElement> tablodakiTumElementler = driver.findElements(By.xpath("//div[@role = 'gridcell']"));
        int bosOlmayanDataSayisi = 0;

        for (WebElement eachData:tablodakiTumElementler
             ) {
            if (!eachData.getText().isBlank()){
                System.out.println(eachData.getText());
                bosOlmayanDataSayisi++;
            }
        }

        //5. Tabloda kac tane bos olmayan cell (data) oldugunu yazdirin
        System.out.println("++++++++++++++++++");
        System.out.println("Tabloda boş olmayan hücre sayısı...: "+bosOlmayanDataSayisi);


        //6. Tablodaki satir sayisini yazdirin
        List<WebElement>satirlarList = driver.findElements(By.xpath("//div[@role='rowgroup']"));
        System.out.println("Tablodaki satir sayısı...: "+satirlarList.size());

        //7. Tablodaki sutun sayisini yazdirin
        System.out.println("Tablodaki sütün sayısı...: "+basliklarList.size());

        //8. Tablodaki 3.kolonu yazdirin
        List<WebElement>ucuncuSutunElementleri = driver.findElements(By.xpath("(//div[@role='row'])/div[3]"));

        System.out.println("==========3.SUTUN==============");
        for (WebElement eachData:ucuncuSutunElementleri
        ) {
            if (!eachData.getText().isBlank()){
                System.out.println(eachData.getText());

            }
        }

        //9. Tabloda "First Name" i Kierra olan kisinin Salary'sini yazdirin
        for (int i = 2; i <satirlarList.size() ; i++) {
            WebElement isim = driver.findElement(By.xpath(getDinamikXpath(i,1)));
            if (isim.getText().equalsIgnoreCase("Kierra")){
                WebElement salary = driver.findElement(By.xpath(getDinamikXpath(i,5)));
                System.out.println("Kierra'nın Maaşı...: "+salary.getText());
            }
        }

        //10. bir method olusturun,
        //satir ve sutun sayisini girdigimde bana datayi yazdirsin
        dataYAzdir(4,3);


    }

    private void dataYAzdir(int satirNo, int sutunNo) {
        String dinamikXpath = "(//div[@role='row'])["+satirNo+"]/div["+sutunNo+"]";
        WebElement istenenElement = driver.findElement(By.xpath(dinamikXpath));
        System.out.println("İstenen hücredeki data...: "+istenenElement.getText());
    }

    public String  getDinamikXpath(int satirNo,int sutunNo){

        return "(//div[@role='row'])["+satirNo+"]/div["+sutunNo+"]";
    }




}
