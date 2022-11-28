package com.example.projjet.repository;

import com.example.projjet.model.Employee;
import com.example.projjet.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProjetRepository extends JpaRepository<Projet, Long> {


    public Optional<Projet> findByLibelle (String libelle);

    @Query(value = " select p.libelle  from projet p  where  id = :employeeid"  , nativeQuery = true)
    List<List<String>> findByEmployeeId(@Param("employeeid") Long employeeid) ;
}
