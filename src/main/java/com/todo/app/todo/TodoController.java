package com.todo.app.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/todo")
public class TodoController {

    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService service){
        this.todoService = service;
    }

    @GetMapping
    public List<Todo> getAllItems(){
        return todoService.getAllTodoItems();
    }

    @GetMapping(path = "{id}")
    public Todo getTodoItem (@PathVariable("id") UUID todoId){
        return todoService.getItemById(todoId);
    }

    @PostMapping
    public void addNewItem (@RequestBody Todo item){
        todoService.addTodoItem(item);
    }

    @PutMapping(path = "{id}")
    public void updateItem (@PathVariable("id") UUID todoId, @RequestBody Todo item){
        todoService.updateTodoItem(todoId, item);
    }

    @DeleteMapping(path = "{id}")
    public void deleteId (@PathVariable("id") UUID todoId){
        todoService.deleteTodoItem(todoId);
    }
}
