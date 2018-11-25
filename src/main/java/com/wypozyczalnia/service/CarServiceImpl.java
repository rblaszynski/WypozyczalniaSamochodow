package com.wypozyczalnia.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.wypozyczalnia.dao.JDBCDriver;
import com.wypozyczalnia.model.Samochod;
import org.springframework.stereotype.Service;

@Service("carService")
public class CarServiceImpl implements CarService {

	private static JDBCDriver jdbcDriver = new JDBCDriver();

    public String findAllCars() {
		return jdbcDriver.selectAllCars();
	}

	public String saveCar(Samochod car) {
		 return jdbcDriver.insertCar(car);
	}

	public String deleteCar(String id){
	    return jdbcDriver.deleteCar(id);
    }

    public String updateCar(Samochod car) { return jdbcDriver.updateCar(car); }

}
