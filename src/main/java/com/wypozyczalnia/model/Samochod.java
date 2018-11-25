package com.wypozyczalnia.model;

public class Samochod {
    private long id;
    private String marka;
    private String model;
    private String kolor;
    private int rokProdukcji;
    private double pojemnoscBaku;
    private String idKlasy;
    private float silnik;
    private double cenaWypozyczenia;
    private int aktualnyPrzebieg;

    public Samochod() {
    }

    public Samochod(long id, String marka, String model, String kolor, int rokProdukcji, double pojemnoscBaku, String idKlasy, float silnik, double cenaWypozyczenia, int aktualnyPrzebieg) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.kolor = kolor;
        this.rokProdukcji = rokProdukcji;
        this.pojemnoscBaku = pojemnoscBaku;
        this.idKlasy = idKlasy;
        this.silnik = silnik;
        this.cenaWypozyczenia = cenaWypozyczenia;
        this.aktualnyPrzebieg = aktualnyPrzebieg;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getKolor() {
        return kolor;
    }

    public void setKolor(String kolor) {
        this.kolor = kolor;
    }

    public int getRokProdukcji() {
        return rokProdukcji;
    }

    public void setRokProdukcji(int rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    public double getPojemnoscBaku() {
        return pojemnoscBaku;
    }

    public void setPojemnoscBaku(double pojemnoscBaku) {
        this.pojemnoscBaku = pojemnoscBaku;
    }

    public String getIdKlasy() {
        return idKlasy;
    }

    public void setIdKlasy(String idKlasy) {
        this.idKlasy = idKlasy;
    }

    public float getSilnik() {
        return silnik;
    }

    public void setSilnik(float silnik) {
        this.silnik = silnik;
    }

    public double getCenaWypozyczenia() {
        return cenaWypozyczenia;
    }

    public void setCenaWypozyczenia(double cenaWypozyczenia) {
        this.cenaWypozyczenia = cenaWypozyczenia;
    }

    public int getAktualnyPrzebieg() {
        return aktualnyPrzebieg;
    }

    public void setAktualnyPrzebieg(int aktualnyPrzebieg) {
        this.aktualnyPrzebieg = aktualnyPrzebieg;
    }
}
