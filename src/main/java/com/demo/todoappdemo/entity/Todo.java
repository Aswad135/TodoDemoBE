package com.demo.todoappdemo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    private LocalDateTime createdOn;
    private LocalDateTime modifiedOn;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private TodoList listHash;
}
