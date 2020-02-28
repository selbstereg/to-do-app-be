package todoapp.todos.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class TodoList extends NamedEntity {

    @Id
    @GeneratedValue
    private Long id;
    @OneToMany(fetch= FetchType.EAGER, cascade=CascadeType.ALL)
    private Set<Todo> todos = new HashSet<Todo>();

    public TodoList(String name) {
        this.name = name;
    }

    public void add(Todo todo) {
        this.todos.add(todo);
    }

    public void getTodos(Set<Todo> todos) {
        this.todos = todos;
    }
}
