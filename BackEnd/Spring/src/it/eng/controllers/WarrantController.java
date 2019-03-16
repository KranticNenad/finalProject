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

import it.eng.model.Warrant;
import it.eng.services.WarrantService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class WarrantController {

	@Autowired
	private WarrantService warrantService;
	
	@GetMapping("/warrants/{warrantId}")
    public @ResponseBody Warrant getWarrant(@PathVariable Long warrantId){
		return warrantService.getWarrant(warrantId);        
    }	
		
	@GetMapping("/warrants")
	public @ResponseBody List<Warrant> getAllWarrants(){
		return warrantService.getAllWarrants();
	}
	
	@PostMapping("/warrants")
	public ResponseEntity<Warrant> createWarrant(@RequestBody Warrant warrant){
		warrantService.createWarrant(warrant);
		return new ResponseEntity<Warrant>(HttpStatus.OK);
	}
	
	@PutMapping("/warrants")
	public ResponseEntity<Warrant> updateWarrant(@RequestBody Warrant warrant){
		Warrant foundWarrant = warrantService.getWarrant(warrant.getWarrantId());
		if(foundWarrant == null) {
			return new ResponseEntity<Warrant>(HttpStatus.NOT_FOUND);
		}
		warrantService.updateWarrant(warrant);
		return new ResponseEntity<Warrant>(HttpStatus.OK);
	}
	
	@DeleteMapping("/warrants/{warrantId}")
	public ResponseEntity<Warrant> deleteWarrant(@PathVariable Long warrantId){
		Warrant foundWarrant = warrantService.getWarrant(warrantId);
		if(foundWarrant == null) {
			return new ResponseEntity<Warrant>(HttpStatus.NOT_FOUND);
		}
		warrantService.deleteWarrant(foundWarrant);
		return new ResponseEntity<Warrant>(HttpStatus.OK);
	}
	
	
}
