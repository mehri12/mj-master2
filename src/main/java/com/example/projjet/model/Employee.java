package com.example.projjet.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
public class Employee implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private String role;
	private int age;
	private String mail;
	private String password;


    @OneToMany (mappedBy = "employee" , cascade = CascadeType.ALL)
	private List<Tache> taches ;
	@OneToMany (mappedBy = "employee" , cascade = CascadeType.ALL)
	private List<Message> messages;




	



}
