package JavaAtm;

import java.util.Scanner;

import static JavaAtm.MethodClass.*;

public class IslemMenusu {

        static String dogruSifre = "0000";
        static String dogruKartNo = "TR1122334455667788";
        static double hesapBakiyesi = 10000;
        static String Iban;
        public static void menuSecimi() {
            Scanner scan = new Scanner(System.in);
            System.out.println("===================JAVABANK'A HOSGELDINIZ==================");
            System.out.println("========================== İŞLEMLER =======================\r\n"
                    + "   ____________________              ____________________   \n"
                    + "   | 1-PARA GONDER    |              |  2-PARA CEK      |   \n"
                    + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯              ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯   \n"
                    + "   ____________________              ____________________   \n"
                    + "   | 3-PARA YATIR     |              |  4-BAKIYE KONTROL|   \n"
                    + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯              ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯   \n"
                    + "   ____________________              ____________________   \n"
                    + "   | 5-SIFRE DEGISTIR |              |  6-CIKIS         |   \n"
                    + "   ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯              ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯  ");
            System.out.println("===========================================================");
            int kartSecimi = scan.nextInt();
            double gonderilenTutar = 0;
            double paraCekmeTutari = 0;
            double yatirilanTutar = 0;
            String yanlisSecim = "";
            switch (kartSecimi) {

                case 1:

                    paraGonder(gonderilenTutar);
                    baskaBirIslemYapmakIstermsiniz();
                    break;
                case 2:

                    paracekme(paraCekmeTutari);
                    baskaBirIslemYapmakIstermsiniz();
                    break;
                case 3:

                    paraYatırma(yatirilanTutar);
                    baskaBirIslemYapmakIstermsiniz();
                    break;
                case 4:

                    bakiyeSorgulama();
                    baskaBirIslemYapmakIstermsiniz();
                    break;
                case 5:

                    sifredegistir();
                    baskaBirIslemYapmakIstermsiniz();
                    break;
                case 6:

                    cikis();
                    break;

                default:
                    System.out.println("Hatali giris");
                    System.out.println("Tekrar denemek ister misiniz? \n E/H?");
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



