package Selcuk_Day_09_SwitchgWindiw_actionsClass;

import org.junit.Test;

import java.time.LocalTime;

public class Cc_saniye_kontrol {

    @Test
    public void test01(){
        // x sn bir sayaç yapalım ...

        int x = 3;
        LocalTime baslangic = LocalTime.now();
        int baslangicSaniye = baslangic.getSecond();
        int saniyeKontrol = 123; // rastgele bi sayı bu
        int bitisSaniyesi = baslangicSaniye + x >60 ? baslangicSaniye+x-60:baslangicSaniye+x;

        while (bitisSaniyesi != saniyeKontrol){
            saniyeKontrol = LocalTime.now().getSecond();
        }

        System.out.println("Başlangıç saniyesi...: "+baslangicSaniye);
        System.out.println("Saniye kontrol...: "+saniyeKontrol);
    }
}
