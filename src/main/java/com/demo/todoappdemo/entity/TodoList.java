package com.demo.todoappdemo.entity;

import lombok.*;
import org.hibernate.annotations.Target;

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
    private String title = "";
    @Column(unique = true)
    private String listHash;
    @OneToMany(targetEntity = Todo.class, cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinColumn(name = "todo_list_id", referencedColumnName = "id")
    private List<Todo> ListOfTodos = new ArrayList<>();

    @PrePersist
    private void ensureListHash() {
        this.setListHash(UUID.randomUUID().toString());
    }

}
