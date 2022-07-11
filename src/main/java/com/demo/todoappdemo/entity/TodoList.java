package com.demo.todoappdemo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TodoList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String title;
    @Column(unique = true)
    private String listHash;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Todo> ListOfTodos;

    @PrePersist
    private void ensureListHash() {
        this.setListHash(UUID.randomUUID().toString());
        ensureTodoList();
    }

    private void ensureTodoList() {
        this.setListOfTodos(new ArrayList<>());
    }
}
