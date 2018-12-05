package com.wypozyczalnia.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RaportSamochodu {
    String dataWypozyczenia;
    String  dataZwrotu;
    double koszt;
    String imie;
    String nazwisko;

    public String  getDataWypozyczenia() {
        return dataWypozyczenia;
    }

    public void setDataWypozyczenia(String  dataWypozyczenia) {
        LocalDate localDate = LocalDate.parse(dataWypozyczenia);
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dataWypozyczenia = localDate.format(formatters);
    }

    public String  getDataZwrotu() {
        return dataZwrotu;
    }

    public void setDataZwrotu(String  dataZwrotu) {
        LocalDate localDate = LocalDate.parse(dataZwrotu);
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dataZwrotu = localDate.format(formatters);
    }

    public double getKoszt() {
        return koszt;
    }

    public void setKoszt(double koszt) {
        this.koszt = koszt;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public RaportSamochodu() {
    }

    public RaportSamochodu(String  dataWypozyczenia, String  dataZwrotu, double koszt, String imie, String nazwisko) {
        this.dataWypozyczenia = dataWypozyczenia;
        this.dataZwrotu = dataZwrotu;
        this.koszt = koszt;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
}
