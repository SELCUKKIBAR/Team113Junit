package PDF_Soru_cozumleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class C04_soru_sayfa100 extends TestBase {

    @Test
    public void test01() throws InterruptedException {

        //    Handle Dropdown
        //1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");


        //2. Sign in butonuna basin
        driver.findElement(By.id("signin_button")).click();


        //3. Login kutusuna “username” yazin
        driver.findElement(By.xpath("//*[@id='user_login']")).sendKeys("username");


        //4. Password kutusuna “password.” yazin
        driver.findElement(By.xpath("//*[@id='user_password']")).sendKeys("password");


        driver.findElement(By.xpath("//*[@id='user_remember_me']")).click();


        //5. Sign in tusuna basin
        driver.findElement(By.xpath("//*[@name='submit']")).click();


        driver.navigate().back();


        //6. Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();


        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();


        //7. “Purchase Foreign Currency” tusuna basin
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();


        //8. “Currency” drop down menusunden Eurozone’u secin
        WebElement dropDown = driver.findElement(By.xpath("//*[@id='pc_currency']"));
        Select select = new Select(dropDown);
        select.selectByVisibleText("Eurozone (euro)");


        //9. “amount” kutusuna bir sayi girin
        driver.findElement(By.xpath("//*[@id='pc_amount']")).sendKeys("2000");


        //10. “US Dollars” in secilmedigini test edin
        WebElement usDollars = dropDown.findElement(By.xpath("//*[@id='pc_inDollars_true']"));
        Assert.assertFalse(usDollars.isSelected());


        //11. “Selected currency” butonunu secin
        driver.findElement(By.xpath("//*[@id='pc_inDollars_false']")).click();


        //12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin
        driver.findElement(By.xpath("//*[@id='pc_calculate_costs']")).click();


        driver.findElement(By.xpath("//*[@id='purchase_cash']")).click();



        //13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin.
        String actualForeignYazisi = driver.findElement(By.xpath("//*[text()='Foreign currency cash was successfully purchased.']")).getText();
        String expectedForeignYazisi = "Foreign currency cash was successfully purchased.";
        Assert.assertEquals(expectedForeignYazisi,actualForeignYazisi);


    }


}
