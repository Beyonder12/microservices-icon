package com.beyonder.bookservice.service.implementation;

import com.beyonder.bookservice.entity.AddressEntity;
import com.beyonder.bookservice.entity.BookEntity;
import com.beyonder.bookservice.entity.PersonEntity;
import com.beyonder.bookservice.repository.AddressRepository;
import com.beyonder.bookservice.repository.BookRepository;
import com.beyonder.bookservice.repository.PersonRepository;
import com.beyonder.bookservice.service.BookService;
import com.beyonder.bookservice.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;

    private final AddressRepository addressRepository;

    public PersonEntity savePersonWithAddress(PersonEntity personEntity, AddressEntity addressEntity) {
        addressEntity.setPersonEntity(personEntity);
        personEntity.setAddressEntity(addressEntity);
        personRepository.save(personEntity);
        addressRepository.save(addressEntity);
        return personEntity;
    }

    public PersonEntity findPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }
}
