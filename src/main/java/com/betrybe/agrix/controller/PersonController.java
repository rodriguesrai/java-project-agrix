package com.betrybe.agrix.controller;

import com.betrybe.agrix.controller.dto.PersonCreationDto;
import com.betrybe.agrix.controller.dto.PersonDto;
import com.betrybe.agrix.entity.Person;
import com.betrybe.agrix.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Person controller.
 */
@RestController
@RequestMapping("/persons")
public class PersonController {

  @Autowired
  private PersonService personService;

  /**
   * Create person response entity.
   *
   * @param personCreationDto the person creation dto
   * @return the response entity
   */
  @PostMapping
  public ResponseEntity<PersonDto> createPerson(@RequestBody PersonCreationDto personCreationDto) {
    Person person = personCreationDto.toEntity();
    Person createdPerson = personService.create(person);
    PersonDto personDto = PersonDto.fromEntity(createdPerson);
    return ResponseEntity.status(201).body(personDto);
  }

}
