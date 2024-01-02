import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class AgacSayaci {
    public void AgacSayaci(){ // Hangi ağaç istifinin sorgulanacağı bilgisi kullanıcıdan alınır.
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("\nHangi ağaç türünü sorgulamak istiyorsunuz:");
            System.out.println("1:Çam 2:Meşe 3:Kayın 4:Ladin 0:İptal");
            System.out.print("Seçim: ");
            int secim = scanner.nextInt();

            if (secim == 0) {
                System.out.println("Ana menüye dönülüyor...");
                break;
            }

            switch (secim){
                case 1:
                    okumaCam();
                    break;
                case 2:
                    okumaMese();
                    break;
                case 3:
                    okumaKayin();
                    break;
                case 4:
                    okumaLadin();
                    break;
            }

        }

    }
    public void okumaCam() { //Çam dosyasından kaç adet istif olduğu sorgulanır.
        String csvDosyaYolu = "cam.csv";
        try (BufferedReader br = new BufferedReader(new FileReader(csvDosyaYolu))) {
            int satirSayisi = 0;
            while ((br.readLine()) != null) {
                satirSayisi++;
            }
            System.out.println("Depodaki ÇAM istifi sayısı: " + satirSayisi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void okumaMese() { //Meşe dosyasından kaç adet istif olduğu sorgulanır.
        String csvDosyaYolu = "mese.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvDosyaYolu))) {
            int satirSayisi = 0;
            while ((br.readLine()) != null) {
                satirSayisi++;
            }
            System.out.println("Depodaki MEŞE istifi sayısı: " + satirSayisi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }public void okumaKayin() { //Kayın dosyasından kaç adet istif olduğu sorgulanır.
        String csvDosyaYolu = "kayin.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvDosyaYolu))) {
            int satirSayisi = 0;
            while ((br.readLine()) != null) {
                satirSayisi++;
            }
            System.out.println("Depodaki KAYIN istifi sayısı: " + satirSayisi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }public void okumaLadin() { //Ladin dosyasından kaç adet istif olduğu sorgulanır.
        String csvDosyaYolu = "ladin.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(csvDosyaYolu))) {
            int satirSayisi = 0;
            while ((br.readLine()) != null) {
                satirSayisi++;
            }
            System.out.println("Depodaki LADİN istifi sayısı: " + satirSayisi);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


