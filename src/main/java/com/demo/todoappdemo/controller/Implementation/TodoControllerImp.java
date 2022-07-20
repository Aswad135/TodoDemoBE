package com.demo.todoappdemo.controller.Implementation;

import com.demo.todoappdemo.controller.TodoController;
import com.demo.todoappdemo.dto.TodoDTO;
import com.demo.todoappdemo.dto.TodoListDTO;
import com.demo.todoappdemo.entity.Todo;
import com.demo.todoappdemo.entity.TodoList;
import com.demo.todoappdemo.repository.TodoListRepository;
import com.demo.todoappdemo.service.TodoListService;
import com.demo.todoappdemo.service.TodoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.OnError;
import java.util.List;

@RestController
public class TodoControllerImp implements TodoController {

    TodoService todoService;
    TodoListService todoListService;

    @Autowired
    public TodoControllerImp(TodoService todoService, TodoListService todoListService) {
        this.todoService = todoService;
        this.todoListService = todoListService;
    }

    @Override
    public ResponseEntity<Object> saveTodo(@RequestBody TodoDTO todo) {
        return todoService.saveTodo(todo);
    }

    @Override
    public ResponseEntity<Object> saveTodo(@RequestBody List<Todo> todo) {
        return todoService.saveTodo(todo);
    }

    @Override
    public ResponseEntity<Object> saveTodoList(TodoListDTO todoList) {
        return todoListService.saveTodoList(todoList);
    }

    @Override
    public ResponseEntity<Object> count() {
        return todoService.count();
    }


    @Override
    public ResponseEntity<Object> getTodoById(@PathVariable int id) {
        return todoService.getTodoById(id);
    }

    @Override
    public ResponseEntity<Object> getTodoListByTitle(@RequestParam String title) {
        return todoListService.getTodoListByTitle(title);
    }

    @Override
    public ResponseEntity<Object> getTodoListById(int id) {
        return todoListService.getTodoListById(id);
    }

    @Override
    public ResponseEntity<Object> getTodoListByListHash(String listHash) {
        return todoListService.getTodoListByListHash(listHash);
    }

    @Override
    public ResponseEntity<Object> getTodos() {
        return todoService.getTodos();
    }

    @Override
    public ResponseEntity<Object> getTodoLists() {
        return todoListService.getTodoLists();
    }

    @Override
    public ResponseEntity<Object> deleteById(@RequestParam int id) {
        return todoService.deleteById(id);
    }

    @Override
    public ResponseEntity<Object> updateTodo(@RequestBody Todo todo) {
        return todoService.updateTodo(todo);
    }

    @Override
    public ResponseEntity<Object> addAndReturnDummyData() {
        try {
            return todoListService.addAndReturnDummyData();
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
