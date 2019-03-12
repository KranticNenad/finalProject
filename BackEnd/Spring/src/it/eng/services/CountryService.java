package it.eng.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eng.dao.CountryDao;
import it.eng.model.Country;

@Service
public class CountryService {
	
	@Autowired
	private CountryDao countryDao;
	
	public List<Country> getAllCountries(){
		return countryDao.getAllCountries();
	}
	
	public Country getCountry (String countryCode) {
		return countryDao.getCountry(countryCode);
	}
	
	public void createCountry(Country country) {
		countryDao.createCountry(country);
	}
	public void updateCountry(Country country) {
		countryDao.updateCountry(country);
	}
	
	public void deleteCountry(Country country) {
		countryDao.deleteCountry(country);
	}
	

}
