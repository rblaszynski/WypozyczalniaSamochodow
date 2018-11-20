package com.wypozyczalnia.service;

import java.util.List;

import com.wypozyczalnia.model.Samochod;


public interface CarService {

    List<Samochod> findAllCars();

    void saveCar(Samochod user);

    void deleteCar(String id);

    void updateCar(Samochod car);

}
