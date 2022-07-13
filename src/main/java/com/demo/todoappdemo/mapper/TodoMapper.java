package com.demo.todoappdemo.mapper;

import com.demo.todoappdemo.dto.TodoDTO;
import com.demo.todoappdemo.entity.Todo;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class TodoMapper {

    TodoMapper INSTANCE = Mappers.getMapper(TodoMapper.class);

    public abstract TodoDTO toDTO(Todo todo);

    @InheritInverseConfiguration(name = "toDTO")
    public abstract Todo fromDTO(TodoDTO todoDTO);
}
