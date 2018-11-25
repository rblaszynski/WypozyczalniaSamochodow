package com.wypozyczalnia.model;

import com.wypozyczalnia.dao.JDBCDriver;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Wypozyczenie {
    int idWypozyczenia;
    int idKlienta;
    int idSamochodu;
    int idrodzaj;
    int idPracownika;
    LocalDate dataWypozyczenia;
    LocalDate dataZwrotu;
    double koszt;
    int limitKilometrow;

    public Wypozyczenie() {
    }

    public Wypozyczenie(int idKlienta, int idSamochodu, int idrodzaj, LocalDate dataWypozyczenia, LocalDate dataZwrotu, int limitKilometrow) {
        this.idKlienta = idKlienta;
        this.idSamochodu = idSamochodu;
        this.idrodzaj = idrodzaj;
        this.dataWypozyczenia = dataWypozyczenia;
        this.dataZwrotu = dataZwrotu;
        this.limitKilometrow = limitKilometrow;
        this.idPracownika = 1;

        JDBCDriver jdbcDriver = new JDBCDriver();
        Samochod samochod = jdbcDriver.getCarById(String.valueOf(idSamochodu));
        long daysBetween = ChronoUnit.DAYS.between(dataWypozyczenia, dataZwrotu);
        this.koszt = daysBetween*samochod.getCenaWypozyczenia();
    }

    public int getIdWypozyczenia() {
        return idWypozyczenia;
    }

    public void setIdWypozyczenia(int idWypozyczenia) {
        this.idWypozyczenia = idWypozyczenia;
    }

    public int getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(int idKlienta) {
        this.idKlienta = idKlienta;
    }

    public int getIdSamochodu() {
        return idSamochodu;
    }

    public void setIdSamochodu(int idSamochodu) {
        this.idSamochodu = idSamochodu;
    }

    public int getIdrodzaj() {
        return idrodzaj;
    }

    public void setIdrodzaj(int idrodzaj) {
        this.idrodzaj = idrodzaj;
    }

    public int getIdPracownika() {
        return idPracownika;
    }

    public void setIdPracownika(int idPracownika) {
        this.idPracownika = idPracownika;
    }

    public LocalDate getDataWypozyczenia() {
        return dataWypozyczenia;
    }

    public void setDataWypozyczenia(LocalDate dataWypozyczenia) {
        this.dataWypozyczenia = dataWypozyczenia;
    }

    public LocalDate getDataZwrotu() {
        return dataZwrotu;
    }

    public void setDataZwrotu(LocalDate dataZwrotu) {
        this.dataZwrotu = dataZwrotu;
    }

    public double getKoszt() {
        return koszt;
    }

    public void setKoszt(double koszt) {
        this.koszt = koszt;
    }

    public int getLimitKilometrow() {
        return limitKilometrow;
    }

    public void setLimitKilometrow(int limitKilometrow) {
        this.limitKilometrow = limitKilometrow;
    }
}
