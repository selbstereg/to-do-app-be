package todoapp.todos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import todoapp.todos.model.Todo;
import todoapp.todos.model.TodoList;
import todoapp.todos.repo.TodoListRepo;
import todoapp.todos.service.exceptions.TodoListNotFoundException;
import todoapp.todos.service.exceptions.TodoNotFoundException;

import java.util.List;

@Component
public class TodoListCrudServiceImpl implements TodoListCrudService {

    private final TodoListRepo todoListRepo;

    @Autowired
    public TodoListCrudServiceImpl(TodoListRepo todoListRepo) {
        this.todoListRepo = todoListRepo;
    }

    @Override
    public TodoList createTodoList(String name) {
        TodoList todoList = new TodoList(name);
        return todoListRepo.save(todoList);
    }

    @Override
    public List<TodoList> getTodoLists() {
        return todoListRepo.findAll();
    }

    @Override
    public TodoList getTodoList(Long id) throws TodoListNotFoundException {
        TodoList todoList = todoListRepo.findById(id).orElseThrow(
                () -> new TodoListNotFoundException(id)
        );
        return  todoList;
    }

    @Override
    public Todo addTodo(Long todoListId, Todo todo) throws TodoListNotFoundException {
        TodoList todoList = getTodoList(todoListId);
        todoList.add(todo);
        todoListRepo.save(todoList);
        return todo;
    }

    @Override
    public List<Todo> getTodos(Long toDoListId) throws TodoListNotFoundException {
        TodoList todoList = getTodoList(toDoListId);
        return todoList.getTodosSortedByPriority();
    }

    @Override
    public Todo deleteTodo(Long toDoListId, Long toDoId) throws TodoListNotFoundException, TodoNotFoundException {
        TodoList todoList = getTodoList(toDoListId);
        Todo deletedToDo = todoList.delete(toDoId);
        todoListRepo.save(todoList);
        return deletedToDo;
    }

    @Override
    public TodoList deleteToDoList(Long toDoListId) throws TodoListNotFoundException {
        TodoList toDoList = getTodoList(toDoListId);
        todoListRepo.delete(toDoList);
        return toDoList;
    }
}
