package com.wypozyczalnia.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class RaportUzytkownika {
    String dataWypozyczenia;
    String dataZwrotu;
    double koszt;
    String marka;
    String model;

    public RaportUzytkownika() {
    }

    public String getDataWypozyczenia() {
        return dataWypozyczenia;
    }

    public void setDataWypozyczenia(String  dataWypozyczenia) {
        LocalDate localDate = LocalDate.parse(dataWypozyczenia);
        DateTimeFormatter formatters = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.dataWypozyczenia = localDate.format(formatters);
    }

    public String getDataZwrotu() {
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

    public RaportUzytkownika(String  dataWypozyczenia, String  dataZwrotu, double koszt, String marka, String model) {
        this.dataWypozyczenia = dataWypozyczenia;
        this.dataZwrotu = dataZwrotu;
        this.koszt = koszt;
        this.marka = marka;
        this.model = model;
    }
}
