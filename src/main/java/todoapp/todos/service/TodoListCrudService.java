package todoapp.todos.service;

import todoapp.todos.model.Todo;
import todoapp.todos.model.TodoList;
import todoapp.todos.service.exceptions.TodoListNotFoundException;
import todoapp.todos.service.exceptions.TodoNotFoundException;

import java.util.List;

public interface TodoListCrudService {

    // Create
    public TodoList createTodoList(String name);

    // Read
    public List<TodoList> getTodoLists();
    public TodoList getTodoList(Long id) throws TodoListNotFoundException;
    public List<Todo> getTodos(Long toDoListId) throws TodoListNotFoundException;

    // Update
    public Todo addTodo(Long todoListId, Todo todo) throws TodoListNotFoundException;
    public Todo deleteTodo(Long toDoListId, Long toDoId) throws TodoListNotFoundException, TodoNotFoundException;
}
