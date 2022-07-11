package com.demo.todoappdemo.controller.Implementation;

import com.demo.todoappdemo.controller.TodoController;
import com.demo.todoappdemo.entity.Todo;
import com.demo.todoappdemo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TodoControllerImp implements TodoController {

    TodoService todoService;

    @Autowired
    public TodoControllerImp(@RequestBody TodoService todoService) {
        this.todoService = todoService;
    }

    public ResponseEntity<Object> saveTodo(@RequestBody Todo todo) {
        return todoService.saveTodo(todo);
    }

    public ResponseEntity<Object> saveTodo(@RequestBody List<Todo> todo) {
        return todoService.saveTodo(todo);
    }

    public ResponseEntity<Object> count() {
        return todoService.count();
    }

    public ResponseEntity<Object> getTodoById(@PathVariable int id) {
        return todoService.getTodoById(id);
    }

    public ResponseEntity<Object> getTodoByTitle(@RequestParam String title) {
        return todoService.getTodoByTitle(title);
    }

    public ResponseEntity<Object> getTodos() {
        return todoService.getTodos();
    }

    public ResponseEntity<Object> deleteById(@PathVariable int id) {
        return todoService.deleteById(id);
    }

    public ResponseEntity<Object> updateTodo(@RequestBody Todo todo) {
        return todoService.updateTodo(todo);
    }

    public ResponseEntity<Object> addAndReturnDummyData() {
        return todoService.addAndReturnDummyData();
    }
}