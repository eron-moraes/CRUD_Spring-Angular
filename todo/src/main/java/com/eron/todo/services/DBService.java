package com.eron.todo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

	public void instanciaBaseDeDados() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");		

		Todo t1 = new Todo(null, "Estudar", "Estudar SpringBoot 2 e Angular 11",
				sdf.parse("25/08/2023"), false);
		Todo t2 = new Todo(null, "Ler", "Ler livro de desenvolvimento pessoal", 
				sdf.parse("22/03/2024"), true);
		Todo t3 = new Todo(null, "Exercicios", "Praticar exercicios fisicos",
				sdf.parse("21/03/2025"), false);
		Todo t4 = new Todo(null, "Meditar", "Meditar durante 30 minutos pela manhã", 
				sdf.parse("27/03/2024"), false);
		Todo t5 = new Todo(null, "Correr", "Correr 20 kilometros ", 
				sdf.parse("27/09/2024"), false);
		Todo t6 = new Todo(null, "Trabalho", "Trabalho da faculdade para apresentar", 
				sdf.parse("27/05/2024"), false);
		
		

		todoRepository.saveAll(Arrays.asList(t1, t2, t3, t4, t5, t6));

	}

}
