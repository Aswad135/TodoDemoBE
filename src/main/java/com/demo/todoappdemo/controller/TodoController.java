package com.demo.todoappdemo.controller;

import com.demo.todoappdemo.dto.TodoDTO;
import com.demo.todoappdemo.dto.TodoListDTO;
import com.demo.todoappdemo.entity.Todo;
import com.demo.todoappdemo.entity.TodoList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface TodoController {

    @PostMapping("/todo")
    ResponseEntity<Object> saveTodo(@RequestBody TodoDTO todo);

    @PostMapping("/todo/list")
    ResponseEntity<Object> saveTodo(@RequestBody List<Todo> todo);


    @PostMapping("/todoList/list")
    ResponseEntity<Object> saveTodoList(@RequestBody TodoListDTO todoList);


    @GetMapping("/todo/count")
    ResponseEntity<Object> count();

    @GetMapping("/todo/{id}")
    ResponseEntity<Object> getTodoById(@PathVariable int id);

    @GetMapping("/todoList/title")
    ResponseEntity<Object> getTodoListByTitle(@RequestParam String title);

    @GetMapping("/todoList/{id}")
    ResponseEntity<Object> getTodoListById(@PathVariable int id);

    @GetMapping("/todoList/listHash")
    ResponseEntity<Object> getTodoListByListHash(@RequestParam String listHash);

    @GetMapping("/todo/list")
    ResponseEntity<Object> getTodos();

    @GetMapping("/todoList/list")
    ResponseEntity<Object> getTodoLists();

    @GetMapping("/todo/delete")
    ResponseEntity<Object> deleteById(@RequestParam int id);

    @PutMapping("/todo")
    ResponseEntity<Object> updateTodo(@RequestBody Todo todo);

    @GetMapping("/todo/dummy")
    ResponseEntity<Object> addAndReturnDummyData();
}
