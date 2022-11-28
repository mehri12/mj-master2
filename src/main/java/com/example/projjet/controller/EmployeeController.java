package com.example.projjet.controller;

import java.util.List;

import com.example.projjet.model.Employee;
import com.example.projjet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class EmployeeController {
	@Autowired
    private EmployeeService employeeservice;
	@GetMapping("/employee")
	 public List<Employee> list() {
		 return employeeservice.list();
	 }
	@GetMapping("/employee/nom/{nom}")
	public Employee getEmployeeByName(@PathVariable(value = "nom") String nom){
		return employeeservice.findByName(nom);
		
}
	@PostMapping("/employee")
	public String createCategorie(@Validated @RequestBody Employee employee) {
		 employeeservice.save(employee);
		 return "employee dèjà ajoutèe";
	}
	@GetMapping("/getemployeeinfo/{id}")
	public List<List<String>> findbyemployeeid(@PathVariable long id){
		return employeeservice.findbyemployeeid(id);
	}
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable(value = "id") Long EmployeeId) {
		try {
			employeeservice.delete(EmployeeId);
			return "employee supprimée";

		}

		catch(Exception e) {
			return "echec";
		}

}
	@DeleteMapping("/employee/all")
	public String deleteEmployee() {
		try {
			employeeservice.deleteAll();
			return "employee supprimées";

		}
		catch(Exception e) {
			return "echec";

			
		}
	
	}

}