package todoapp.todos.repo;

import org.springframework.data.repository.CrudRepository;
import todoapp.todos.model.TodoList;

import java.util.List;

public interface TodoListRepo extends CrudRepository<TodoList, Long> {

    public List<TodoList> findAll();

}
