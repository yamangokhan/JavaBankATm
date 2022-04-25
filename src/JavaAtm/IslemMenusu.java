package JavaAtm;


import java.util.Locale;
import java.util.Scanner;

public class IslemMenusu {
    static String dogruSifre = "0000";
    static String dogruKartNo = "TR1122334455667788";
    static double hesapBakiyesi = 999000;
    static double miktar;
    static int kartSecimi;
    static String Iban;

    public static void menuSecimi() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Lütfen listeden ne yapmak istediğinizi seçin");
        System.out.println("1-Para Gönder\n2-Para Çekin\n3-Para Yatırın \n4-Hesap bakiyenizi kontrol edin \n5-Sıfre Degıstır \n6-Çıkış");
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
                paraGonder(hesapBakiyesi, gonderilenTutar);
                baskaBırIslemYapmakIstermsınız();

                break;
            case 2:
                System.out.println("--------- Para Cekme Menusune Hosgeldiniz----------");
                System.out.println("Lütfen çekmek istediğiniz tutarı giriniz");
                Scanner scan2 = new Scanner(System.in);
                paraCekmeTutari = scan2.nextDouble();
                paracekme(paraCekmeTutari, hesapBakiyesi);
                baskaBırIslemYapmakIstermsınız();

                break;
            case 3:
                System.out.println("--------- Para Yatırma Menusune Hosgeldiniz----------");
                System.out.println("Lütfen yatırmak istediğiniz tutarı giriniz");
                Scanner scan3 = new Scanner(System.in);
                yatirilanTutar = scan3.nextDouble();
                paraYatırma(yatirilanTutar, hesapBakiyesi);
                baskaBırIslemYapmakIstermsınız();

                break;
            case 4:
                System.out.println("--------- Bakiye Kontrol Menusune Hosgeldiniz----------");
                bakiyeSorgulama(hesapBakiyesi);
                baskaBırIslemYapmakIstermsınız();

                break;

            case 5:
                System.out.println("--------- Sıfre Degıstırme Menusune Hosgeldiniz----------");
                sıfredegıstır(dogruSifre, dogruKartNo);
                baskaBırIslemYapmakIstermsınız();
                break;
            case 6:
                cıkıs();
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

    public static void gırıs(String dogruKartNo, String dogruSifre) {
        Scanner scan = new Scanner(System.in);
        System.out.println("------------Bankamıza Hosgeldiniz-----------");
        System.out.println("Lutfen kart numaranızı gırınız");
        String girilenKartNumarası=scan.nextLine().replaceAll(" ", "");

        System.out.println("Lutfen sıfrenızı gırınız");
        String guncelSıfre= scan.next();

        if (girilenKartNumarası.equals(dogruKartNo) && guncelSıfre.equals(dogruSifre)){
            menuSecimi();
        }else{
            System.out.println("lutfen adam gibi giris yap");
        }

    }



    public static void sıfredegıstır(String dogruSifre, String dogruKartNo) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Once kart numarasınızı gırınız");
        String girilenKartNo = scan.nextLine().replaceAll(" ", ""); // kart numarasındaki tum boslukları hıclıge cevirerek yok ettık.

        System.out.println("Lutfen guncel sıfrenızı gırınız");
        String girilenSıfre = scan.next();

        if (girilenSıfre.equals(dogruSifre) && girilenKartNo.equals(dogruKartNo)) {
            System.out.println("Lutfen yeni sıfrenızı giriniz");

            IslemMenusu.dogruSifre = scan.next().replaceAll(" ", ""); // sifredeki tum boslukları hıclıge cevirerek yok ettık.
            System.out.println("Sıfrenız " + dogruSifre + " olarak guncellenmiştir");
        } else {
            System.out.println("Yanlıs gırıs yaptınız, lutfen bilgilerinizi kontrol ediniz");
        }
    }


    public static void bakiyeSorgulama(double hesapBakiyesi) {
        System.out.println("Guncel bakiyeniz : " + hesapBakiyesi);
    }

    public static void paraYatırma(double yatirilanTutar, double hesapBakiyesi) {
        if (yatirilanTutar >= 0) {
            hesapBakiyesi += yatirilanTutar;
            System.out.println("Guncel Bakıyeniz : " + hesapBakiyesi);
        } else System.out.println("Lutfn geverli bir tutar giriniz");

    }

    public static void paracekme(double paraCekmeTutari, double hesapBakiyesi) {

        if (paraCekmeTutari <= hesapBakiyesi) {
            hesapBakiyesi -= paraCekmeTutari;
            System.out.println("Guncel Bakiyeniz : " + hesapBakiyesi);

        } else {
            System.out.println("Yeterli bakiyeniz mevcut degıldır");

        }
    }


    public static void cıkıs() {
        System.out.println("Bizi sectıgınız ıcın tesekkurler yine bekleriz");
    }

    public static void baskaBırIslemYapmakIstermsınız() {
        System.out.println("Baska bir ıslem yapmak ıstiyor musunuz? ");
        System.out.println("Evet ıcın 1; \nHayır ıcın 2;\ntuslayınız ");
        Scanner scan = new Scanner(System.in);
        int secim = scan.nextInt();
        if (secim == 1) {
            menuSecimi();
        } else {
            cıkıs();
        }

    }



    public static void paraGonder(double hesapBakiyesi, double gonderilenTutar) {

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





