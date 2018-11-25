package com.wypozyczalnia.controller;
 
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import com.wypozyczalnia.model.Samochod;
import com.wypozyczalnia.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
public class CarServiceRestEndpoint {
 
    @Autowired
    CarService carService;

    public static List<Samochod> cars;
    
    //-------------------Retrieve All Cars--------------------------------------------------------
     
    @RequestMapping(value = "/car/", method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity listAllCars() {
        String db = carService.findAllCars();
        if(db.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        if(db.equals("true")){
            return new ResponseEntity<>(cars, HttpStatus.OK);
        }
        else return new ResponseEntity<>(db,HttpStatus.INTERNAL_SERVER_ERROR);
    }

   //-------------------Create a Car--------------------------------------------------------

    @RequestMapping(value = "/car/", method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity createCar(@RequestBody Samochod car,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Car " + car.getMarka());

        String status = carService.saveCar(car);
        if(status.equals("true")){
            return new ResponseEntity<>(HttpStatus.CREATED);
        }
        else return new ResponseEntity<>("{\"error\":\""+status+"\"}",HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //------------------- Update a Car --------------------------------------------------------

    @RequestMapping(value = "/car/{id}", method = RequestMethod.PUT, produces = "application/json")
    public ResponseEntity updateUser(@PathVariable("id") long id, @RequestBody Samochod car) {
        System.out.println("Updating Car " + id);
        String status = carService.updateCar(car);
        if(status.equals("true")){
            return new ResponseEntity<>(car, HttpStatus.OK);
        }
        else return new ResponseEntity<String>("{\"error\":\""+status+"\"}",HttpStatus.INTERNAL_SERVER_ERROR);
    }

   //------------------- Delete a Car --------------------------------------------------------

    @RequestMapping(value = "/car/{id}", method = RequestMethod.DELETE, produces = "application/json")
    public ResponseEntity deleteCar(@PathVariable("id") long id) {
       String status = carService.deleteCar(String.valueOf(id));
        if(status.equals("true")){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else return new ResponseEntity<>(status,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}