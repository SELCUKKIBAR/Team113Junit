package Selcuk_Day_09_SwitchgWindiw_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_ActionsClass extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //1- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");
        Thread.sleep(1000);

        //2- Sag ust bolumde bulunan “Account & Lists” menusunun acilmasi icin mouse’u bu menunun ustune getirin
        Actions actions = new Actions(driver);
        WebElement accountHedef = driver.findElement(By.xpath("//*[@id='nav-link-accountList-nav-line-1']"));actions.moveToElement(accountHedef).perform();
        Thread.sleep(1000);

        //3- “Create a list” butonuna basin
        WebElement accountYazisi = driver.findElement(By.xpath("//*[text()='Create a List']"));
        accountYazisi.click();
        Thread.sleep(1000);

        //4- Acilan sayfada “Your Lists” yazisi oldugunu test edin
        String actualYazi = driver.findElement(By.xpath("//*[@role='heading']")).getText();
        String expectedYazi = "Your Lists";
        Assert.assertEquals(expectedYazi,actualYazi);
        Thread.sleep(1000);

    }
}
