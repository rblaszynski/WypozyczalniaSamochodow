package com.wypozyczalnia.model;

public class User {
    private long id;
    private String imie;
    private String nazwisko;
    private String dataUrodzenia;
    private String idAdres;
    private String nrTelefonu;

    public String getDataUrodzenia() {
        return dataUrodzenia;
    }

    public void setDataUrodzenia(String dataUrodzenia) {
        this.dataUrodzenia = dataUrodzenia;
    }

    public String getIdAdres() {
        return idAdres;
    }

    public void setIdAdres(String idAdres) {
        this.idAdres = idAdres;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }

    public User(){}

    public User(long id, String imie, String nazwisko, String dataUrodzenia, String idAdres, String nrTelefonu) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.dataUrodzenia = dataUrodzenia;
        this.idAdres = idAdres;
        this.nrTelefonu = nrTelefonu;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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


}
