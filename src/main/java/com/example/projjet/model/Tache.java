package com.example.projjet.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@JsonIgnoreProperties(value = { "employees" })
public class Tache implements Serializable {
    @Id
   	@GeneratedValue(strategy = GenerationType.AUTO)
    private long id ;
    @Column(nullable = false)
    private String nomTache ;
    @ManyToOne
    private Projet projet ;
    @ManyToOne
    private Employee employee ;

}
