package com.example.projjet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonIgnoreProperties(value = { "employees" })
public class Tache implements Serializable {
    @Id
   	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    @Column(nullable = false)
    private String nomTache ;
    @ManyToOne
    private Projet projet ;
    @OneToMany(mappedBy = "tache")
    private List<Employee> employees ;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomTache() {
        return nomTache;
    }

    public void setNomTache(String nomTache) {
        this.nomTache = nomTache;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


}
