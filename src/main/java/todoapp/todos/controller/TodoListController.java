package todoapp.todos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import todoapp.todos.model.TodoList;
import todoapp.todos.service.TodoListService;

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

}
