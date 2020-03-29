package todoapp.todos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import todoapp.todos.model.ToDo;
import todoapp.todos.repo.ToDoRepo;
import todoapp.todos.service.exceptions.TodoNotFoundException;

@Component
public class ToDoCrudServiceImpl implements ToDoCrudService {

    private final ToDoRepo toDoRepo;

    @Autowired
    public ToDoCrudServiceImpl(ToDoRepo toDoRepo) {
        this.toDoRepo = toDoRepo;
    }

    @Override
    public int updatePriority(long toDoId, int priority) throws TodoNotFoundException {
        ToDo toDo = toDoRepo.findById(toDoId).orElseThrow(
                () -> new TodoNotFoundException(toDoId)
        );
        toDo.setPriority(priority);
        toDo = toDoRepo.save(toDo);
        return toDo.getPriority();
    }
}
