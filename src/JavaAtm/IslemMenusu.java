package JavaAtm;


import java.util.Scanner;

public class IslemMenusu {
    static String dogruSifre = "0000";
    static String dogruKartNo = "TR1122334455667788";
    static double hesapBakiyesi = 10000;
    static double miktar;
    static int kartSecimi;
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
        int kartSecimi = scan.nextInt();
        double gonderilenTutar = 0;
        double paraCekmeTutari = 0;
        double yatirilanTutar = 0;
        String yanlisSecim = "";

        switch (kartSecimi) {
            case 1:
                System.out.println("--------- Para Gonderme Menusune Hosgeldiniz----------");
                System.out.println("Lütfen transfer etmek istediğiniz tutarı giriniz");
                Scanner scan1 = new Scanner(System.in);
                gonderilenTutar = scan1.nextDouble();
                paraGonder(gonderilenTutar);
                baskaBirIslemYapmakIstermsiniz();

                break;
            case 2:
                System.out.println("--------- Para Cekme Menusune Hosgeldiniz----------");
                System.out.println("Lütfen çekmek istediğiniz tutarı giriniz");
                Scanner scan2 = new Scanner(System.in);
                paraCekmeTutari = scan2.nextDouble();
                paracekme(paraCekmeTutari);
                baskaBirIslemYapmakIstermsiniz();

                break;
            case 3:
                System.out.println("--------- Para Yatırma Menusune Hosgeldiniz----------");
                System.out.println("Lütfen yatırmak istediğiniz tutarı giriniz");
                Scanner scan3 = new Scanner(System.in);
                yatirilanTutar = scan3.nextDouble();
                paraYatırma(yatirilanTutar);
                baskaBirIslemYapmakIstermsiniz();

                break;
            case 4:
                System.out.println("--------- Bakiye Kontrol Menusune Hosgeldiniz----------");
                bakiyeSorgulama();
                baskaBirIslemYapmakIstermsiniz();

                break;

            case 5:
                System.out.println("--------- Sıfre Degıstırme Menusune Hosgeldiniz----------");
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

    public static void giris() {
        Scanner scan = new Scanner(System.in);
        System.out.println("------------Bankamıza Hosgeldiniz-----------");
        System.out.println("Lutfen kart numaranızı gırınız");
        String girilenKartNumarasi=scan.nextLine().replaceAll(" ", "");

        System.out.println("Lutfen sıfrenızı gırınız");
        String guncelSifre= scan.next();

        if (girilenKartNumarasi.equals(dogruKartNo) && guncelSifre.equals(dogruSifre)){
            menuSecimi();
        }else{
            System.out.println("lutfen adam gibi giris yap");
        }

    }



    public static void sifredegistir() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Once kart numarasınızı gırınız");
        String girilenKartNo = scan.nextLine().replaceAll(" ", ""); // kart numarasındaki tum boslukları hıclıge cevirerek yok ettık.

        System.out.println("Lutfen guncel sıfrenızı gırınız");
        String girilenSifre = scan.next();

        if (girilenSifre.equals(dogruSifre) && girilenKartNo.equals(dogruKartNo)) {
            System.out.println("Lutfen yeni sıfrenızı giriniz");

            dogruSifre = scan.next().replaceAll(" ", ""); // sifredeki tum boslukları hıclıge cevirerek yok ettık.
            System.out.println("Sıfrenız " + dogruSifre + " olarak guncellenmiştir");
        } else {
            System.out.println("Yanlıs gırıs yaptınız, lutfen bilgilerinizi kontrol ediniz");
        }
    }


    public static void bakiyeSorgulama() {
        System.out.println("Guncel bakiyeniz : " + hesapBakiyesi);
    }

    public static void paraYatırma(double yatirilanTutar) {

            hesapBakiyesi += yatirilanTutar;
            System.out.println("Guncel Bakıyeniz : " + hesapBakiyesi);

    }

    public static void paracekme(double paraCekmeTutari) {

        if (paraCekmeTutari <= hesapBakiyesi) {
            hesapBakiyesi -= paraCekmeTutari;
            System.out.println("Guncel Bakiyeniz : " + hesapBakiyesi);

        } else {
            System.out.println("Yeterli bakiyeniz mevcut degıldır");

        }
    }


    public static void cikis() {
        System.out.println("Bizi sectıgınız ıcın tesekkurler yine bekleriz");
    }

    public static void baskaBirIslemYapmakIstermsiniz() {
        System.out.println("Baska bir ıslem yapmak ıstiyor musunuz? ");
        System.out.println("Evet ıcın 1; \nHayır ıcın 2;\ntuslayınız ");
        Scanner scan = new Scanner(System.in);
        int secim = scan.nextInt();
        if (secim == 1) {
            menuSecimi();
        } else {
            cikis();
        }

    }



    public static void paraGonder(double gonderilenTutar) {

        System.out.println("Guncel bakiyeniz : " + hesapBakiyesi);
        if (gonderilenTutar <= hesapBakiyesi) { // gonderilen miktar hesap bakiyesinden kucuk olursa calıssın
            System.out.println("Gondermek ıstedginiz 26 haneli IBAN Numarasını yazınız");
            Scanner scan = new Scanner(System.in);
            Iban = scan.next();
            if (Iban.length() == 26 && Iban.toUpperCase().startsWith("TR")) {
                System.out.println(gonderilenTutar + " $ " + Iban + " nolu ibana basariyla gonderildi");
                hesapBakiyesi -= gonderilenTutar;
                System.out.println("Guncel bakiyeniz : " + hesapBakiyesi);
            } else {
                System.out.println("Yanlıs bır IBAN Numarası girdiniz");
            }

        } else {
            System.out.println("Bakiyenizden daha fazla miktarda para gönderemezsiniz");
        }
    }


}





