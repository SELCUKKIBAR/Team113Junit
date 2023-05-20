package Selcuk_Day_08_JUnit_TestBaseClass_JSalerts_iframe;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import utilities.TestBase;

public class C01_TestBase_ilkClass extends TestBase{




    @Test
    public void test01(){
        // amazona gidelim
        driver.get("https://amazon.com/");
        // nutella için arama yapalım
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("nutella"+ Keys.ENTER);
        // arama sonuçlarının nutella içerdiğini test edelim....

        String expectedSonuc = "nutella";
        String actualSonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();

        Assert.assertTrue(actualSonuc.contains(expectedSonuc));
    }
}
