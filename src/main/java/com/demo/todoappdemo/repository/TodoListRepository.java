package com.demo.todoappdemo.repository;

import com.demo.todoappdemo.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TodoListRepository extends JpaRepository<TodoList, Integer> {

    Optional<TodoList> findByListHash(String hash);

    Optional<TodoList> findByTitle(String title);
}
