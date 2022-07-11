package com.demo.todoappdemo.service;

import com.demo.todoappdemo.entity.Todo;
import com.demo.todoappdemo.entity.TodoList;
import com.demo.todoappdemo.repository.TodoListRepository;
import com.demo.todoappdemo.repository.TodoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
public class TodoListService {


    Logger logger = LoggerFactory.getLogger(TodoListService.class);
    TodoListRepository todoListRepository;

    @Autowired
    public TodoListService(TodoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }


    public ResponseEntity<Object> saveTodoList(TodoList todoList) {
        try {
            todoList = todoListRepository.save(todoList);
            return new ResponseEntity<>(todoList, HttpStatus.OK);

        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return new ResponseEntity<>("Unable to add todoList.", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> getTodoListByTitle(String title) {
        try {
            Optional<TodoList> todo = todoListRepository.findByTitle(title);
            if (todo.isPresent()) {
                return new ResponseEntity<>(todo.get(), HttpStatus.OK);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return new ResponseEntity<>("Could not find todo List by title: " + title, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> getTodoListById(int id) {
        try {
            Optional<TodoList> todo = todoListRepository.findById(id);
            if (todo.isPresent()) {
                return new ResponseEntity<>(todo.get(), HttpStatus.OK);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return new ResponseEntity<>("Could not find todo List by id: " + id, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> getTodoListByListHash(String listHash) {
        try {
            Optional<TodoList> todo = todoListRepository.findByListHash(listHash);
            if (todo.isPresent()) {
                return new ResponseEntity<>(todo.get(), HttpStatus.OK);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return new ResponseEntity<>("Could not find todo List by listHash: " + listHash, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> addAndReturnDummyData() {
        TodoList todoList = new TodoList();
        todoList.setTitle("Title:" + new Random().nextInt());
        todoList.setListOfTodos(new ArrayList<>());
        return saveTodoList(todoList);
    }
}
