package com.example.projjet.controller;

import com.example.projjet.model.Employee;
import com.example.projjet.model.Message;
import com.example.projjet.service.EmployeeService;
import com.example.projjet.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class MesssageController {
    @Autowired
    private MessageService mssageService;
    // les message recue a ---------
    @GetMapping("/message/idRecepteur/{id}")
    public List<List<String>>  getMesssageByIdRecepteur(@PathVariable(value = "id") Long id){
        return mssageService.findByIdRecepteur(id);
    }
    //les messages envoyee par -----

    @GetMapping("/message/idEmetteur/{id}")
    public List<List<String>>  getMesssageByIdEmetteur(@PathVariable(value = "id") Long id){
        return mssageService.findByIdEmetteur(id);
    }
    //cree un message
    @PostMapping("/message")
    public String createMessage(@Validated @RequestBody Message message ) {
         mssageService.save(message);
         return "message a ète crèe";
    }
    //les messages
    @GetMapping("/message")
    public Iterable<Message>  getMesssage(){
        return mssageService.findAll();
    }




}
