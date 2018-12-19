package com.wypozyczalnia.controller;

import com.wypozyczalnia.model.Klient;
import com.wypozyczalnia.model.RaportSamochodu;
import com.wypozyczalnia.model.RaportUzytkownika;
import com.wypozyczalnia.model.User;
import com.wypozyczalnia.service.QueryService;
import com.wypozyczalnia.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class QueriesServiceRestEndpoint {

    @Autowired
    QueryService queryService;

    @RequestMapping(value = "/query/", method = RequestMethod.POST)
    public ResponseEntity getReport( @RequestBody String query) {
        String raport = queryService.generateRaport(query);
        if(raport==null || raport.contains("SQL Error")){
            return new ResponseEntity<>("{\"error\":\""+raport+"\"}",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(raport, HttpStatus.OK);
    }

}
