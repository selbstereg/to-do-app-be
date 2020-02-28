package todoapp.todos.service.exceptions;

public class TodoListNotFoundException extends Exception {
    public TodoListNotFoundException(Long todoListId) {
        super("Todo list with id " + todoListId + " not found");
    }
}
