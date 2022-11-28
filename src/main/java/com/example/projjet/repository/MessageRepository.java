package com.example.projjet.repository;

import com.example.projjet.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface MessageRepository extends JpaRepository<Message,Long> {
    @Query(value = " select m.contenu ,e.nom from Message m,Employee e where id_emetteur=id and" +
            " id_recepteur = :recepteur", nativeQuery = true)
    List<List<String>> findByIdRecepteur(@Param("recepteur") Long recepteur) ;
    @Query(value = " select m.contenu ,e.nom  from Message m, employee e   where id_recepteur=id and " +
            " id_emetteur = :emetteur", nativeQuery = true)
    List<List<String>> findByIdEmetteur(@Param("emetteur") Long emetteur) ;



}
