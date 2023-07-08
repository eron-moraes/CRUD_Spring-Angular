package com.eron.todo.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eron.todo.domain.Todo;
import com.eron.todo.repositories.TodoRepository;

@Service
public class DBService {

	@Autowired
	private TodoRepository todoRepository;

	public void instanciaBaseDeDados() {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

		Todo t1 = new Todo(null, "Estudar", "Estudar SpringBoot 2 e Angular 11",
				LocalDateTime.parse("25/08/2023 11:11", formatter), false);

		todoRepository.saveAll(Arrays.asList(t1));

	}

}
