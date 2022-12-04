package com.example.projjet.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projet")
@JsonIgnoreProperties(value = { "taches" })
public class Projet implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String libelle;
	@OneToOne
	@JoinColumn(name = "chef_id")
	private Employee chef_id;


	@OneToMany(mappedBy = "projet", cascade = CascadeType.ALL)
	private List<Tache> taches ;







}
