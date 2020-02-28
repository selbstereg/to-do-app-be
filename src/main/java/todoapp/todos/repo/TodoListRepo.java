package todoapp.todos.repo;

import org.springframework.data.repository.CrudRepository;
import todoapp.todos.model.TodoList;

public interface TodoListRepo extends CrudRepository<TodoList, Long> {

}
