package com.trello.trello;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import com.trello.trello.web.DeveloperController;
public class SmokeTest {
@RunWith(SpringRunner.class)
@SpringBootTest
public class HellotestApplicationTests {
@Autowired
private DeveloperController controller;
@Test
public void contextLoads() throws Exception {
assertThat(controller).isNotNull();
}
}
}