package com.demo.todoappdemo.controller;

import com.demo.todoappdemo.entity.Todo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface TodoController {

    @PostMapping("/todo")
    ResponseEntity<Object> saveTodo(@RequestBody Todo todo);

    @PostMapping("/todo/list")
    ResponseEntity<Object> saveTodo(@RequestBody List<Todo> todo);

    @GetMapping("/todo/count")
    ResponseEntity<Object> count();

    @GetMapping("/todo/{id}")
    ResponseEntity<Object> getTodoById(@PathVariable int id);

    @GetMapping("/todoList")
    ResponseEntity<Object> getTodoListByTitle(@RequestParam String title);

    @GetMapping("/todoList/{id}")
    ResponseEntity<Object> getTodoListById(@PathVariable int id);

    @GetMapping("/todoList")
    ResponseEntity<Object> getTodoListByListHash(@RequestParam String listHash);

    @GetMapping("/todo/list")
    ResponseEntity<Object> getTodos();

    @DeleteMapping("/todo/delete/{id}")
    ResponseEntity<Object> deleteById(@PathVariable int id);

    @PutMapping("/todo")
    ResponseEntity<Object> updateTodo(@RequestBody Todo todo);

    @GetMapping("/todo/dummy")
    ResponseEntity<Object> addAndReturnDummyData();
}
