package com.example.projjet.model;



import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "Message")


public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_mess;
    private String contenu;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dateTime;
    @PrePersist
    private void oncreate(){
        dateTime=new Date();
    }
    @ManyToOne
    @JoinColumn(name="id_recepteur")
    private Employee employee;
    @OneToOne
    @JoinColumn( name="id_emetteur" )

    private Employee emmetteur ;



}

