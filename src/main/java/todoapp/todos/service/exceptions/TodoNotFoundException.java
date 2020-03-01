package todoapp.todos.service.exceptions;

public class TodoNotFoundException extends Exception {
    public TodoNotFoundException(Long toDoId) {
        super("Todo with id " + toDoId + " not found");
    }
}
