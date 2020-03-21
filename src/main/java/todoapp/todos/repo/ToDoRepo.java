package todoapp.todos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import todoapp.todos.model.ToDo;


public interface ToDoRepo extends JpaRepository<ToDo, Long> {

}
