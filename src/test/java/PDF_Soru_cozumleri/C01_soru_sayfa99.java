package PDF_Soru_cozumleri;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_soru_sayfa99 {

//    Handle Dropdown
//● Bir class oluşturun: C3_DropDownAmazon
// ● https://www.amazon.com/ adresine gidin.
//            - Test 1
// Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45 oldugunu test edin



    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.amazon.com/");
    }

    @AfterClass
    public static void theardown(){
        //driver.close();
    }

    @Test
    public void test01(){
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select = new Select(dropDownMenu);

        int expectedSayi = 27;
        int actualSayi = select.getOptions().size();
        Assert.assertEquals(expectedSayi,actualSayi);


    }

    @Test
    public void test02(){
        //-Test 2
//1. Kategori menusunden Books secenegini secin
// 2. Arama kutusuna Java yazin ve aratin
//3. Bulunan sonuc sayisini yazdirin
//4. Sonucun Java kelimesini icerdigini test edin
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDownMenu);
        select.selectByVisibleText("Books");

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java"+ Keys.ENTER);
        String  mesagge = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]")).getText();
        System.out.println(mesagge);
        String  expedtedMesaage = "Java";

        Assert.assertTrue("Test FAİLED",mesagge.contains(expedtedMesaage));





    }








}
