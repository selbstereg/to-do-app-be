package todoapp.todos.service;

import todoapp.todos.model.Todo;
import todoapp.todos.model.TodoList;
import todoapp.todos.service.exceptions.TodoListNotFoundException;
import todoapp.todos.service.exceptions.TodoNotFoundException;

import java.util.List;

public interface TodoListCrudService {

    // Create
    TodoList createTodoList(String name);

    // Read
    List<TodoList> getTodoLists();
    TodoList getTodoList(Long id) throws TodoListNotFoundException;
    List<Todo> getTodos(Long toDoListId) throws TodoListNotFoundException;

    // Update
    Todo addTodo(Long todoListId, Todo todo) throws TodoListNotFoundException;

    // Delete
    Todo deleteTodo(Long toDoListId, Long toDoId) throws TodoListNotFoundException, TodoNotFoundException;
    TodoList deleteToDoList(Long toDoListId) throws TodoListNotFoundException;
}
