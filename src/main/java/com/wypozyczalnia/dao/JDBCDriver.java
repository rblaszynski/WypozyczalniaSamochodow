package com.wypozyczalnia.dao;

import com.wypozyczalnia.model.Samochod;

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
            String url = "jdbc:mysql://localhost:3306/wypozyczalnia?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
            String username = "Robert";
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

    public List<Samochod> selectAll() {
        String query = "SELECT IdSamochodu, Marka, Model, Kolor, YEAR(STR_TO_DATE(RokProdukcji, \"%Y\")) as RokProdukcji, PojemnoscBaku, IdKlasy FROM Samochod";
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
                    samochod.setPojemnoscBaku(rs.getString("PojemnoscBaku"));
                    samochod.setIdKlasy(rs.getString("IdKlasy"));
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
        String OQuery = "insert into samochod(Marka,Model,Kolor,RokProdukcji,PojemnoscBaku,IdKlasy) " +
                "values ('" + car.getMarka() + "','" +
                car.getModel() + "','" +
                car.getKolor() + "','" +
                car.getRokProdukcji() + "','" +
                car.getPojemnoscBaku() + "','" +
                car.getIdKlasy() + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(OQuery);
        } catch (SQLException s) {
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
        }
    }

    public void deleteCar(String id) {
        String OQuery;
        OQuery = "delete from Samochod where IdSamochodu=" + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(OQuery);
        } catch (SQLException s) {
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
        }
    }

    public void updateCar(Samochod car) {
        String OQuery = "update samochod set " +
                "Marka = '" + car.getMarka() + "' , " +
                "Model = '" + car.getModel() + "' , " +
                "Kolor = '" + car.getKolor() + "' , " +
                "RokProdukcji = '" + car.getRokProdukcji() + "', " +
                "PojemnoscBaku = '" + car.getPojemnoscBaku() + "', " +
                "IdKlasy = '" + car.getIdKlasy() + "'" +
                " where samochod.IdSamochodu = '" + car.getId() + "'";

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