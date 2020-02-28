package todoapp.todos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import todoapp.todos.model.Todo;


public interface TodoRepo extends JpaRepository<Todo, Long> {

}
