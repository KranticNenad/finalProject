package it.eng.controllers;

import java.util.List;

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

import it.eng.model.Location;
import it.eng.services.LocationService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class LocationController {
	
	@Autowired
	private LocationService locationService;
	
	@GetMapping("/locations")
	public @ResponseBody List<Location> getAllLocations(){
		return locationService.getAllLocations();
	}
	
	@GetMapping("/locations/{locationCode}")
	public @ResponseBody Location getLocation(@PathVariable String locationCode) {
		return locationService.getLocation(locationCode);
	}
	
	@PostMapping("/locations")
	public ResponseEntity<Location> createLocation(@RequestBody Location location){
		locationService.createLocation(location);
		return new ResponseEntity<Location>(HttpStatus.OK);
	}
	
	@PutMapping("locations")
	public ResponseEntity<Location> updateLocation(@RequestBody Location location){
		Location foundLocation = locationService.getLocation(location.getLocationCode());
		if(foundLocation == null) {
			return new ResponseEntity<Location>(HttpStatus.NOT_FOUND);
		}
		locationService.updateLocation(location);
		return new ResponseEntity<Location>(HttpStatus.OK);
	}
	
	@DeleteMapping("/location/{locationCode}")
	public ResponseEntity<Location> deleteLocation(@PathVariable String locationCode){
		Location foundLocation = locationService.getLocation(locationCode);
		if(foundLocation == null) {
			return new ResponseEntity<Location>(HttpStatus.NOT_FOUND);
		}
		locationService.deleteLocation(foundLocation);
		return new ResponseEntity<Location>(HttpStatus.OK);
	}
	
	
}
