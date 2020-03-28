package todoapp.todos.service.exceptions;

public class TodoNotFoundException extends Exception {
    public TodoNotFoundException(long toDoId) {
        super("Todo with id " + toDoId + " not found");
    }
}
