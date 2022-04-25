/* package JavaAtm;

public class SecımMenusu {
import java.util.Random;
import java.util.Scanner;
import static javaBankATM.C04_SecimMenusu.*;
    public class C03_Islemler {
        static int pin1;
        static int userPin;
        public static Scanner scan = new Scanner(System.in);
        static String iban1;
        static char secim;
        public static void paraGonderme(double gonderilenTutar) {
            System.out.println("Mevcut bakiyeniz: " + hesapBakiyesi + " $");
            if (gonderilenTutar <= hesapBakiyesi) {
                iban1 = ibanAl();
                if (iban1.startsWith("TR") && iban1.length() == 26) {
                    hesapBakiyesi -= gonderilenTutar;
                    System.out.println(gonderilenTutar + " $ " + iban1 + " nolu ibana basariyla gonderildi");
                    System.out.println("Hesabinizin kalan bakiyesi: " + hesapBakiyesi);
                } else {
                    System.out.println("Hatali iban numarasi");
                    menuSecimi();
                }
            } else {
                System.out.println("Bakiyenizden daha yuksek miktar gonderimi yapamazsiniz");
                menuSecimi();
            }
            System.out.println("Başka bir işlem yapmak ister misiniz? / E / H");
            Scanner scan = new Scanner(System.in);
            secim = scan.next().toUpperCase().charAt(0);
            if (secim == 'E') {
                menuSecimi();
            } else if (secim == 'H') {
                System.out.println("Iyi gunler..");
            } else {
                menuSecimi();
            }
        }
        public static void paraCekme(double paraCekmeTutari) {
            System.out.println("Mevcut bakiyeniz: " + hesapBakiyesi + " $");
            if (paraCekmeTutari <= hesapBakiyesi) {
                hesapBakiyesi -= paraCekmeTutari;
                System.out.println(paraCekmeTutari + " $ basariyla cekilmistir");
                System.out.println("Hesabiniz kalan bakiyesi: " + hesapBakiyesi);
            } else if (paraCekmeTutari > hesapBakiyesi) {
                System.out.println("Mevcut bakiyenizden daha yuksek miktar cekemezsiniz ");
                menuSecimi();
            }
            System.out.println("Başka bir işlem yapmak ister misiniz? / E / H");
            Scanner scan = new Scanner(System.in);
            secim = scan.next().toUpperCase().charAt(0);
            if (secim == 'E') {
                menuSecimi();
            } else if (secim == 'H') {
                System.out.println("Iyi gunler..");
            } else {
                menuSecimi();
            }
        }
        public static void paraYatirma(double yatirilanTutar) {
            hesapBakiyesi += yatirilanTutar;
            System.out.println("Mevcut bakiyeniz: " + hesapBakiyesi + " $");
            System.out.println("Başka bir işlem yapmak ister misiniz? / E / H");
            Scanner scan = new Scanner(System.in);
            secim = scan.next().toUpperCase().charAt(0);
            if (secim == 'E') {
                menuSecimi();
            } else if (secim == 'H') {
                System.out.println("Iyi gunler..");
            } else {
                menuSecimi();
            }
        }
        public static void bakiyeKontrol() {
            System.out.println("Mevcut bakiyeniz: " + hesapBakiyesi + " $");
            System.out.println("Başka bir işlem yapmak ister misiniz? / E / H");
            Scanner scan = new Scanner(System.in);
            secim = scan.next().toUpperCase().charAt(0);
            if (secim == 'E') {
                menuSecimi();
            } else if (secim == 'H') {
                System.out.println("Iyi gunler..");
            } else {
                menuSecimi();
            }
        }
        public static int pinOlustur() {
            Random rnd = new Random();
            pin1 = rnd.nextInt(1000);
            System.out.println("Hesabinizi dogrulamak icin olusturulan pin kodu " + pin1 + " B0123");
            System.out.println("Doğrulamak için lütfen yukarıdaki pin kodunu yazın");
            userPin = scan.nextInt();
            return userPin + pin1;
        }//215+215=430
        public static boolean pinKontrol() {
            boolean dogruMu = false;
            if (pinOlustur() == 2 * pin1) {
                dogruMu = true;
            } else {
                for (int i = 0; i < 2; i++) {
                    if (pinOlustur() != 2 * pin1) {
                        System.out.println("Hesabınızı doğrulayamadık...");
                    } else {
                        dogruMu = true;
                        break;
                    }
                }
            }
            return dogruMu;
        }
        public static String ibanAl() {
            System.out.println("Lütfen para transferi yapacağınız IBAN'ı giriniz");
            System.out.println("TR ile başlamalı...");
            Scanner scan = new Scanner(System.in);
            String iban = scan.nextLine();
            return iban;
        }
        public static boolean ibanVeSifreKontrol() {
            boolean dogruMu = false;
            Scanner scan = new Scanner(System.in);
            System.out.println("Lütfen kart numaranızı giriniz");
            String kartNumarasi = scan.nextLine();
            System.out.println("Lütfen kart parolanizi giriniz");
            String kartParola = scan.nextLine();
            if ((kartNumarasi + kartParola).equals(dogruKartNo + dogruSifre)) {
                dogruMu = true;
            } else {
                for (int i = 0; i < 2; i++) {
                    if (!(kartNumarasi + kartParola).equals(dogruKartNo + dogruSifre)) {
                        System.out.println("Hesabınızı doğrulayamadık...");
                    } else {
                        dogruMu = true;
                        break;
                    }
                }
            }
            return dogruMu;
        }

    }
*/