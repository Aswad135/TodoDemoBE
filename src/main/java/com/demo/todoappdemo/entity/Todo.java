package com.demo.todoappdemo.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String contents;
    private boolean isDone;
    private LocalDateTime createdOn = LocalDateTime.now();
    private LocalDateTime modifiedOn = LocalDateTime.now();

    public Todo(String contents, boolean isDone, LocalDateTime createdOn, LocalDateTime modifiedOn) {
        this.contents = contents;
        this.isDone = isDone;
        this.createdOn = createdOn;
        this.modifiedOn = modifiedOn;
    }
}
