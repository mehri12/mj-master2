package com.example.projjet.service;

import java.util.List;

import com.example.projjet.model.Employee;
import com.example.projjet.model.Tache;
import com.example.projjet.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class EmployeeService {
	@Autowired
	EmployeeRepository repository;
	public List<Employee> list(){
		return repository.findAll();
	}
	public Employee findByName(String nom) {
		return repository.findByNom(nom);
	}
	 public List<List<String>> findbyemployeeid(long id){
		return repository.findByEmployeeId(id);
	 }

	public void delete(long id) {
		repository.deleteById(id);
	}
	
	public void deleteAll() {
		repository.deleteAll();
	}
	public long save( Employee employee) {
		return repository.save(employee).getId();
	}

}
