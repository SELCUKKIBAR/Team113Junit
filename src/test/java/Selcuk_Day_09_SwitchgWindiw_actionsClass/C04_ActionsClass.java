package Selcuk_Day_09_SwitchgWindiw_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_ActionsClass extends TestBase {


    @Test
    public void test01() throws InterruptedException {

        //1- https://demoqa.com/droppable adresine gidelim
        driver.get("https://demoqa.com/droppable");
        Thread.sleep(1000);

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragMe = driver.findElement(By.xpath("//*[@id='draggable']"));

        Actions actions = new Actions(driver);


        WebElement dropHere = driver.findElement(By.xpath("//*[@id='droppable']"));

        Thread.sleep(1000);
        actions.dragAndDrop(dragMe,dropHere).perform();
        Thread.sleep(1000);
        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement dropYazielementi = driver.findElement(By.tagName("p"));

        String expectedYazi = "Dropped!";
        String actualYazi = dropYazielementi.getText();
        Assert.assertEquals(expectedYazi,actualYazi);


    }
}
