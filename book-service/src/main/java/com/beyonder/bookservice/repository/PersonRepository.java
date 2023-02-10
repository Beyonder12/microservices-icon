package com.beyonder.bookservice.repository;

import com.beyonder.bookservice.entity.BookEntity;
import com.beyonder.bookservice.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
}
