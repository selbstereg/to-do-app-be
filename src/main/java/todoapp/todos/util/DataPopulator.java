package todoapp.todos.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import todoapp.todos.model.ToDo;
import todoapp.todos.model.ToDoList;
import todoapp.todos.repo.ToDoListRepo;
import todoapp.todos.repo.ToDoRepo;

@Component
public class DataPopulator {

	private ToDoRepo toDoRepo;
	private ToDoListRepo toDoListRepo;

	@Autowired
	public DataPopulator(ToDoRepo toDoRepo, ToDoListRepo toDoListRepo) {
		this.toDoRepo = toDoRepo;
		this.toDoListRepo = toDoListRepo;
	}
	
	@EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
		ToDo toDo1 = new ToDo("Botaufstrich", 0);
		ToDo toDo2 = new ToDo("Brot", 2);
		ToDo toDo3 = new ToDo("Milch", 1);
		ToDoList toDoList = new ToDoList("Einkaufsliste");
		toDoList.add(toDo1);
		toDoList.add(toDo2);
		toDoList.add(toDo3);
		toDoListRepo.save(toDoList);
    }
	
}
