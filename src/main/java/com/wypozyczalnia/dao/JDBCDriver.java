package com.wypozyczalnia.dao;

import com.mongodb.*;
import com.wypozyczalnia.model.*;
import org.json.JSONArray;
import org.json.JSONObject;

import static com.wypozyczalnia.controller.CarServiceRestEndpoint.cars;

import java.sql.*;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;


public class JDBCDriver {
    private Connection connection = null;
    public static boolean found;
    DBCollection collection = null;

    private void insertErrorToMongo(SQLException s) {
        DBObject object = new BasicDBObject();
        object.put("date", new java.util.Date());
        object.put("sqlState", s.getSQLState());
        object.put("errorCode", s.getErrorCode());
        object.put("description", s.toString());
        collection.insert(object);
    }

    public JDBCDriver() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String connectionUrl =
                    "jdbc:sqlserver://localhost\\DESKTOP-KRGL5CF:1433;"
                            + "database=wypozyczalnia;"
                            + "user=user;"
                            + "password=1234;";


            String url = "jdbc:sqlserver://localhost\\DESKTOP-KRGL5CF:1433;database=wypozyczalnia";
            String username = "Robert";
            String password = "password";

            MongoClient mongoClient = new MongoClient();
            DB database = mongoClient.getDB("wypozyczalnia");
            collection = database.getCollection("wypozyczalniaErrors");

            System.out.println("Connecting database...");

            connection = DriverManager.getConnection(connectionUrl);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        } catch (Exception ex) {
            System.out.println("SQLException: " + ex.getMessage());
        }
    }

    public String selectAllCars() {
        String query = "SELECT IdSamochodu, Marka, Model, Kolor, RokProdukcji, PojemnoscBaku, IdKlasy, Silnik, CenaWypozyczenia, AktualnyPrzebieg FROM samochody";
        List<Samochod> carList = new ArrayList<Samochod>();
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
                    samochod.setRokProdukcji(Integer.valueOf(rs.getString("RokProdukcji")));
                    samochod.setPojemnoscBaku(Double.valueOf(rs.getString("PojemnoscBaku")));
                    samochod.setIdKlasy(rs.getString("IdKlasy"));
                    samochod.setSilnik(Float.valueOf(rs.getString("Silnik")));
                    samochod.setCenaWypozyczenia(Double.valueOf(rs.getString("CenaWypozyczenia")));
                    samochod.setAktualnyPrzebieg(Integer.valueOf(rs.getString("AktualnyPrzebieg")));
                    carList.add(samochod);
                }
                cars = carList;
            }
        } catch (SQLException s) {
            insertErrorToMongo(s);
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
            return "SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState();
        }
        return "true";
    }

    public String insertCar(Samochod car) {
        String OQuery = "insert into Samochody(Marka,Model,Kolor,RokProdukcji,PojemnoscBaku,IdKlasy,Silnik,CenaWypozyczenia,AktualnyPrzebieg) " +
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
            insertErrorToMongo(s);
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
            return ("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
        }
        return "true";
    }

    public String deleteCar(String id) {
        String OQuery;
        OQuery = "delete from samochody where IdSamochodu=" + id;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(OQuery);
        } catch (SQLException s) {
            insertErrorToMongo(s);
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
            return ("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
        }
        return "true";
    }

    public String updateCar(Samochod car) {
        String OQuery = "update Samochody set " +
                "Marka = '" + car.getMarka() + "' , " +
                "Model = '" + car.getModel() + "' , " +
                "Kolor = '" + car.getKolor() + "' , " +
                "RokProdukcji = '" + car.getRokProdukcji() + "', " +
                "PojemnoscBaku = '" + car.getPojemnoscBaku() + "', " +
                "IdKlasy = '" + car.getIdKlasy() + "', " +
                "Silnik = '" + car.getSilnik() + "', " +
                "CenaWypozyczenia = '" + car.getCenaWypozyczenia() + "', " +
                "AktualnyPrzebieg = '" + car.getAktualnyPrzebieg() + "'" +
                " where Samochody.IdSamochodu = '" + car.getId() + "'";

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(OQuery);
        } catch (SQLException s) {
            insertErrorToMongo(s);
            return ("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
        }
        return "true";
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
            insertErrorToMongo(s);
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
            insertErrorToMongo(s);
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
            insertErrorToMongo(s);
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
            insertErrorToMongo(s);
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
        }
    }

    public Samochod getCarById(String id) {
        String query = "SELECT IdSamochodu, Marka, Model, Kolor, RokProdukcji, PojemnoscBaku, IdKlasy, Silnik, CenaWypozyczenia, AktualnyPrzebieg FROM samochody where IdSamochodu = " + id;
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
                    samochod.setRokProdukcji(Integer.valueOf(rs.getString("RokProdukcji")));
                    samochod.setPojemnoscBaku(Double.valueOf(rs.getString("PojemnoscBaku")));
                    samochod.setIdKlasy(rs.getString("IdKlasy"));
                    samochod.setSilnik(Float.valueOf(rs.getString("Silnik")));
                    samochod.setCenaWypozyczenia(Double.valueOf(rs.getString("CenaWypozyczenia")));
                    samochod.setAktualnyPrzebieg(Integer.valueOf(rs.getString("AktualnyPrzebieg")));
                    return samochod;
                }
            }
        } catch (SQLException s) {
            insertErrorToMongo(s);
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
        }
        return null;
    }

    public String insertWypozyczenie(Wypozyczenie wypozyczenie) {
        System.out.println(wypozyczenie);
        String OQuery = "insert into Wypozyczenia(IdKlienta, IdSamochodu, IdRodzaj, IdPracownika, DataWypozyczenia, DataZwrotu, Koszt, LimitKilometrow) " +
                "values ('" + wypozyczenie.getIdKlienta() + "','" +
                wypozyczenie.getIdSamochodu() + "','" +
                wypozyczenie.getIdrodzaj() + "','" +
                wypozyczenie.getIdPracownika() + "','" +
                wypozyczenie.getDataWypozyczenia() + "','" +
                wypozyczenie.getDataZwrotu() + "','" +
                wypozyczenie.getKoszt() + "','" +
                wypozyczenie.getLimitKilometrow() + "')";
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(OQuery);
        } catch (SQLException s) {
            insertErrorToMongo(s);
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
            return ("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
        }
        return "true";
    }

    public List<Klient> selectAllClients() {
        String query = "SELECT     *\n" +
                "FROM       Osoba\n" +
                "             LEFT JOIN  Klienci K on Osoba.IdOsoby = K.IdOsoby where k.IdOsoby is not null\n";
        List<Klient> klients = new ArrayList<Klient>();
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            if (!rs.isBeforeFirst()) {
                found = false;
            } else {
                found = true;
                while (rs.next()) {
                    Klient klient = new Klient();
                    klient.setIdKlienta(Long.valueOf(rs.getString("IdKlienta")));
                    klient.setImie(rs.getString("Imie"));
                    klient.setNazwisko(rs.getString("Nazwisko"));
                    klient.setDataUrodzenia(rs.getString("DataUrodzenia"));
                    klients.add(klient);
                }
                return klients;
            }
        } catch (SQLException s) {
            insertErrorToMongo(s);
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
            // return "SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState();
        }
        //return "true";
        return null;
    }

    public List<RaportUzytkownika> getClientReport(String id) {
        String query = "SELECT    DataWypozyczenia, DataZwrotu, Koszt, s.Marka, s.Model\n" +
                "FROM       Wypozyczenia\n" +
                "             LEFT JOIN  Klienci K on Wypozyczenia.IdKlienta = K.IdKlienta\n" +
                "             left join Samochody s on Wypozyczenia.IdSamochodu = s.IdSamochodu\n" +
                "              where k.IdKlienta=" + id;
        List<RaportUzytkownika> raporty = new ArrayList<>();
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            if (!rs.isBeforeFirst()) {
                found = false;
            } else {
                found = true;
                while (rs.next()) {
                    RaportUzytkownika raportUzytkownika = new RaportUzytkownika();
                    raportUzytkownika.setDataWypozyczenia(rs.getString("DataWypozyczenia"));
                    raportUzytkownika.setDataZwrotu(rs.getString("DataZwrotu"));
                    raportUzytkownika.setKoszt((Double.valueOf(rs.getString("Koszt"))));
                    raportUzytkownika.setMarka(rs.getString("Marka"));
                    raportUzytkownika.setModel(rs.getString("Model"));
                    raporty.add(raportUzytkownika);
                }
                return raporty;
            }
        } catch (SQLException s) {
            insertErrorToMongo(s);
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
            // return "SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState();
        }
        return null;
    }

    public List<RaportSamochodu> getCarReport(String id) {
        String query = "SELECT    DataWypozyczenia, DataZwrotu, koszt, o.Imie, o.Nazwisko\n" +
                "FROM       Wypozyczenia\n" +
                "             LEFT JOIN  Klienci K on Wypozyczenia.IdKlienta = K.IdKlienta\n" +
                "             left join Samochody s on Wypozyczenia.IdSamochodu = s.IdSamochodu\n" +
                "              left join Osoba O on K.IdOsoby = O.IdOsoby\n" +
                "              where s.IdSamochodu=" + id;
        List<RaportSamochodu> raporty = new ArrayList<>();
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            if (!rs.isBeforeFirst()) {
                found = false;
            } else {
                found = true;
                while (rs.next()) {
                    RaportSamochodu raportSamochodu = new RaportSamochodu();
                    raportSamochodu.setDataWypozyczenia(rs.getString("DataWypozyczenia"));
                    raportSamochodu.setDataZwrotu(rs.getString("DataZwrotu"));
                    raportSamochodu.setKoszt((Double.valueOf(rs.getString("Koszt"))));
                    raportSamochodu.setImie(rs.getString("Imie"));
                    raportSamochodu.setNazwisko(rs.getString("Nazwisko"));
                    raporty.add(raportSamochodu);
                }
                return raporty;
            }
        } catch (SQLException s) {
            insertErrorToMongo(s);
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
            // return "SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState();
        }
        return null;
    }

    public String generateRaport(String query) {
        JSONArray json = new JSONArray();
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)) {
            if (!rs.isBeforeFirst()) {
                found = false;
            } else {
                found = true;
                ResultSetMetaData rsmd = rs.getMetaData();
                while (rs.next()) {
                    int numColumns = rsmd.getColumnCount();
                    JSONObject obj = new JSONObject();
                    for (int i = 1; i <= numColumns; i++) {
                        String column_name = rsmd.getColumnName(i);
                        obj.put(column_name, rs.getObject(column_name));
                    }
                    json.put(obj);
                }
            }
        } catch (SQLException s) {
            insertErrorToMongo(s);
            System.err.println("SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState());
            return "SQL Error: " + s.toString() + " " + s.getErrorCode() + " " + s.getSQLState();
        }
        return json.toString();
    }

    public Connection getConnection() {
        return connection;
    }

}