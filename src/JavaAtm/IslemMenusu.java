package JavaAtm;


import java.util.Scanner;

public class IslemMenusu {
    static String dogruSifre = "0000";
    static String dogruKartNo = "TR1122334455667788";
    static double hesapBakiyesi = 999000;
    static double miktar;
    static int kartSecimi;

    public static void menuSecimi() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Lütfen listeden ne yapmak istediğinizi seçin");
        System.out.println("1-Para Gönder\n2-Para Çekin\n3-Para Yatırın" + "\n4-Hesap bakiyenizi kontrol edin\n5-Çıkış");
        int kartSecimi = scan.nextInt();
        double gonderilenTutar = 0;
        double paraCekmeTutari = 0;
        double yatirilanTutar = 0;
        String yanlisSecim = "";

        switch (kartSecimi) {
            case 1:
                System.out.println("Lütfen transfer etmek istediğiniz tutarı giriniz");
                Scanner scan1 = new Scanner(System.in);
                gonderilenTutar = scan1.nextDouble();

                break;
            case 2:
                System.out.println("Lütfen çekmek istediğiniz tutarı giriniz");
                Scanner scan2 = new Scanner(System.in);
                paraCekmeTutari = scan2.nextDouble();

                break;
            case 3:
                System.out.println("Lütfen yatırmak istediğiniz tutarı giriniz");
                Scanner scan3 = new Scanner(System.in);
                yatirilanTutar = scan3.nextDouble();

                break;
            case 4:

                break;
            case 5:
                System.out.println("Tesekkurler yine bekleriz");
                break;
            default:
                System.out.println("Hatali giris");
                System.out.println("Tekrar denemek ister misiniz? \nE/H?");
                Scanner scan4 = new Scanner(System.in);
                yanlisSecim = scan4.next();
                if (yanlisSecim.equalsIgnoreCase("E")) {
                    menuSecimi();
                } else if (yanlisSecim.equalsIgnoreCase("H")) {
                    System.out.println("Iyi gunler...");
                } else {
                    System.out.println("Yanlis secim");
                    System.out.println("Iyi gunler");
                }
        }
    }
}





