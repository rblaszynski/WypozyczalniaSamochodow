package com.wypozyczalnia.model;

public class Samochod {
    private long id;
    private String marka;
    private String model;
    private String kolor;
    private String rokProdukcji;
    private String pojemnoscBaku;
    private String idKlasy;

    public Samochod() {
    }

    public Samochod(long id, String marka, String model, String kolor, String rokProdukcji, String pojemnoscBaku, String idKlasy) {
        this.id = id;
        this.marka = marka;
        this.model = model;
        this.kolor = kolor;
        this.rokProdukcji = rokProdukcji;
        this.pojemnoscBaku = pojemnoscBaku;
        this.idKlasy = idKlasy;
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

    public String getRokProdukcji() {
        return rokProdukcji;
    }

    public void setRokProdukcji(String rokProdukcji) {
        this.rokProdukcji = rokProdukcji;
    }

    public String getPojemnoscBaku() {
        return pojemnoscBaku;
    }

    public void setPojemnoscBaku(String pojemnoscBaku) {
        this.pojemnoscBaku = pojemnoscBaku;
    }

    public String getIdKlasy() {
        return idKlasy;
    }

    public void setIdKlasy(String idKlasy) {
        this.idKlasy = idKlasy;
    }
}
