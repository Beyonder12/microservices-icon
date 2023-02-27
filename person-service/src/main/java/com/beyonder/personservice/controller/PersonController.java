package com.beyonder.personservice.controller;

import com.beyonder.personservice.dto.ResponseTemplate;
import com.beyonder.personservice.entity.Person;
import com.beyonder.personservice.service.PersonService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/persons")
@Slf4j
public class PersonController {
    private final PersonService personService;

    @GetMapping("/test")
    public String test(){
        log.info("Class: PersonController, method: test...");
        return "Hello";
    }

    @GetMapping
    public List<Person> getAll(){
        log.info("Class: PersonController, method: getAll...");
        return personService.getAll();
    }

    @PostMapping
    public Person savePerson(@RequestBody Person person) {
        log.info("Class : PersonController, Method : savePerson...");
        return personService.savePerson(person);
    }

    @GetMapping("/{personId}")
    public ResponseTemplate getPersonWithDepartment(@PathVariable("personId") Long personId) {
        return personService.getPersonWithDepartment(personId);
    }

}
