package todoapp.todos.service;

import todoapp.todos.model.ToDo;
import todoapp.todos.model.ToDoList;
import todoapp.todos.service.exceptions.ToDoListNotFoundException;
import todoapp.todos.service.exceptions.TodoNotFoundException;

import java.util.List;

public interface ToDoListCrudService {

    // Create
    ToDoList createTodoList(String name);

    // Read
    List<ToDoList> getTodoLists();
    ToDoList getTodoList(Long id) throws ToDoListNotFoundException;
    List<ToDo> getToDos(Long toDoListId) throws ToDoListNotFoundException;

    // Update
    ToDo addTodo(Long toDoListId, ToDo todo) throws ToDoListNotFoundException;

    // Delete
    ToDo deleteToDo(Long toDoListId, Long toDoId) throws ToDoListNotFoundException, TodoNotFoundException;
    ToDoList deleteToDoList(Long toDoListId) throws ToDoListNotFoundException;
}
