package todoapp.todos.model;

import todoapp.todos.service.exceptions.TodoNotFoundException;

import javax.persistence.*;
import java.util.*;

@Entity
public class ToDoList implements NamedEntity {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable=false)
    private String name;

    @OneToMany(fetch= FetchType.EAGER, cascade=CascadeType.ALL)
    private Set<ToDo> toDos = new HashSet<ToDo>();

    // For Hibernate
    private ToDoList() {}

    public ToDoList(String name) {
        this.name = name;
    }

    public void add(ToDo todo) {
        this.toDos.add(todo);
    }

    public Set<ToDo> getToDos() {
        return toDos;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    public List<ToDo> getTodosSortedByPriority() {
        List<ToDo> sortedToDos = new ArrayList<>(toDos);
        Collections.sort(sortedToDos);
        return sortedToDos;
    }

    public ToDo delete(long toDoId) throws TodoNotFoundException {
        ToDo toDoToDelete = findToDo(toDoId);
        toDos.remove(toDoToDelete);
        return toDoToDelete;
    }

    private ToDo findToDo(long toDoId) throws TodoNotFoundException {
        ToDo toDoToReturn = null;
        for (ToDo toDo : toDos) {
            if (toDo.getId().equals(toDoId)) {
                toDoToReturn = toDo;
                break;
            }
        }

        if (toDoToReturn == null) {
            throw new TodoNotFoundException(toDoId);
        }
        return toDoToReturn;
    }
}
