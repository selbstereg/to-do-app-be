package todoapp.todos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import todoapp.todos.model.ToDo;
import todoapp.todos.model.ToDoList;
import todoapp.todos.repo.ToDoListRepo;
import todoapp.todos.service.exceptions.ToDoListNotFoundException;
import todoapp.todos.service.exceptions.TodoNotFoundException;

import java.util.List;

@Component
public class ToDoListCrudServiceImpl implements ToDoListCrudService {

    private final ToDoListRepo toDoListRepo;

    @Autowired
    public ToDoListCrudServiceImpl(ToDoListRepo toDoListRepo) {
        this.toDoListRepo = toDoListRepo;
    }

    @Override
    public ToDoList createTodoList(String name) {
        ToDoList toDoList = new ToDoList(name);
        return toDoListRepo.save(toDoList);
    }

    @Override
    public List<ToDoList> getTodoLists() {
        return toDoListRepo.findAll();
    }

    @Override
    public ToDoList getTodoList(Long id) throws ToDoListNotFoundException {
        ToDoList toDoList = toDoListRepo.findById(id).orElseThrow(
                () -> new ToDoListNotFoundException(id)
        );
        return  toDoList;
    }

    @Override
    public ToDo addTodo(Long toDoListId, ToDo todo) throws ToDoListNotFoundException {
        ToDoList toDoList = getTodoList(toDoListId);
        toDoList.add(todo);
        toDoListRepo.save(toDoList);
        return todo;
    }

    @Override
    public List<ToDo> getToDos(Long toDoListId) throws ToDoListNotFoundException {
        ToDoList toDoList = getTodoList(toDoListId);
        return toDoList.getTodosSortedByPriority();
    }

    @Override
    public ToDo deleteToDo(Long toDoListId, Long toDoId) throws ToDoListNotFoundException, TodoNotFoundException {
        ToDoList toDoList = getTodoList(toDoListId);
        ToDo deletedToDo = toDoList.delete(toDoId);
        toDoListRepo.save(toDoList);
        return deletedToDo;
    }

    @Override
    public ToDoList deleteToDoList(Long toDoListId) throws ToDoListNotFoundException {
        ToDoList toDoList = getTodoList(toDoListId);
        toDoListRepo.delete(toDoList);
        return toDoList;
    }
}
