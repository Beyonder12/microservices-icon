package com.beyonder.personservice.dto;

import com.beyonder.personservice.entity.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplate {
    private Person person;
    private DepartmentDTO departmentDTO;
}
