package todoapp.todos.service.exceptions;

public class ToDoListNotFoundException extends Exception {
    public ToDoListNotFoundException(Long toDoListId) {
        super("Todo list with id " + toDoListId + " not found");
    }
}
