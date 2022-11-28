package com.example.projjet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "projet")
@JsonIgnoreProperties(value = { "taches" })
public class Projet implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String libelle;

	@ManyToOne
	@JoinColumn(name = "employee_id")
	private Employee employee;
	@OneToMany(mappedBy = "projet")

	private List<Tache> taches ;




	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getLibelle() {
		return libelle;
	}


	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}



	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	public Projet(long id, String libelle, long employeeId) {
		super();
		this.id = id;
		this.libelle = libelle;
		this.employee = new Employee(employeeId, "", 0, "", "", "");
	}

	public List<Tache> getTaches() {
		return taches;
	}

	public void setTaches(List<Tache> taches) {
		this.taches = taches;
	}

	public Projet() {
		super();
	}


}
