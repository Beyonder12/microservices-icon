package com.beyonder.personservice.service;

import com.beyonder.personservice.dto.DepartmentDTO;
import com.beyonder.personservice.dto.ResponseTemplate;
import com.beyonder.personservice.entity.Person;
import com.beyonder.personservice.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class PersonService {
    private final PersonRepository personRepository;

    private final RestTemplate restTemplate;

    public Person savePerson(Person person) {
        log.info("Class : PersonService, Method : savePerson...");
        return personRepository.save(person);
    }

    public ResponseTemplate getPersonWithDepartment(Long personId) {
        log.info("Class : PersonService, Method : getPersonWithDepartment...");
        ResponseTemplate responseTemplate = new ResponseTemplate();
        Person person = personRepository.findByPersonId(personId);

        DepartmentDTO departmentDTO =
                restTemplate.getForObject("http://department-service:8087/api/v1/departments/" + person.getDepartmentId(),
                        DepartmentDTO.class);
        responseTemplate.setPerson(person);
        responseTemplate.setDepartmentDTO(departmentDTO);

        return responseTemplate;
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }
}
