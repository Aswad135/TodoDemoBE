package com.demo.todoappdemo.model;

import com.demo.todoappdemo.entity.Todo;
import lombok.Data;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Data
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String listHash;
    private List<Todo> todoList;

}
