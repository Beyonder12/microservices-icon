package com.beyonder.bookservice.service;

import com.beyonder.bookservice.entity.AddressEntity;
import com.beyonder.bookservice.entity.BookEntity;
import com.beyonder.bookservice.entity.PersonEntity;

import java.util.List;

public interface PersonService {
    PersonEntity savePersonWithAddress(PersonEntity person, AddressEntity address);

    PersonEntity findPersonById(Long id);
}
