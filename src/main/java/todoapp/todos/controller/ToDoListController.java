package todoapp.todos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todoapp.todos.model.ToDo;
import todoapp.todos.model.ToDoList;
import todoapp.todos.service.ToDoListCrudService;
import todoapp.todos.service.exceptions.ToDoListNotFoundException;
import todoapp.todos.service.exceptions.TodoNotFoundException;

import java.util.List;

import static todoapp.todos.controller.Constants.REST_API_BASE_URL;

@RestController
@RequestMapping(REST_API_BASE_URL + "/to-do-lists")
public class ToDoListController {

    private final ToDoListCrudService toDoListService;

    @Autowired
    public ToDoListController(ToDoListCrudService toDoListService) {
        this.toDoListService = toDoListService;
    }

    @GetMapping()
    public List<ToDoList> getTodoLists() {
        return toDoListService.getTodoLists();
    }

    @GetMapping(path = "/{id}")
    public ToDoList getTodoList(@PathVariable long id) throws ToDoListNotFoundException {
        return toDoListService.getTodoList(id);
    }

    @GetMapping(path = "/{toDoListId}/to-dos")
    public List<ToDo> getTodos(@PathVariable long toDoListId) throws ToDoListNotFoundException {
        return toDoListService.getToDos(toDoListId);
    }

    @PostMapping()
    public ToDoList addToDoList(@RequestBody String listName) {
        return toDoListService.createTodoList(listName);
    }

    @PostMapping(path = "/{toDoListId}")
    public ToDo addTodo(@PathVariable long toDoListId, @RequestBody ToDo todo) throws ToDoListNotFoundException {
        return toDoListService.addTodo(toDoListId, todo);
    }

    // TODO: Rename Todo -> ToDo
    @DeleteMapping(path = "/{toDoListId}")
    public ToDoList deleteToDoList(@PathVariable("toDoListId") long toDoListId) throws ToDoListNotFoundException {
        return toDoListService.deleteToDoList(toDoListId);
    }

    @DeleteMapping(path = "/{toDoListId}/to-dos/{toDoId}")
    public ToDo deleteTodo(@PathVariable("toDoListId") long toDoListId, @PathVariable("toDoId") long toDoId) throws ToDoListNotFoundException, TodoNotFoundException {
        return toDoListService.deleteToDo(toDoListId, toDoId);
    }

    // TODO: Move this to a controller advice because of duplication with ToDoController
    @ExceptionHandler({ ToDoListNotFoundException.class, TodoNotFoundException.class })
    public ResponseEntity<String> handle(Exception exception) {
        System.out.println("Handling exception: " + exception.getMessage());
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

}
