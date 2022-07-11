package com.demo.todoappdemo.repository;

import com.demo.todoappdemo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Integer> {

    Optional<Todo> findByTitle(String title);
}

