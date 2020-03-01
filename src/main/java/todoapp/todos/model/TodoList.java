package todoapp.todos.model;

import todoapp.todos.service.exceptions.TodoNotFoundException;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

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

    public List<Todo> getTodosSortedByPriority() {
        List<Todo> sortedTodos = new ArrayList<>(todos);
        Collections.sort(sortedTodos);
        return sortedTodos;
    }

    public Todo delete(Long toDoId) throws TodoNotFoundException {
        Todo toDoToDelete = findToDo(toDoId);
        todos.remove(toDoToDelete);
        return toDoToDelete;
    }

    private Todo findToDo(Long toDoId) throws TodoNotFoundException {
        List<Todo> filteredToDos = todos
                            .stream()
                            .filter(toDo -> toDo.getId() == toDoId)
                            .collect(Collectors.toList());
        if (filteredToDos.size() == 0) {
            throw new TodoNotFoundException(toDoId);
        }
        return filteredToDos.get(0);
    }
}
