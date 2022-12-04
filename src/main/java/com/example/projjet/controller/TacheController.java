package com.example.projjet.controller;

import com.example.projjet.model.Employee;
import com.example.projjet.model.Projet;
import com.example.projjet.model.Tache;
import com.example.projjet.repository.TacheRepository;
import com.example.projjet.service.TacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class TacheController {
    @Autowired
    TacheService tacheService;
    @Autowired
    TacheRepository tacheRepository;

    @GetMapping("/tache")

    public List<Tache> GETALLTACHE() {

            return tacheRepository.findAll();
        }
     @GetMapping("/getinformbyidtache/{id}")
     public List<List<String>> getprojetbytacheid(@PathVariable long id){
        return tacheService.findprojetbytache(id);
     }
    @PostMapping("/tache")
    public String savetache(@RequestBody Tache tache){
        tacheService.save(tache);
        return "tache ajoutèèe";
    }
    @DeleteMapping("/tache/{id}")
    public String deletetache(@PathVariable long id){
        tacheService.deleteById(id);
        return "tache dèjà supprimèe";
    }


}
