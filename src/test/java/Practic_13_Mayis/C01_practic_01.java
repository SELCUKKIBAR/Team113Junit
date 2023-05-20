package Practic_13_Mayis;

import org.junit.*;

public class C01_practic_01 {

    /*
    @BeforeClass // tüm teste önden 1 kere çalışır....

    @Before // her testten önce 1. kere çalışır

    @AfterClass // Tğm testen sonra 1. kere çalışır

    @After // her testen sonra 1 kere çalışır

     */

    @Test

    public void test01(){
        System.out.println("Test 01...");
    }

    @Test
    public void test02(){
        System.out.println("Test 02...");
    }

    @Test
    public void test03(){
        System.out.println("Test 03...");
    }

}
