package com.trello.trello.domai;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {
List <Project> findByName(String name);
List <Project> findByNameIgnoreCase(String name);
List <Project> findByNameIgnoreCaseContaining(String byName);

}
