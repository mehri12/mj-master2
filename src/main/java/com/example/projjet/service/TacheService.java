package com.example.projjet.service;


import com.example.projjet.model.Employee;
import com.example.projjet.model.Tache;
import com.example.projjet.repository.TacheRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TacheService  {
    @Autowired
    TacheRepository repository;

    public void save(Tache tache){
         repository.save(tache);
    }
    public Optional<Tache> findById(Long aLong) {
        return repository.findById(aLong);
    }
     public List<List<String>> findprojetbytache(Long id){
        return repository.findByTacheId(id);
     }

    public void deleteById(Long aLong) {
        repository.deleteById(aLong);
    }

    public void delete(Tache entity) {
        repository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Long> longs) {
        repository.deleteAllById(longs);
    }

    public List<Tache> findAll() {
        return repository.findAll();
    }

    public void deleteAll() {
        repository.deleteAll();
    }


}
