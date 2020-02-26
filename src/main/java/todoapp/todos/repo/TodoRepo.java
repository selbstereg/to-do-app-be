package todoapp.todos.repo;

import todoapp.todos.model.Todo;

import org.springframework.data.repository.CrudRepository;


public interface TodoRepo extends CrudRepository<Todo, Long> {

}
