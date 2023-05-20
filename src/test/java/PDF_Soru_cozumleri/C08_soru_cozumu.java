package PDF_Soru_cozumleri;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class C08_soru_cozumu {


  @Test
    public void test01() throws InterruptedException {
      WebDriverManager.chromedriver().setup();
      WebDriver driver = new ChromeDriver();
      driver.manage().window().maximize();

      //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
      driver.get("https://the-internet.herokuapp.com/dynamic_controls");

      //4. Textbox’in etkin olmadigini(enabled) dogrulayın

      WebElement textBoxCheck = driver.findElement(By.xpath("//*[@type = 'text']"));
      Assert.assertFalse(textBoxCheck.isEnabled());

      //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
      driver.findElement(By.xpath("(//*[@type = 'button'])[2]")).click();

      WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(20));
      wait.until(ExpectedConditions.elementToBeClickable(textBoxCheck));

      //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.

      WebElement itsEnableMesaji = driver.findElement(By.xpath("//*[@id= 'message']"));

      Assert.assertTrue(itsEnableMesaji.isDisplayed());

      Thread.sleep(1000);

      driver.quit();




  }


}







    //7. Textbox’in etkin oldugunu(enabled) dogrulayın.


/*
 WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(40));

        wait.until(ExpectedConditions.elementToBeClickable(textBoxElementi));
 */
