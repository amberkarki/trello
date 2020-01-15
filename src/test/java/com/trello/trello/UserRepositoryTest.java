package com.trello.trello;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.trello.trello.domai.User;
import com.trello.trello.domai.UserRepository;
@RunWith(SpringRunner.class)
@DataJpaTest
public class UserRepositoryTest {
	@Autowired
	private UserRepository usrRepo;

	@Test
	public void findUser() {
		User users = usrRepo.findByUsername("user");
		assertThat(users.getUsername()).isEqualTo("user");
	}
	
}
