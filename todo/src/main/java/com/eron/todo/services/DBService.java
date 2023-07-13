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
		Todo t2 = new Todo(null, "Ler", "Ler livro de desenvolvimento pessoal", 
				LocalDateTime.parse("22/03/2024 11:11", formatter), true);
		Todo t3 = new Todo(null, "Exercicios", "Praticar exercicios fisicos",
				LocalDateTime.parse("21/03/2025 11:11", formatter), false);
		Todo t4 = new Todo(null, "Meditar", "Meditar durante 30 minutos pela manhã", 
				LocalDateTime.parse("27/03/2024 11:11", formatter), false);
		Todo t5 = new Todo(null, "Correr", "Correr 20 kilometros ", 
				LocalDateTime.parse("27/09/2024 11:11", formatter), false);
		Todo t6 = new Todo(null, "Trabalho", "Trabalho da faculdade para apresentar", 
				LocalDateTime.parse("27/05/2024 11:11", formatter), false);
		
		

		todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5, t6));

	}

}
