package todoapp.todos.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TodoList implements NamedEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private String name;

    @OneToMany(fetch= FetchType.EAGER, cascade=CascadeType.ALL)
    private Set<Todo> todos = new HashSet<Todo>();

    // For Hibernate
    private TodoList() {}

    public TodoList(String name) {
        this.name = name;
    }

    public void add(Todo todo) {
        this.todos.add(todo);
    }

    public Set<Todo> getTodos() {
        return todos;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }
}
