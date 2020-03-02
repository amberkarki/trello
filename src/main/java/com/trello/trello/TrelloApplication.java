package com.trello.trello;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.trello.trello.domai.Developer;
import com.trello.trello.domai.DeveloperRepository;
import com.trello.trello.domai.Project;
import com.trello.trello.domai.ProjectRepository;
import com.trello.trello.domai.User;
import com.trello.trello.domai.UserRepository;

@SpringBootApplication
@ComponentScan(basePackages={"com.trello.trello"})

public class TrelloApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrelloApplication.class, args);
		
	}
		@Bean
		public CommandLineRunner demo(ProjectRepository repository, DeveloperRepository devRepository,UserRepository urepository )  {

			return (args) -> {
				// Your code...a dd some demo data to db
				Project project1 = new Project("Automation Testing");
				Project project2 = new Project("AI");
				Project project3 = new Project("Full Stack");
				Project project4 = new Project("Data Base");
				Project project5 = new Project("SAP Intigration");
				Project project6 = new Project("Cloud AWS ");
				
				
				repository.save(project1);
				repository.save(project2);
				repository.save(project3);
				repository.save(project4);
				repository.save(project5);
				repository.save(project6);
				
				
				Developer hhh1 = new Developer("Project manager", "Amber","Karki", "10145789", "amberark@hhhm.com","2weeks","New features Learning",
						project1);
				Developer hhh2 = new Developer("Project manager", "Shyam","Sundar", "01258974", "dev@hhhm.com","2weeks","Materials Ui",
						project2);
				Developer hhh3 = new Developer("Developer", "shyam","gotame", "045613658", "scd@hhhm.com","2weeks","Just Learing",
						project3);
				Developer hhh4 = new Developer("Scrum master", "lkd","hari", "0124578", "mang@hhhm.com","2weeks","Testing",
						project4);
				
				
				
				devRepository.save(hhh1);
				devRepository.save(hhh2);
				devRepository.save(hhh3);
				devRepository.save(hhh4);
			
				// Create users: admin/adminpassword user/userpassword
				User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@log.fi", "USER");
				User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C","admin@log.fi", "ADMIN");
				User user3 = new User("amber", "$2y$12$aEQ/a46IrRDg/CSZImaChOnUkWn0AjUBrIs1DbotSOzN2ovNscIoy","admin1@log.fi", "ADMIN");
				
				urepository.save(user1);
				urepository.save(user2);
				
			
				
			};
		}
}
		
	
