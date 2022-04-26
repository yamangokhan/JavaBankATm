package JavaAtm;

import java.util.Random;
import java.util.Scanner;

import static JavaAtm.IslemMenusu.*;

public class C01BilgiKontrolu {
    static int pin1;
    static int userPin;
    public static Scanner scan=new Scanner(System.in);
    static String iban1;
    static char secim;
    public static void atm() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Kartsiz islem icin 0\nKartli islem icin 1");
        kartSecimi = 0;
        try {
            kartSecimi= scan.nextInt();
        } catch (Exception e) {
            System.out.println("Lutfen 0 veya 1 giriniz");
            atm();
        }if (kartSecimi==0){
            kartsizIslem();
        }else if (kartSecimi==1){
            kartliIslem();
        }else {
            System.out.println("Hatali giris lutfen 0 veya 1 secin");
            atm();
        }
    }

    public static void kartliIslem() {
        System.out.println("-----Kartli islem bolumune hosgeldiniz-----");
        if (ibanVeSifreKontrol()){
            menuSecimi();
        }else {
            System.out.println("Yanlis denemelerden dolayi hesabiniz bloke edilmistir!");
        }
    }

    public static boolean ibanVeSifreKontrol() {
        boolean dogruMu=false;
        Scanner scan = new Scanner(System.in);
        System.out.println("Lutfen kart numaranizi giriniz");
        String kartNumarasi = scan.nextLine();

        System.out.println("Lutfen kart parolanizi girin");
        String kartParola = scan.nextLine();
        if ((kartNumarasi+kartParola).equals(dogruKartNo+dogruSifre)){
            dogruMu=true;
        }else{
            for (int i = 0; i < 2; i++) {
                if (!(kartNumarasi+kartParola).equals(dogruKartNo+dogruSifre)) {
                    System.out.println("Hesabinizi dogrulayamadik... ");
                }else{
                    dogruMu=true;
                    break;
                }
            }

        }return dogruMu;
    }

    public static void kartsizIslem() {
        System.out.println("------Kartsiz islem bolumune hosgeldiniz-----");
        if (pinKontrol()){
            menuSecimi();
        }else{
            System.out.println("Yanlis denemelerden dolayi hesabiniz bloke edilmistir!");

        }
    }

    public static boolean pinKontrol() {
        boolean dogruMu = false;
        if (pinOlustur()==2*pin1){
            dogruMu = true;
        }else {
            for (int i = 0; i < 2; i++) {
                if (pinOlustur()!=2*pin1){
                    System.out.println("Hesabinizi dogrulayamadik...");
                }else {
                    dogruMu = true;
                    break;
                }

            }
        }return dogruMu;
    }

    public static int pinOlustur() {
        Random rnd = new Random();
         pin1=rnd.nextInt(1000);
        System.out.println("Hesabinizi dogrulamak icin olusturulan pin kodu: "+pin1+" B0123");
        System.out.println("Dogrulamak icin lutfen yukaridaki pin kodunu yaziniz");
         userPin = rnd.nextInt();
        return userPin+pin1;
    }
}
