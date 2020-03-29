package todoapp.todos.service;

import todoapp.todos.service.exceptions.TodoNotFoundException;

public interface ToDoCrudService {
    int updatePriority(long toDoId, int priority) throws TodoNotFoundException;
}
