package it.eng.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.eng.dao.WarrantDao;
import it.eng.model.Warrant;

@Service
public class WarrantService {

	@Autowired
	private WarrantDao warrantDao;
	
	public List<Warrant> getAllWarrants(){
		return warrantDao.getAllWarrants();
	}
	
	public Warrant getWarrant(Long warrantId) {
		return warrantDao.getWarrant(warrantId);
	}
	
	public void createWarrant(Warrant warrant) {
		warrantDao.createWarrant(warrant);
	}
	
	public void updateWarrant(Warrant warrant) {
		warrantDao.updateWarrant(warrant);
	}
	
	public void deleteWarrant(Warrant warrant) {
		warrantDao.deleteWarrant(warrant);
	}
	
}
