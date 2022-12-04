package com.example.projjet.controller;

import java.util.List;

import com.example.projjet.model.Employee;
import com.example.projjet.model.Projet;
import com.example.projjet.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class ProjetController {
	@Autowired
	private ProjetService projetservice;
	@GetMapping("/projets")
	 public List<Projet> list() {

		return projetservice.list();
	 }
	 @GetMapping("/getemployeebyprojetid/{id}")
	 public String findprojet(@PathVariable long id){
		return projetservice.findprojetbyemployeeid(id);
	 }
	@PostMapping("/projets")
	public String createCategorie(@Validated @RequestBody Projet projet) {
		projetservice.save(projet);
		return "projet dèjà ajoutèe";
	}
	@DeleteMapping("/projets/{id}")
	public String deleteprojet(@PathVariable(value = "id") Long projetid) {
		try {
			projetservice.delete(projetid);
			return "projet dèjà supprimée";

		} catch (Exception e) {
			return "echec";
		}
	}

}
