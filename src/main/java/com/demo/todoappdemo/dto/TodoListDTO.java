package com.demo.todoappdemo.dto;


import com.demo.todoappdemo.entity.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoListDTO {
    private int id;
    private String title;
    private String listHash;
    private List<Todo> ListOfTodos = new ArrayList<>();
}
