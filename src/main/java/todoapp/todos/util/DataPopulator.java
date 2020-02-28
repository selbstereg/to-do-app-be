package todoapp.todos.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import todoapp.todos.model.Todo;
import todoapp.todos.model.TodoList;
import todoapp.todos.repo.TodoListRepo;
import todoapp.todos.repo.TodoRepo;

@Component
public class DataPopulator {

	private TodoRepo todoRepo;
	private TodoListRepo todoListRepo;

	@Autowired
	public DataPopulator(TodoRepo todoRepo, TodoListRepo todoListRepo) {
		this.todoRepo = todoRepo;
		this.todoListRepo = todoListRepo;
	}
	
	@EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
		Todo todo = new Todo("the todo", 0);
		TodoList todoList = new TodoList("todo-list");
		todoList.add(todo);
		todoListRepo.save(todoList);
    }
	
}
