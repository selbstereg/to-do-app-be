package todoapp.todos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todoapp.todos.model.Todo;
import todoapp.todos.model.TodoList;
import todoapp.todos.service.TodoListCrudService;
import todoapp.todos.service.exceptions.TodoListNotFoundException;
import todoapp.todos.service.exceptions.TodoNotFoundException;

import java.util.List;

import static todoapp.todos.controller.Constants.REST_API_BASE_URL;

@RestController
@RequestMapping(REST_API_BASE_URL + "/to-do-lists")
public class TodoListController {

    private final TodoListCrudService todoService;

    @Autowired
    public TodoListController(TodoListCrudService todoService) {
        this.todoService = todoService;
    }

    @GetMapping()
    public List<TodoList> getTodoLists() {
        return todoService.getTodoLists();
    }

    @GetMapping(path = "/{id}")
    public TodoList getTodoList(@PathVariable Long id) throws TodoListNotFoundException {
        return todoService.getTodoList(id);
    }

    @GetMapping(path = "/{toDoListId}/to-dos")
    public List<Todo> getTodos(@PathVariable Long toDoListId) throws TodoListNotFoundException {
        return todoService.getTodos(toDoListId);
    }

    @PostMapping(path = "/{toDoListId}")
    public Todo addTodo(@PathVariable Long toDoListId, @RequestBody Todo todo) throws TodoListNotFoundException {
        return todoService.addTodo(toDoListId, todo);
    }

    @DeleteMapping(path = "/{toDoListId}/to-dos/{toDoId}")
    public Todo deleteTodo(@PathVariable("toDoListId") Long toDoListId, @PathVariable("toDoId") Long toDoId) throws TodoListNotFoundException, TodoNotFoundException {
        return todoService.deleteTodo(toDoListId, toDoId);
    }

    @ExceptionHandler({ TodoListNotFoundException.class, TodoNotFoundException.class })
    public ResponseEntity<String> handle(Exception exception) {
        System.out.println("Handling exception: " + exception.getMessage());
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
