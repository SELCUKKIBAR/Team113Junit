package Selcuk_Day_07_Junit_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_dropdown {

//   ● https://www.amazon.com/ adresine gidin.

//   // - Test 1
//   Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

//	-Test 2
// 1. Kategori menusunden Books secenegini secin
//2. Arama kutusuna Java yazin ve aratin
//3. Bulunan sonuc sayisini yazdirin
//4. Sonucun Java kelimesini icerdigini test edin

    static WebDriver driver;

    @BeforeClass

    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public static void theardown(){
        driver.close();
    }

    @Test

    public void test01(){
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin

        WebElement ddm = driver.findElement(By.xpath("//select[@id = 'searchDropdownBox'"));
        Select select = new Select(ddm);
        int expectedOptionSayisi = 45;
        int actualdOptionSayisi = select.getOptions().size();

        Assert.assertEquals(expectedOptionSayisi,actualdOptionSayisi);
    }

}
