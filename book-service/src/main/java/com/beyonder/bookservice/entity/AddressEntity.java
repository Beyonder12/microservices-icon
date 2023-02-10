package com.beyonder.bookservice.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String street;
    private String city;
    private String state;
    private String zipCode;

    @OneToOne
    @JoinColumn(name = "person_id")
    private PersonEntity personEntity;
}
