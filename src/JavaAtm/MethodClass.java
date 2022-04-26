package JavaAtm;

import java.util.Scanner;

public class MethodClass extends  IslemMenusu{

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
        System.out.println("--------- Sıfre Degıstırme Menusune Hosgeldiniz----------");
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
        System.out.println("--------- Bakiye Kontrol Menusune Hosgeldiniz----------");
        System.out.println("Guncel bakiyeniz : " + hesapBakiyesi);
    }

    public static void paraYatırma(double yatirilanTutar) {

        System.out.println("--------- Para Yatırma Menusune Hosgeldiniz----------");
        System.out.println("Lütfen yatırmak istediğiniz tutarı giriniz");
        Scanner scan3 = new Scanner(System.in);
        yatirilanTutar = scan3.nextDouble();

        hesapBakiyesi += yatirilanTutar;
        System.out.println("Guncel Bakıyeniz : " + hesapBakiyesi);

    }

    public static void paracekme(double paraCekmeTutari) {

        System.out.println("--------- Para Cekme Menusune Hosgeldiniz----------");
        System.out.println("Lütfen çekmek istediğiniz tutarı giriniz");
        Scanner scan2 = new Scanner(System.in);
        paraCekmeTutari = scan2.nextDouble();

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
        System.out.println("--------- Para Gonderme Menusune Hosgeldiniz----------");
        System.out.println("Lütfen transfer etmek istediğiniz tutarı giriniz");
        Scanner scan1 = new Scanner(System.in);
        gonderilenTutar = scan1.nextDouble();
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
