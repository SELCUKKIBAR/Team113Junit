package Practic_13_Mayis;

import org.junit.*;

public class C02 {

    @BeforeClass
    public static void beforeClass(){
        System.out.println("Befor Class Çalıştı");
    }

    @AfterClass
    public static void afterClass(){
        System.out.println("After Class Çalıştı");
    }

    @Before
    public void before(){
        System.out.println("Before Çalıştı");
    }

    @After
    public void after(){
        System.out.println("After çalıştı");
        System.out.println("=======================================");
    }

    @Test
    public void test01(){
        System.out.println("Test Case 01 Çalıştırıldı.....");
    }

    @Test
    public void test02(){
        System.out.println("Test Case 02 Çalıştırıldı.....");
    }

    @Test
    public void test03(){
        System.out.println("Test Case 03 Çalıştırıldı.....");
    }

}
