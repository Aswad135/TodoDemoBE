package com.demo.todoappdemo.service;

import com.demo.todoappdemo.entity.Todo;
import com.demo.todoappdemo.repository.TodoListRepository;
import com.demo.todoappdemo.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class TodoService {


    Logger logger = LoggerFactory.getLogger(TodoService.class);
    TodoRepository todoRepository;
    TodoListRepository todoListRepository;

    @Autowired
    public TodoService(TodoRepository todoRepository, TodoListRepository todoListRepository) {
        this.todoRepository = todoRepository;
        this.todoListRepository = todoListRepository;
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
                existingTodo.get().setModifiedOn(LocalDateTime.now());
                existingTodo.get().setDone(todo.isDone());
                todo = todoRepository.save(existingTodo.get());
                return new ResponseEntity<>(todo, HttpStatus.OK);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return new ResponseEntity<>("Could not update the Todo.", HttpStatus.BAD_REQUEST);
    }

}
