package it.eng.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eng.dao.CarDao;
import it.eng.dao.EmployeeDao;
import it.eng.dao.LocationDao;
import it.eng.dao.UserDao;
import it.eng.dao.WarrantDao;
import it.eng.dto.WarrantDto;
import it.eng.model.Car;
import it.eng.model.Employee;
import it.eng.model.Location;
import it.eng.model.User;
import it.eng.model.Warrant;

@Service
public class WarrantService {

	@Autowired
	private WarrantDao warrantDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private CarDao carDao;
	@Autowired
	private LocationDao locationDao;
	@Autowired
	private EmployeeDao employeeDao;
	
	
	public List<Warrant> getAllWarrants(){
		return warrantDao.getAllWarrants();
	}
	
	public Warrant getWarrant(Long warrantId) {
		return warrantDao.getWarrant(warrantId);
	}
	
	public void createWarrant(Warrant warrant) {
		warrantDao.createWarrant(warrant);
	}
	
	public Warrant createWarrantFromDto(WarrantDto warrantDto) {
		User user = userDao.getUser(warrantDto.getUsername());
		Car car = carDao.getCar(warrantDto.getRegNo());
		Employee employee = employeeDao.getEmployee
				(warrantDto.getEmployeeId());
		List<Location> locations = new ArrayList<Location>();
		for (String locationCode : warrantDto.getLocationCodes()) {
			locations.add(locationDao.getLocation(locationCode));
		}
		Warrant warrant = new Warrant(warrantDto.getWarrantId(),
			warrantDto.getIssuedAt(), warrantDto.getDistance(),
			warrantDto.getReturnedAt(), warrantDto.getFuelUsed(), 
			car, employee, user, locations);
		warrantDao.createWarrant(warrant);
		return warrant;
	}
	
	public Warrant updateWarrantFromDto(WarrantDto warrantDto) {
		User user = userDao.getUser(warrantDto.getUsername());
		Car car = carDao.getCar(warrantDto.getRegNo());
		Employee employee = employeeDao.getEmployee
				(warrantDto.getEmployeeId());
		List<Location> locations = new ArrayList<Location>();
		for (String locationCode : warrantDto.getLocationCodes()) {
			locations.add(locationDao.getLocation(locationCode));
		}
		Warrant warrant = new Warrant(warrantDto.getWarrantId(),
			warrantDto.getIssuedAt(), warrantDto.getDistance(),
			warrantDto.getReturnedAt(), warrantDto.getFuelUsed(), 
			car, employee, user, locations);
		warrantDao.updateWarrant(warrant);
		return warrant;
	}
	
	public void updateWarrant(Warrant warrant) {
		warrantDao.updateWarrant(warrant);
	}
	
	public void deleteWarrant(Warrant warrant) {
		warrantDao.deleteWarrant(warrant);
	}
	
}
