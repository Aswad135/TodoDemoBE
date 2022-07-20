package com.demo.todoappdemo.service;

import com.demo.todoappdemo.dto.TodoDTO;
import com.demo.todoappdemo.dto.TodoListDTO;
import com.demo.todoappdemo.entity.Todo;
import com.demo.todoappdemo.entity.TodoList;
import com.demo.todoappdemo.mapper.TodoListMapper;
import com.demo.todoappdemo.repository.TodoListRepository;
import com.demo.todoappdemo.repository.TodoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
    TodoRepository todoRepository;

    @Autowired
    public TodoListService(TodoListRepository todoListRepository, TodoRepository todoRepository) {
        this.todoListRepository = todoListRepository;
        this.todoRepository = todoRepository;

    }


    public ResponseEntity<Object> saveTodoList(TodoListDTO todoListDTO) {
        try {
            TodoList todoList = TodoListMapper.INSTANCE.fromDTO(todoListDTO);
            Optional<TodoList> todoListOptional = todoListRepository.findById(todoList.getId());
            if (todoListOptional.isPresent()) {
                todoListOptional.get().setListOfTodos(todoList.getListOfTodos());
                todoList = todoListRepository.save(todoListOptional.get());
                todoListDTO = TodoListMapper.INSTANCE.toDTO(todoList);
                return new ResponseEntity<>(todoListDTO, HttpStatus.OK);
            } else {
                todoList = todoListRepository.save(todoList);
                todoListDTO = TodoListMapper.INSTANCE.toDTO(todoList);
                return new ResponseEntity<>(todoListDTO, HttpStatus.OK);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return new ResponseEntity<>("Unable to add todoList.", HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> getTodoLists() {
        try {
            List<TodoList> todoLists = todoListRepository.findAll();
            return new ResponseEntity<>(todoLists, HttpStatus.OK);
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return new ResponseEntity<>("Unable to fetch todoLists: ", HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<Object> getTodoListByTitle(String title) {
        try {
            Optional<TodoList> todo = todoListRepository.findByTitle(title);
            if (todo.isPresent()) {
                TodoListDTO dto = TodoListMapper.INSTANCE.toDTO(todo.get());
                return new ResponseEntity<>(dto, HttpStatus.OK);
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
                TodoListDTO dto = TodoListMapper.INSTANCE.toDTO(todo.get());
                return new ResponseEntity<>(dto, HttpStatus.OK);
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
                TodoListDTO dto = TodoListMapper.INSTANCE.toDTO(todo.get());
                return new ResponseEntity<>(dto, HttpStatus.OK);
            }
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }
        return new ResponseEntity<>("Could not find todo List by listHash: " + listHash, HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Object> addAndReturnDummyData() throws JsonProcessingException {
        TodoList todoList = new TodoList();
        todoList.setTitle("Title:" + new Random().nextInt());
        List<Todo> list = new ArrayList<>();
        list.add(new Todo("Contents: " + new Random().nextInt(), false, LocalDateTime.now(), LocalDateTime.now()));
        list.add(new Todo("Contents: " + new Random().nextInt(), false, LocalDateTime.now(), LocalDateTime.now()));

        for (Todo t : list
        ) {
            todoRepository.saveAndFlush(t);
        }
        todoList.getListOfTodos().addAll(list);
        return new ResponseEntity<>(todoListRepository.saveAndFlush(todoList), HttpStatus.OK);

    }
}
