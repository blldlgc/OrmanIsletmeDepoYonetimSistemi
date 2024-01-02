import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public interface TomrukIslem {



// TomrukIslem arayüzü

    void okumaTomruk(String dosyaAdi);


// Istifleme sınıfı, TomrukIslem arayüzünü uygular
public class Istifleme implements TomrukIslem {

    @Override
    public void okumaTomruk(String dosyaAdi) {
        // Dosya adını ve istenen sınırları tanımlayan kod
        double[] sinirlar = {0, 10, 14, 21};

        // Sınıfları tanımlayan kod
        String[] siniflar = {"0-10 yakmalık", "10-14 suntalık", "14-20 maden ocakları ", "21 ve üzeri tomruk"};

        // Sınıf sayıları için bir dizi oluştur
        int[] sinifSayilari = new int[siniflar.length];

        try (BufferedReader br = new BufferedReader(new FileReader(dosyaAdi))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Satırdaki çap bilgisini ve diğer bilgileri al
                String[] parts = line.split(",");
                double cap = Double.parseDouble(parts[1]) * 100; // Çapı 100 ile çarp

                // Hangi sınıfa ait olduğunu bul
                int i;
                for (i = 0; i < sinirlar.length; i++) {
                    if (cap < sinirlar[i]) {
                        break;
                    }
                }
                String sinif = (i == sinirlar.length) ? siniflar[i - 1] : siniflar[i];

                // İlgili sınıfın sayısını artır
                sinifSayilari[i - 1]++;
            }

            // Sonuçları yazdır
            for (int i = 0; i < siniflar.length; i++) {
                System.out.println(siniflar[i] + ": " + sinifSayilari[i] + " tane");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void yazdirTomruk(){

    }


}
}
