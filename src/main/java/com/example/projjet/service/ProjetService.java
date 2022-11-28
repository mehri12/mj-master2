package com.example.projjet.service;

import java.util.List;

import com.example.projjet.model.Employee;
import com.example.projjet.model.Projet;
import com.example.projjet.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;



@Service
@Transactional
public class ProjetService {
	@Autowired
	ProjetRepository projetRepository;
	public List<Projet> list() {
		return projetRepository.findAll();
	}
	public Projet findByName(String libelle) {
		return projetRepository.findByLibelle(libelle).get();
	}

	public void delete(long id) {

		projetRepository.deleteById(id);
	}

	public void deleteAll() {
		projetRepository.deleteAll();
	}
	public long save( Projet projet) {

		return projetRepository.save(projet).getId();
	}


}