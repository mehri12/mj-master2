package com.example.projjet.repository;

import java.util.List;
import java.util.Optional;

import com.example.projjet.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    public Optional<Employee> findByNom (String nom);

    @Query(value = " select e.tache_id,e.nom  from employee e  where  id = :employeeid"  , nativeQuery = true)
    List<List<String>> findByEmployeeId(@Param("employeeid") Long employeeid) ;


}
