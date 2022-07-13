package com.demo.todoappdemo.mapper;

import com.demo.todoappdemo.dto.TodoDTO;
import com.demo.todoappdemo.entity.Todo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;

@Mapper
public abstract class TodoMapper {

    public abstract TodoDTO toDTO(Todo todo);

    @InheritInverseConfiguration(name = "toDTO")
    public abstract Todo fromDTO(TodoDTO todoDTO);
}
