package com.bank.BankSystem.Controller;

import com.bank.BankSystem.Entity.Person;
import com.bank.BankSystem.Repository.BankCardRepository;
import com.bank.BankSystem.Repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    Logger logger = LoggerFactory.getLogger(BankSystemController.class);


    @PostMapping("/addPerson")
    public ResponseEntity<String> addPerson(@RequestBody Person person) {
        String error = "";
        if (person.getName() == null) {
            error = error + "name ";
        }
        if (person.getSurname() == null) {
            error = error + "surname ";
        }
        if (person.getPersonalNumber() == null) {
            error = error + "personalNumber ";
        }
        if (!error.equals("")) {
            return ResponseEntity.badRequest().body("Invalid input missing: " + error);
        } else {
            this.personRepository.save(person);
            logger.debug("Je zapnuty LOCAL profil");
            logger.info("Je zapnuty PRODUCTION profil");
            return ResponseEntity.ok("Person successfully added!");
        }

    }
    @GetMapping("/findAll")
    public ResponseEntity<List<Person>> findAll() {
        if(this.personRepository.findAll().isEmpty()) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(this.personRepository.findAll());
        }
        logger.debug("Je zapnuty LOCAL profil");
        logger.info("Je zapnuty PRODUCTION profil");
        return ResponseEntity.ok(this.personRepository.findAll());
    }

}
