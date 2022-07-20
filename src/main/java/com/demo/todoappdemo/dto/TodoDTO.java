package com.demo.todoappdemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class TodoDTO {
    private String contents;
    private int id;
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;
    private boolean Done;
}
