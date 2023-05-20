package Selcuk_Day_07_Junit_dropdown;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CheckBoxes {

    //Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
    //a. Verilen web sayfasına gidin.
    // https://the-internet.herokuapp.com/checkboxes
    //b. Checkbox1 ve checkbox2 elementlerini locate edin.
    //c. Checkbox1 seçili değilse onay kutusunu tıklayın
    //d. Checkbox2 seçili değilse onay kutusunu tıklayın
    //e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin


    WebDriver driver;

    @Before

    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void teardown(){
        driver.close();
    }

    @Test

    public void chechkBoxTest() throws InterruptedException {
        //a. Verilen web sayfasına gidin.
        // https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement chechBoc1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement chechBoc2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        Thread.sleep(1000);
        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!chechBoc1.isSelected()){
            chechBoc1.click();
        }
        Thread.sleep(1000);
        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!chechBoc2.isSelected()){
            chechBoc2.click();
        }
        Thread.sleep(1000);

        //e. Checkbox1ve Checkbox2’nin seçili olduğunu test edin
        Assert.assertTrue(chechBoc1.isSelected() && chechBoc2.isSelected());

        Thread.sleep(1000);

    }



}
