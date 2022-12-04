package com.example.projjet.service;

import com.example.projjet.model.Employee;
import com.example.projjet.model.Message;
import com.example.projjet.model.Tache;
import com.example.projjet.repository.MessageRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;


@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository ;

    public long save( Message message ) {
        return messageRepository.save(message).getId_mess();
    }
    public List<List<String>> findByIdRecepteur(Long id) {
        return messageRepository.findByIdRecepteur(id);
    }
    public Iterable<Message> findAll() {
        return messageRepository.findAll();
    }
    public List<List<String>> findByIdEmetteur(Long id) {
        return messageRepository.findByIdEmetteur(id);
    }

    @PostConstruct
    private void insert(){
        save(new Message());
    }

}

