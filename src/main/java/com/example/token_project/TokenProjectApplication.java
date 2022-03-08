package com.example.token_project;

import com.example.token_project.entity.User;
import com.example.token_project.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class TokenProjectApplication {
	@Autowired
	private UserRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(TokenProjectApplication.class, args);
	}

	@PostConstruct
public  void  initUsers(){
	List<User> users = Stream.of(
			new User(101, "miracle", "password", "miracle@gmail.com"),
			new User(102, "ebuka", "password", "ebuka@gmail.com")
	).collect(Collectors.toList());
	repository.saveAll(users);
}

}
