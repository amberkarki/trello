package com.trello.trello.domai;
import java.util.List;

import org.springframework.data.repository.CrudRepository;





public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);

}