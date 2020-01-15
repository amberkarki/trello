package com.trello.trello;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.trello.trello.domai.Developer;
import com.trello.trello.domai.DeveloperRepository;
import com.trello.trello.domai.Project;
@RunWith(SpringRunner.class)
@DataJpaTest
public class DeveloperRepositoryTest {
	
	@Autowired
	private DeveloperRepository devRepo;
	
	@Test
	
	public void  findname() {
		List<Developer> developers = devRepo.findByfirstname("Amber");
		assertThat(developers).hasSize(1);
		assertThat(developers.get(0).getFirstname()).isEqualTo("Amber");
		
	}
	
	@Test 
	public void addingNewDeveloper() {
		Developer dev= new Developer("Project manager", "khushi","Karki", "04", "dev2@hhhm.com","3weeks","Libaray",new Project("Selenium"));
		devRepo.save(dev);
		assertThat(dev.getFirstname()).isEqualTo("khushi");
	
		
		
	}
	

}
