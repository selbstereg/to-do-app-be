package todoapp.todos.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import todoapp.todos.model.Todo;
import todoapp.todos.repo.TodoRepo;

@Component
public class DataPopulator {

	private TodoRepo todoRepo;

	public DataPopulator(@Autowired TodoRepo todoRepo) {
		this.todoRepo = todoRepo;
	}
	
	@EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
		todoRepo.save(new Todo("asdf :)"));
    }
	
}
