package PDF_Soru_cozumleri;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_soru02_sayfa98 {

//    Handle Dropdown
//● Bir class oluşturun: DropDown
//● https://the-internet.herokuapp.com/dropdown adresine gidin.

//1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
//2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
// 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
// 4.Tüm dropdown değerleri(value) yazdırın
//5. Dropdown’un boyutunun 4 olduğunu test edin

    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");

    }
    @After
    public void tearDown(){
        driver.close();
    }

    @Test
    public void test01(){
        //dropdown adresine gidin.
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        // 3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        // 4.Tüm dropdown değerleri(value) yazdırın
        //5. Dropdown’un boyutunun 4 olduğunu test edin

        driver.findElement(By.xpath("//a[@href='/dropdown']")).click();
        WebElement ddm = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(ddm);
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
// 4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> valueDeger= select.getOptions();
        for (WebElement each:valueDeger
        ) {
            System.out.println(each.getText());
        }

        int actualDropDownElemanSayisi = valueDeger.size();
        int expectedDropDownElemanSayisi = 3;

        Assert.assertEquals(expectedDropDownElemanSayisi,actualDropDownElemanSayisi);






    }



}
