package it.eng.controllers;

import java.util.List;
import it.eng.model.LoginM;
import it.eng.model.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import it.eng.model.Car;
import it.eng.services.CarService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class CarController {

	@Autowired
	private CarService carService;
	
	@GetMapping("/cars/{regNo}")
    public @ResponseBody Car getCar(@PathVariable String regNo){
		return carService.getCar(regNo);        
    }
	
	@GetMapping("/usercars/{user}")
	public @ResponseBody List<Car> getAllCars(@PathVariable String user){
			return carService.getAllUserCars(user);
	} 
	
	@GetMapping("/cars")
	public @ResponseBody List<Car> getAllCars(){
		return carService.getAllCars();
	} 
	
	@PostMapping("/cars")
	public ResponseEntity<Car> createCar(@RequestBody Car car) {
		carService.createCar(car);
		return new ResponseEntity<Car>(HttpStatus.OK);
	}
	
	@PutMapping("/cars")
	public ResponseEntity<Car> updateCar (@RequestBody Car car){
		Car foundCar = carService.getCar(car.getRegNo());
		if(foundCar == null) {
			return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
		}
		carService.updateCar(car);
		return new ResponseEntity<Car>(HttpStatus.OK);
	}
	
	@PutMapping("/updateCar")
	public ResponseEntity<Car> updateCar2 (@RequestBody Car car){
		System.out.println("UPDATE");
		Car foundCar = carService.getCar(car.getRegNo());
		if(foundCar == null) {
			return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
		}
		carService.updateCar(car);
		return new ResponseEntity<Car>(HttpStatus.OK);
	}
	
	@DeleteMapping("/cars/{carId}")
	public ResponseEntity<Car> deleteCar(@PathVariable String carId){
		Car foundCar = carService.getCar(carId);
		if(foundCar == null) {
			return new ResponseEntity<Car>(HttpStatus.NOT_FOUND);
		}
		carService.deleteCar(foundCar);
		return new ResponseEntity<Car>(HttpStatus.OK);
	}
	
	/*
	@GetMapping("/cars/{carId}")
	public @ResponseBody Car searchCars(@PathVariable String carId){
		return carService.searchCars(carId);
	}
	*/
}
