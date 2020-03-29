package todoapp.todos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import todoapp.todos.service.ToDoCrudService;
import todoapp.todos.service.exceptions.TodoNotFoundException;

import static todoapp.todos.controller.Constants.REST_API_BASE_URL;

@RestController
@RequestMapping(REST_API_BASE_URL + "/to-dos")
public class ToDoController {

    private final ToDoCrudService toDoService;

    @Autowired
    public ToDoController(ToDoCrudService toDoService) {
        this.toDoService = toDoService;
    }

    @PutMapping("/{toDoId}/priority")
    public int updatePriority(@PathVariable long toDoId, @RequestBody int priority) throws TodoNotFoundException {
        return toDoService.updatePriority(toDoId, priority);
    }

    // TODO: Move this to a controller advice because of duplication with ToDoListController
    @ExceptionHandler({ TodoNotFoundException.class })
    public ResponseEntity<String> handle(Exception exception) {
        System.out.println("Handling exception: " + exception.getMessage());
        return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
