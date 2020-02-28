package todoapp.todos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import todoapp.todos.model.TodoList;

import java.util.List;

public interface TodoListRepo extends JpaRepository<TodoList, Long> {

}
