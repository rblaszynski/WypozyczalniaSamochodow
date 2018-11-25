package com.wypozyczalnia.controller;


import com.wypozyczalnia.service.HireService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class HireCarRestEndpoint {

    @Autowired
    HireService hireService;

    //-------------------Hire a Car--------------------------------------------------------

    @RequestMapping(value = "/hire/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity createCar(@RequestBody LinkedHashMap car, UriComponentsBuilder ucBuilder) {
        System.out.println("Hiring car:  " + car);
        String status = hireService.hireCar(car);

        if(status.equals("true")){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else return new ResponseEntity<>("{\"error\":\""+status+"\"}",HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
