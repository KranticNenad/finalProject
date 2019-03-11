package it.eng.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.eng.model.Car;
import it.eng.services.CarService;

@Controller
public class CarController {

	@Autowired
	private CarService carService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/cars")
    public @ResponseBody Car getCar(){
        Car car = carService.getAllCars().get(0);
        return car;
    }	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/cars")
	public ResponseEntity<Car> createEmployee(@RequestBody Car car) {
		carService.createCar(car);
		return new ResponseEntity<Car>(HttpStatus.OK);
	}
	
}
