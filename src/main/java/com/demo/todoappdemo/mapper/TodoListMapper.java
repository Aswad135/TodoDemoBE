package com.demo.todoappdemo.mapper;

import com.demo.todoappdemo.dto.TodoDTO;
import com.demo.todoappdemo.dto.TodoListDTO;
import com.demo.todoappdemo.entity.Todo;
import com.demo.todoappdemo.entity.TodoList;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public abstract class TodoListMapper {

    public abstract TodoListDTO toDTO(TodoList todo);

    @InheritInverseConfiguration(name = "toDTO")
    public abstract TodoList fromDTO(TodoListDTO todoListDTO);
}
