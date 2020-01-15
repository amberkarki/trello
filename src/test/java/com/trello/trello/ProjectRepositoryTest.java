package com.trello.trello;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.trello.trello.domai.Project;
import com.trello.trello.domai.ProjectRepository;
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectRepositoryTest {
	@Autowired
	private ProjectRepository proRepo;
	
	@Test 
	public void addingNewProject() {
		Project project= new Project("UX");
		proRepo.save(project);
		assertThat(project.getName().toString()).isEqualTo("UX");
	
		
		
	}
	
	@Test
	
	public void  findProject() {
		List<Project> projects = proRepo.findByName("AI");
		assertThat(projects).hasSize(1);
		assertThat(projects.get(0).getName()).isEqualTo("AI");
		
	}
	

	

}
