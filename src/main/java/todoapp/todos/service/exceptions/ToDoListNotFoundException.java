package todoapp.todos.service.exceptions;

public class ToDoListNotFoundException extends Exception {
    public ToDoListNotFoundException(long toDoListId) {
        super("Todo list with id " + toDoListId + " not found");
    }
}
