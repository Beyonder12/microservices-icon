package com.beyonder.bookservice.controller;

import com.beyonder.bookservice.dto.PersonDto;
import com.beyonder.bookservice.entity.AddressEntity;
import com.beyonder.bookservice.entity.BookEntity;
import com.beyonder.bookservice.entity.PersonEntity;
import com.beyonder.bookservice.service.BookService;
import com.beyonder.bookservice.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService personService;

    @PostMapping
    public PersonEntity createPerson(@RequestBody PersonDto personDto) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setName(personDto.getName());
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setStreet(personDto.getStreet());
        addressEntity.setCity(personDto.getCity());
        addressEntity.setState(personDto.getState());
        addressEntity.setZipCode(personDto.getZipCode());
        return personService.savePersonWithAddress(personEntity, addressEntity);
    }

    @GetMapping("/{id}")
    public PersonEntity getPerson(@PathVariable Long id) {
        return personService.findPersonById(id);
    }
}
