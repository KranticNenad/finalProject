package it.eng.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import it.eng.model.Employee;
import it.eng.model.Warrant;
import it.eng.services.EmployeeService;
import it.eng.services.WarrantService;

@Controller
public class WarrantController {

	@Autowired
	private WarrantService warrantService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping("/warrants")
    public @ResponseBody Warrant getWarrant(){
        Warrant warrant = warrantService.getAllWarrants().get(0);
        return warrant;
    }	
	
}
