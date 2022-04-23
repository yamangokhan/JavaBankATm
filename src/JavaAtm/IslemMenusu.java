package JavaAtm;


import java.util.Scanner;

public class IslemMenusu {
    static String dogruSifre = "0000";
    static String dogruKartNo = "TR1122334455667788";
    static double hesapBakiyesi = 955000;
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
    }
}





