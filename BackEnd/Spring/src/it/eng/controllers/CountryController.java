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

import it.eng.model.Country;
import it.eng.services.CountryService;

@CrossOrigin(origins = "http://localhost:4200")
@Controller
public class CountryController {

	@Autowired
	private CountryService countryService;

	@GetMapping("/countries")
	public @ResponseBody List<Country> getAllCountries() {
		return countryService.getAllCountries();
	}

	@GetMapping("/countries/{countryCode}")
	public @ResponseBody Country getCountry(String countryCode) {
		return countryService.getCountry(countryCode);
	}

	@PostMapping("/countries")
	public ResponseEntity<Country> createCountry(@RequestBody Country country) {
		countryService.createCountry(country);
		return new ResponseEntity<Country>(HttpStatus.OK);
	}

	@PutMapping("/countries")
	public ResponseEntity<Country> updateCountry(@RequestBody Country country) {
		Country foundCountry = countryService.getCountry(country.getCountryCode());
		if (foundCountry == null) {
			return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
		}
		countryService.updateCountry(foundCountry);
		return new ResponseEntity<Country>(HttpStatus.OK);
	}

	@DeleteMapping("/countries/{countryCode}")
	public ResponseEntity<Country> deleteCountry(@PathVariable String countryCode) {
		Country foundCountry = countryService.getCountry(countryCode);
		if (foundCountry == null) {
			return new ResponseEntity<Country>(HttpStatus.NOT_FOUND);
		}
		countryService.deleteCountry(foundCountry);
		return new ResponseEntity<Country>(HttpStatus.OK);
	}
}
