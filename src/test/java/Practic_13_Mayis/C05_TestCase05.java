package Practic_13_Mayis;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C05_TestCase05 extends TestBase {

    @Test

    public void test01() throws InterruptedException, FileNotFoundException {
        //Test Case 5: Contact Us Form
        //1. Launch browser
        driver.get("https://www.google.com");

        //2. Navigate to url 'http://automationexercise.com'
        driver.navigate().to("http://automationexercise.com");

        //3. Verify that home page is visible successfully

        String anaSayfaTitle = "Automation Exercise";
        String resultSayfaTitle = driver.getTitle();
        Assert.assertEquals(anaSayfaTitle,resultSayfaTitle);

        //4. Click on 'Contact Us' button
        driver.findElement(By.xpath("//a[text()=' Contact us']")).click();

        //5. Verify 'GET IN TOUCH' is visible
        WebElement getinTouch = driver.findElement(By.xpath("//*[text()='Get In Touch']"));
        Assert.assertTrue(getinTouch.isDisplayed());

        //6. Enter name, email, subject and message
        Actions actions = new Actions(driver);
        WebElement name = driver.findElement(By.xpath("//*[@name='name']"));
        actions.click(name)
                        .sendKeys("Selçuk")
                        .keyDown(Keys.TAB)
                        .sendKeys("selcukkibar88@gmail.com")
                        .keyDown(Keys.TAB)
                        .sendKeys("Merhaba")
                        .keyDown(Keys.TAB)
                        .sendKeys("Merhaba bu bir test denemesidir Dikkate almayınız.... :) ")
                        .perform();

        //7. Upload file


        WebElement clikYap = driver.findElement(By.xpath("//input[@type='file']"));
        String dosyaYolu = System.getProperty("user.dir")+"/src/test/java/PDF_Soru_cozumleri/QA Haftalik Ders Programi - WQ.xlsx - TEAM113 Guncel (3).pdf";

        clikYap.sendKeys(dosyaYolu);
        Thread.sleep(2000);

        //8. Click 'Submit' button
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();

        //9. Click OK button
        driver.switchTo().alert().accept();


        //10. Verify success message 'Success! Your details have been submitted successfully.' is
        //visible
        WebElement SuccesMesage = driver.findElement(By.xpath("(//*[@style='display: block;'])[1]"));
        Assert.assertTrue(SuccesMesage.isDisplayed());


        //11. Click 'Home' button and verify that landed to home page successfully
        driver.findElement(By.xpath("(//*[text()=' Home'])[2]")).click();
        Thread.sleep(1000);

        Assert.assertEquals(anaSayfaTitle,resultSayfaTitle);
        Thread.sleep(1000);
    }


}
