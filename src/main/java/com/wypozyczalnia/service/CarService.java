package com.wypozyczalnia.service;

import java.util.List;

import com.wypozyczalnia.model.Samochod;


public interface CarService {

    String findAllCars();

    String saveCar(Samochod user);

    String deleteCar(String id);

    String updateCar(Samochod car);

}
