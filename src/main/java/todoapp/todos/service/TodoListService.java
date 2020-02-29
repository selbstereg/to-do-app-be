package todoapp.todos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import todoapp.todos.model.Todo;
import todoapp.todos.model.TodoList;
import todoapp.todos.repo.TodoListRepo;
import todoapp.todos.service.exceptions.TodoListNotFoundException;

import java.util.List;

@Component
public class TodoListService {

    private final TodoListRepo todoListRepo;

    @Autowired
    public TodoListService(TodoListRepo todoListRepo) {
        this.todoListRepo = todoListRepo;
    }

    public TodoList createTodoList(String name) {
        TodoList todoList = new TodoList(name);
        return todoListRepo.save(todoList);
    }

    public List<TodoList> getTodoLists() {
        return todoListRepo.findAll();
    }

    public TodoList getTodoList(Long id) throws TodoListNotFoundException {
        TodoList todoList = todoListRepo.findById(id).orElseThrow(
                () -> new TodoListNotFoundException(id)
        );
        return  todoList;
    }

    public TodoList addTodo(Long todoListId, Todo todo) throws TodoListNotFoundException {
        TodoList todoList = getTodoList(todoListId);
        todoList.add(todo);
        return todoListRepo.save(todoList);
    }
}
