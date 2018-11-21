package com.wypozyczalnia.dao;

import com.wypozyczalnia.model.Samochod;
import com.wypozyczalnia.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;


public class JDBCDriver {
    private Connection connection = null;
    public static boolean found;

    public JDBCDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Wypozyczalnia_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String username = "root";
            String password = "password";

            System.out.println("Connecting database...");

            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
    }

    public List<Samochod> selectAllCars() {
        String query = "SELECT IdSamochodu, Marka, Model, Kolor, YEAR(STR_TO_DATE(RokProdukcji, \"%Y\")) as RokProdukcji, PojemnoscBaku, IdKlasy FROM samochody";
        List<Samochod> cars = new ArrayList<Samochod>();
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            if (!rs.isBeforeFirst()) {
                found = false;
            } else {
                found = true;
                while (rs.next()) {
                    Samochod samochod = new Samochod();
                    samochod.setId(Long.valueOf(rs.getString("IdSamochodu")));
                    samochod.setMarka(rs.getString("Marka"));
                    samochod.setModel(rs.getString("Model"));
                    samochod.setKolor(rs.getString("Kolor"));
                    samochod.setRokProdukcji(rs.getString("RokProdukcji"));
                    samochod.setPojemnoscBaku(Double.valueOf(rs.getString("PojemnoscBaku")));
                    samochod.setIdKlasy(rs.getString("IdKlasy"));
                    samochod.setSilnik(Float.valueOf(rs.getString("Silnik")));
                    samochod.setCenaWypozyczenia(Double.valueOf(rs.getString("CenaWypozyczenia")));
                    samochod.setAktualnyPrzebieg(Integer.valueOf(rs.getString("AktualnyPrzebieg")));
                    cars.add(samochod);
                }
                return cars;
            }
        } catch (SQLException s) {
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
        }
        return null;
    }

    public void insertCar(Samochod car) {
        String OQuery = "insert into samochody(Marka,Model,Kolor,RokProdukcji,PojemnoscBaku,IdKlasy,Silnik,CenaWypozyczenia,AktualnyPrzebieg) " +
                "values ('" + car.getMarka() + "','" +
                car.getModel() + "','" +
                car.getKolor() + "','" +
                car.getRokProdukcji() + "','" +
                car.getPojemnoscBaku() + "','" +
                car.getIdKlasy() + "','" +
                car.getSilnik() + "','" +
                car.getCenaWypozyczenia() + "','" +
                car.getAktualnyPrzebieg() + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(OQuery);
        } catch (SQLException s) {
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
        }
    }

    public void deleteCar(String id) {
        String OQuery;
        OQuery = "delete from samochody where IdSamochodu=" + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(OQuery);
        } catch (SQLException s) {
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
        }
    }

    public void updateCar(Samochod car) {
        String OQuery = "update samochody set " +
                "Marka = '" + car.getMarka() + "' , " +
                "Model = '" + car.getModel() + "' , " +
                "Kolor = '" + car.getKolor() + "' , " +
                "RokProdukcji = '" + car.getRokProdukcji() + "', " +
                "PojemnoscBaku = '" + car.getPojemnoscBaku() + "', " +
                "IdKlasy = '" + car.getIdKlasy() + "', " +
                "Silnik = '" + car.getSilnik() + "', " +
                "CenaWypozyczenia = '" + car.getCenaWypozyczenia() + "', " +
                "AktualnyPrzebieg = '" + car.getAktualnyPrzebieg() + "'" +
                " where samochody.IdSamochodu = '" + car.getId() + "'";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(OQuery);
        } catch (SQLException s) {
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
        }
    }

    //Methods for User
    public List<User> selectAllUsers() {
        String query = "SELECT IdOsoby, Imie, Nazwisko, DataUrodzenia, IdAdres, NrTelefonu FROM osoba";
        List<User> users = new ArrayList<User>();
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            if (!rs.isBeforeFirst()) {
                found = false;
            } else {
                found = true;
                while (rs.next()) {
                    User user = new User();
                    user.setId(Long.valueOf(rs.getString("IdOsoby")));
                    user.setImie(rs.getString("Imie"));
                    user.setNazwisko(rs.getString("Nazwisko"));
                    user.setDataUrodzenia(rs.getString("DataUrodzenia"));
                    user.setIdAdres(rs.getString("IdAdres"));
                    user.setNrTelefonu(rs.getString("NrTelefonu"));
                    users.add(user);
                }
                return users;
            }
        } catch (SQLException s) {
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
        }
        return null;
    }

    public void insertUser(User user) {
        String OQuery = "insert into osoba(Imie, Nazwisko, DataUrodzenia, IdAdres, NrTelefonu) " +
                "values ('" + user.getImie() + "','" +
                user.getNazwisko() + "','" +
                user.getDataUrodzenia() + "','" +
                user.getIdAdres() + "','" +
                user.getNrTelefonu() + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(OQuery);
        } catch (SQLException s) {
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
        }
    }

    public void deleteUser(String id) {
        String OQuery;
        OQuery = "delete from osoba where IdOsoby=" + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(OQuery);
        } catch (SQLException s) {
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
        }
    }

    public void updateUser(User user) {
        String OQuery = "update osoba set " +
                "Imie = '" + user.getImie() + "' , " +
                "Nazwisko = '" + user.getNazwisko() + "' , " +
                "DataUrodzenia = '" + user.getDataUrodzenia() + "' , " +
                "IdAdres = '" + user.getIdAdres() + "', " +
                "NrTelefonu = '" + user.getNrTelefonu() + "'" +
                " where osoba.IdOsoby = '" + user.getId() + "'";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(OQuery);
        } catch (SQLException s) {
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
        }
    }
    public Connection getConnection() {
        return connection;
    }

}