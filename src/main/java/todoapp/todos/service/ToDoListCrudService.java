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
    ToDoList getTodoList(long id) throws ToDoListNotFoundException;
    List<ToDo> getToDos(long toDoListId) throws ToDoListNotFoundException;

    // Update
    ToDo addTodo(long toDoListId, ToDo todo) throws ToDoListNotFoundException;

    // Delete
    ToDo deleteToDo(long toDoListId, long toDoId) throws ToDoListNotFoundException, TodoNotFoundException;
    ToDoList deleteToDoList(long toDoListId) throws ToDoListNotFoundException;
}
