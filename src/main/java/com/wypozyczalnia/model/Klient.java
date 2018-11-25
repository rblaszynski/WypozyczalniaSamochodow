package com.wypozyczalnia.model;

public class Klient extends User {
    private long idKlienta;
    private long idPrawoJazdy;
    private String nrDowodu;

    public Klient(long idKlienta, long idPrawoJazdy, String nrDowodu) {
        this.idKlienta = idKlienta;
        this.idPrawoJazdy = idPrawoJazdy;
        this.nrDowodu = nrDowodu;
    }

    public Klient(long id, String imie, String nazwisko, String dataUrodzenia, String idAdres, String nrTelefonu, long idKlienta, long idPrawoJazdy, String nrDowodu) {
        super(id, imie, nazwisko, dataUrodzenia, idAdres, nrTelefonu);
        this.idKlienta = idKlienta;
        this.idPrawoJazdy = idPrawoJazdy;
        this.nrDowodu = nrDowodu;
    }

    public long getIdKlienta() {
        return idKlienta;
    }

    public void setIdKlienta(long idKlienta) {
        this.idKlienta = idKlienta;
    }

    public long getIdPrawoJazdy() {
        return idPrawoJazdy;
    }

    public void setIdPrawoJazdy(long idPrawoJazdy) {
        this.idPrawoJazdy = idPrawoJazdy;
    }

    public String getNrDowodu() {
        return nrDowodu;
    }

    public void setNrDowodu(String nrDowodu) {
        this.nrDowodu = nrDowodu;
    }
}
