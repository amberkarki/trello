package com.trello.trello.domai;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface DeveloperRepository extends CrudRepository<Developer, Long> {
List<Developer> findByfirstname(String firstname);
List<Developer> findByFirstnameIgnoreCase(String firstname);
List<Developer> findByFirstnameIgnoreCaseContaining(String byFirstname);

}
