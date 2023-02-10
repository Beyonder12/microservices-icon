package com.beyonder.bookservice.repository;

import com.beyonder.bookservice.entity.AddressEntity;
import com.beyonder.bookservice.entity.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends JpaRepository<AddressEntity, Long> {
}
