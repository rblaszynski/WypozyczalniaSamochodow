package com.wypozyczalnia.service;

import com.wypozyczalnia.dao.JDBCDriver;
import com.wypozyczalnia.model.Samochod;
import com.wypozyczalnia.model.Wypozyczenie;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedHashMap;

@Service("hireService")
public class HireServiceImpl implements HireService {
    public String hireCar(LinkedHashMap linkedHashMap) {
        Integer idKlienta = Integer.valueOf(linkedHashMap.get("user").toString());
        Integer idSamochodu = Integer.valueOf(linkedHashMap.get("car").toString());
        String string = linkedHashMap.get("dataWypozyczenia").toString();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dataWypo = LocalDate.parse(string, formatter);
        string = linkedHashMap.get("dataZwrotu").toString();
        LocalDate dataZwrotu = LocalDate.parse(string,  formatter);
        Integer limit = Integer.valueOf(linkedHashMap.get("limitKilometrow").toString());

        JDBCDriver jdbcDriver = new JDBCDriver();
        Wypozyczenie wypozyczenie = new Wypozyczenie(idKlienta,idSamochodu,1,dataWypo,dataZwrotu,limit);
        return jdbcDriver.insertWypozyczenie(wypozyczenie);
    }

}
