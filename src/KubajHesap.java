public class KubajHesap extends SevkGirme{
    public double KubajHesap(double cap , double boy, double adet){ //Kabuksuz tomruk hacmi hesaplar.
        double r = cap / 2;
        double hacim = adet * r * Math.PI * r * boy;
        return hacim;
    }
    public double KubajHesap(double cap , double kabuk , double boy, double adet){ //Kabuklu tomruk hacmi hesaplar.
        double r = cap / 2;
        r = r - kabuk;
        double hacim = adet * Math.PI * r * r *boy;
        return hacim;
    }

}
