package com.wypozyczalnia.controller;

import com.wypozyczalnia.model.Klient;
import com.wypozyczalnia.model.RaportSamochodu;
import com.wypozyczalnia.model.RaportUzytkownika;
import com.wypozyczalnia.model.User;
import com.wypozyczalnia.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReportServiceRestEndpoint {

    @Autowired
    ReportService reportService;

    @RequestMapping(value = "/report/client/{id}", method = RequestMethod.GET)
    public ResponseEntity getRaportUzytkownika(@PathVariable("id") long id) {
        List<RaportUzytkownika> raportUzytkownika = reportService.getRaportUzytkownika(String.valueOf(id));
        String status = "SQL Error: com.microsoft.sqlserver.jdbc.SQLServerException: ***Nie mozna wygenerowac raportu jesli klient nie wypozyczyl nigdy samochodu!*** 0 null";
        if(raportUzytkownika==null){
            return new ResponseEntity<>("{\"error\":\""+status+"\"}",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(raportUzytkownika, HttpStatus.OK);
    }

    @RequestMapping(value = "/report/car/{id}", method = RequestMethod.GET)
    public ResponseEntity getRaportSamochodu(@PathVariable("id") long id) {
        List<RaportSamochodu> raportSamochodu = reportService.getRaportSamochodu(String.valueOf(id));
        String status = "SQL Error: com.microsoft.sqlserver.jdbc.SQLServerException: ***Nie mozna wygenerowac raportu jesli samochod nie byl nigdy wypozyczony!*** 0 null";
        if(raportSamochodu==null){
            return new ResponseEntity<>("{\"error\":\""+status+"\"}",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity(raportSamochodu, HttpStatus.OK);
    }
}
