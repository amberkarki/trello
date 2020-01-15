package com.trello.trello;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.trello.trello.web.DeveloperController;
@RunWith(SpringRunner.class)
@SpringBootTest
class TrelloApplicationTests {
	@Autowired 
	private DeveloperController controller;

	@Test
	void contextLoads() {
		assertThat(controller).isNotNull();
	}

}
