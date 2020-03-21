package todoapp.todos.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import todoapp.todos.model.ToDoList;

public interface ToDoListRepo extends JpaRepository<ToDoList, Long> {

}
