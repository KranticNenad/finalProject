package it.eng.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eng.dao.LocationDao;
import it.eng.model.Location;

@Service
public class LocationService {

	@Autowired
	private LocationDao locationDao;
	
	public Location getLocation(String locationCode) {
		return locationDao.getLocation(locationCode);
	}
	
	public List<Location> getAllLocations(){
		return locationDao.getAllLocations();
	}
	
	public void createLocation(Location location) {
		locationDao.createLocation(location);
	}
	
	public void deleteLocation(Location location) {
		locationDao.deleteLocation(location);
	}
	
	public void updateLocation(Location location) {
		locationDao.updateLocation(location);
	}
}
