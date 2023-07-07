package com.eron.todo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.eron.todo.domain.Todo;
import com.eron.todo.repositories.TodoRepository;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {
	
	@Autowired
	private TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		
		Todo t1 = new Todo(null, "Estudar", "Estudar SpringBoot 2 e Angular 11", LocalDateTime.parse("25/07/2023 12:00", formatter), false);
		
		todoRepository.saveAll(Arrays.asList(t1));
	}

}
