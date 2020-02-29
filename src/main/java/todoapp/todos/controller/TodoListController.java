package todoapp.todos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todoapp.todos.model.TodoList;
import todoapp.todos.service.TodoListService;
import todoapp.todos.service.exceptions.TodoListNotFoundException;

import java.util.List;

import static todoapp.todos.controller.Constants.REST_API_BASE_URL;

@RestController
@RequestMapping(REST_API_BASE_URL + "/todo-lists")
public class TodoListController {

    private final TodoListService todoListService;

    @Autowired
    public TodoListController(TodoListService todoListService) {
        this.todoListService = todoListService;
    }

    @GetMapping()
    public List<TodoList> getTodoLists() {
        return todoListService.getTodoLists();
    }

    @GetMapping(path = "/{id}")
    public TodoList getTodoList(@PathVariable Long id) throws TodoListNotFoundException {
        return todoListService.getTodoList(id);
    }

    @ExceptionHandler(TodoListNotFoundException.class)
    public ResponseEntity<String> handle(TodoListNotFoundException exception) {
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
