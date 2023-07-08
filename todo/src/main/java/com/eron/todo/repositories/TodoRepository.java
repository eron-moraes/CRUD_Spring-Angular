package com.eron.todo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eron.todo.domain.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer>{

}
