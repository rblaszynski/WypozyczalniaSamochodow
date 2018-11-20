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

	private static List<Samochod> cars = new ArrayList<>();

	public List<Samochod> findAllCars() {
		cars = jdbcDriver.selectAll();
		return cars;
	}

	public void saveCar(Samochod car) {
		jdbcDriver.insertCar(car);
	}

	public void deleteCar(String id){
	    jdbcDriver.deleteCar(id);
    }

    public void updateCar(Samochod car) {jdbcDriver.updateCar(car); }

}
