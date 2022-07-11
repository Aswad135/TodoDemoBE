package com.demo.todoappdemo.service;

import com.demo.todoappdemo.entity.Todo;
import com.demo.todoappdemo.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
public class TodoService {


    Logger logger = LoggerFactory.getLogger(TodoService.class);
    TodoRepository todoRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public ResponseEntity<Object> saveTodo(Todo todo) {
        try {
            todo = todoRepository.save(todo);
            return new ResponseEntity<>(todo, HttpStatus.OK);

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return new ResponseEntity<>("Unable to add todo.", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> saveTodo(List<Todo> todo) {
        try {
            todo = todoRepository.saveAll(todo);
            return new ResponseEntity<>(todo, HttpStatus.OK);

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return new ResponseEntity<>("Unable to add todos.", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> count() {
        try {
            Long count = todoRepository.count();
            return new ResponseEntity<>(count, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return new ResponseEntity<>("Count is not available for this entity", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> getTodoById(int id) {
        try {
            Optional<Todo> todo = todoRepository.findById(id);
            if (todo.isPresent()) {
                return new ResponseEntity<>(todo, HttpStatus.OK);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return new ResponseEntity<>("Could not find todo by id: " + id, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> getTodoByTitle(String title) {
        try {
            Optional<Todo> todo = todoRepository.findByTitle(title);
            if (todo.isPresent()) {
                return new ResponseEntity<>(todo.get(), HttpStatus.OK);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return new ResponseEntity<>("Could not find todo by title: " + title, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> getTodos() {
        try {
            List<Todo> todo = todoRepository.findAll();
            return new ResponseEntity<>(todo, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return new ResponseEntity<>("Listing not completed.", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> deleteById(int id) {
        try {
            todoRepository.deleteById(id);
            return new ResponseEntity<>("Todo with Id: " + id + " has been deleted.", HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return new ResponseEntity<>("Could not delete this todo.", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> updateTodo(Todo todo) {
        try {
            Optional<Todo> existingTodo = todoRepository.findById(todo.getId());
            if (existingTodo.isPresent()) {
                existingTodo.get().setTitle(todo.getTitle());
                existingTodo.get().setContents(todo.getContents());
                existingTodo.get().setCreatedOn(todo.getCreatedOn());
                existingTodo.get().setModifiedOn(todo.getModifiedOn());
                existingTodo.get().setDone(todo.isDone());
                Todo todo1 = todoRepository.save(existingTodo.get());
                return new ResponseEntity<>(todo1, HttpStatus.OK);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return new ResponseEntity<>("Could not update the Todo.", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> addAndReturnDummyData() {
        Todo todo = new Todo();
        todo.setTitle("Title: " + new Random().nextInt());
        todo.setContents("Contents: " + new Random().nextInt());
        todo.setCreatedOn(LocalDateTime.now());
        todo.setModifiedOn(LocalDateTime.now());
        todo.setDone(false);
        return saveTodo(todo);
    }
}
