package com.demo.todoappdemo.mapper;

import com.demo.todoappdemo.dto.TodoDTO;
import com.demo.todoappdemo.dto.TodoListDTO;
import com.demo.todoappdemo.entity.Todo;
import com.demo.todoappdemo.entity.TodoList;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class TodoListMapper {

    public TodoListMapper INSTANCE = Mappers.getMapper(TodoListMapper.class);

    public abstract TodoListDTO toDTO(TodoList todo);

    @InheritInverseConfiguration(name = "toDTO")
    public abstract TodoList fromDTO(TodoListDTO todoListDTO);
}
