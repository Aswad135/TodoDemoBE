package com.demo.todoappdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.time.LocalDateTime;

public class TodoDTO {
    private String contents;
    private int id;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;
}
