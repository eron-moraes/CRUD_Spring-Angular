package com.eron.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.eron.todo.domain.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{

}
