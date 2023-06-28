package com.bank.BankSystem.Controller;

import com.bank.BankSystem.Entity.Person;
import com.bank.BankSystem.Repository.BankCardRepository;
import com.bank.BankSystem.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BankSystemController {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private BankCardRepository bankCardRepository;

    @PostMapping("/addPerson")
    public String addPerson(@RequestBody Person person) {
        this.personRepository.save(person);
        return "Person successfully added!";
    }

    @GetMapping("/findAll")
    public List<Person> findAll() {
        return this.personRepository.findAll();
    }
}
