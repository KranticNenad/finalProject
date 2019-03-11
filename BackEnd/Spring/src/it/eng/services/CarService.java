package it.eng.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eng.dao.CarDao;
import it.eng.model.Car;

@Service
public class CarService {
	@Autowired
	private CarDao carDao;
	
	public List<Car> getAllCars(){
		return carDao.getAllCars();
	}
	
	public void createCar(Car car) {
		carDao.createCar(car);
	}
	
	public void updateCar(Car car) {
		carDao.updateCar(car);
	}
	//TO DO: use rest of dao methods
}
