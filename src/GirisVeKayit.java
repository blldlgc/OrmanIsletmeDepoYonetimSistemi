import java.io.*;
import java.util.Scanner;

public class GirisVeKayit {

    private static String yetki;
    private int secim;
    private static final String DOSYA_YOLU = "kullanicilar.csv";

    public String GirisVeKayit() { //Kaydolmayı ve giriş yapmayı sağlar. Kullanıcı biligilerini alır.
        Scanner tarayici = new Scanner(System.in);

        while (true) {
            System.out.println("1 - Giriş Yap");
            System.out.println("2 - Yeni Kullanıcı Kaydı");
            System.out.println("3 - Çıkış");

            secim = tarayici.nextInt();
            tarayici.nextLine(); // Boş satırı oku

            if (secim == 1) {
                System.out.print("Kullanıcı adınızı girin: ");
                String kullaniciAdi = tarayici.nextLine();

                System.out.print("Şifrenizi girin: ");
                String sifre = tarayici.nextLine();

                if (girisYap(kullaniciAdi, sifre)) {
                    System.out.println("Giriş başarılı!");
                    break; // Doğru giriş yapıldı, döngüden çık
                } else {
                    System.out.println("Giriş başarısız. Kullanıcı adı veya şifre hatalı. Tekrar deneyin.");
                }
            } else if (secim == 2) {
                System.out.print("Yeni kullanıcı adınızı girin: ");
                String yeniKullaniciAdi = tarayici.nextLine();

                System.out.print("Yeni şifrenizi girin: ");
                String yeniSifre = tarayici.nextLine();

                kullaniciEkle(yeniKullaniciAdi, yeniSifre);
                System.out.println("Yeni kullanıcı başarıyla kaydedildi!");
            } else if (secim == 3) {
                System.out.println("Programdan çıkılıyor.");
                return null;
            } else {
                System.out.println("Geçersiz seçim. Tekrar deneyin.");
            }
        }
        return null;
    }
    public int getSecim(){
        return secim;
    }

    public static boolean girisYap(String kullaniciAdi, String sifre) { // Girilen bilgilerin kullanıcılar dosyasında olup olmadığını kontrol eder.
        try (BufferedReader okuyucu = new BufferedReader(new FileReader(DOSYA_YOLU))) {
            String satir;
            while ((satir = okuyucu.readLine()) != null) {
                String[] bolunmus = satir.split(",");
                yetki = bolunmus[2];
                if (bolunmus.length == 3 && bolunmus[0].equals(kullaniciAdi) && bolunmus[1].equals(sifre)) {
                    return true; // Kullanıcı adı ve şifre doğru
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false; // Kullanıcı adı veya şifre hatalı
    }

    public static String getYetki() {
        return yetki;
    }

    private static void kullaniciEkle(String kullaniciAdi, String sifre) { // Yeni kullanıcılara yetkilendirme sağlar.
        try (PrintWriter yazici = new PrintWriter(new FileWriter(DOSYA_YOLU, true))) {
            yazici.println(kullaniciAdi + "," + sifre + ",musteri");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
