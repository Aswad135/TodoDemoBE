package com.demo.todoappdemo.model;

import com.demo.todoappdemo.entity.Todo;
import com.demo.todoappdemo.entity.TodoList;
import lombok.Data;

import java.util.List;

@Data
public class TodoListModel {
    private TodoList listHash;
    private List<Todo> todoList;
}
