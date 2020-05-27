package com.todo.app.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TodoService {
    private final TodoDataAccessService dataService;

    @Autowired
    public TodoService(TodoDataAccessService dataService){
        this.dataService = dataService;
    }

    List<Todo> getAllTodoItems() {
        return dataService.getAllTodo();
    }

    Todo getItemById (UUID todoId){
        return dataService.getItemById(todoId);
    }

    void addTodoItem (Todo item){
        dataService.insertTodoItem(UUID.randomUUID(), item);
    }

    void updateTodoItem(UUID todoId, Todo item) {
        dataService.updateTodoItem(todoId, item);
    }

    void deleteTodoItem(UUID todoId){
        dataService.deleteItemById(todoId);
    }
}
