package com.example.projjet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.projjet.SecurityServices.CustomUserDetails;
import com.example.projjet.SecurityServices.CustomUserDetailsService;
import com.example.projjet.SecurityServices.JwtUtil;
import com.example.projjet.model.AuthenticationModel;
import com.example.projjet.model.Employee;
import com.example.projjet.repository.EmployeeRepository;
import com.example.projjet.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
	@Autowired
	private AuthenticationManager authManager;
	@Autowired
	private EmployeeRepository employeeRepository;
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private BCryptPasswordEncoder encoder;
	@GetMapping("/employee")
	 public List<Employee> list() {
		 return employeeservice.list();
	 }


	@GetMapping("/hello")
	public String hello(){
		return "test";
	}

	@GetMapping("/helloAUTH")
	public String helloAuth(){
		return "test1111";
	}


	@GetMapping("/employee/nom/{nom}")
	public Employee getEmployeeByName(@PathVariable(value = "nom") String nom){
		return employeeservice.findByName(nom);
		
	}
	@PostMapping("/employee")
	public String createCategorie(@Validated @RequestBody Employee employee) {
		 employee.setPassword(encoder.encode(employee.getPassword()));
		 employeeservice.save(employee);
		 return "employee ajouté avec succés";
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

	@PostMapping("/login")
	public ResponseEntity<?> generateToken(@RequestBody AuthenticationModel authModel) throws Exception {
		String message="invalid username";
		Map<String, Object> response = new HashMap<>();
		response.put("message", message);
		if(!employeeRepository.findByMail(authModel.getMail()).isEmpty()){
			Employee user = employeeRepository.findByMail(authModel.getMail()).get(0);
			try {
				authManager.authenticate(new UsernamePasswordAuthenticationToken(authModel.getMail(), authModel.getPassword()));
				CustomUserDetails mud = (CustomUserDetails) customUserDetailsService.loadUserByUsername(authModel.getMail());

				response.remove("message");
				response.put("employee name", user.getNom());
				response.put("role",user.getRole());
				response.put("token", jwtUtil.generateToken(mud));
				return new ResponseEntity<>(response, HttpStatus.CREATED);

			} catch (Exception ex) {
				message="invalid password";
				response.put("message", message);
				return new ResponseEntity<>(response, HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<>(response, HttpStatus.CREATED);
	}

}