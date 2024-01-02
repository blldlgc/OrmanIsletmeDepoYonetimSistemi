abstract class Fiyatlandirma {
    private double birimFiyat;
    private double hacim;

    public Fiyatlandirma(double birimFiyat, double hacim) {
        this.birimFiyat = birimFiyat;
        this.hacim = hacim;
    }

    public Fiyatlandirma() {
        istifFiyatiniHesapla();

    }

    public double getBirimFiyat() {
        return birimFiyat;
    }

    public double getHacim() {
        return hacim;
    }

    public double istifFiyatiniHesapla() {
        return birimFiyat * hacim;
    }
}

class Mese extends Fiyatlandirma {
    public Mese(double hacim) {
        super(3053, hacim);
    }
}

class Cam extends Fiyatlandirma {
    public Cam(double hacim) {
        super(3260, hacim);
    }
}

class Ladin extends Fiyatlandirma {
    public Ladin(double hacim) {
        super(3509, hacim);
    }
}

class Kayin extends Fiyatlandirma {
    public Kayin(double hacim) {
        super(3333, hacim);
    }
}
