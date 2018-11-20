package com.wypozyczalnia.controller;
 
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
    
    //-------------------Retrieve All Cars--------------------------------------------------------
     
    @RequestMapping(value = "/car/", method = RequestMethod.GET)
    public ResponseEntity<List<Samochod>> listAllCars() {
        List<Samochod> cars = carService.findAllCars();
        if(cars.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);//You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

   //-------------------Create a Car--------------------------------------------------------

    @RequestMapping(value = "/car/", method = RequestMethod.POST)
    public ResponseEntity<Void> createCar(@RequestBody Samochod car,    UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Car " + car.getMarka());
        System.out.println("Creating Car " + car.getId());

        carService.saveCar(car);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/user/{id}").buildAndExpand(car.getId()).toUri());
        return new ResponseEntity<>(headers, HttpStatus.CREATED);
    }

    //------------------- Update a Car --------------------------------------------------------

    @RequestMapping(value = "/car/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Samochod> updateUser(@PathVariable("id") long id, @RequestBody Samochod car) {
        System.out.println("Updating Car " + id);
        carService.updateCar(car);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

   //------------------- Delete a Car --------------------------------------------------------

    @RequestMapping(value = "/car/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Samochod> deleteCar(@PathVariable("id") long id) {
        carService.deleteCar(String.valueOf(id));
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}