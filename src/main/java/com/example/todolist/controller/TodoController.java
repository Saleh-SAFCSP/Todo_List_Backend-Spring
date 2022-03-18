package com.example.todolist.controller;

import com.example.todolist.model.Todo;
import com.example.todolist.service.TodoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;

@RestController
@RequestMapping("api/v1/")
@CrossOrigin(origins = "*")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping("todos")
    public ResponseEntity<?> getTodo(){
        return ResponseEntity.status(200).body(todoService.getTodos());
    }

    @PostMapping("todos")
    public ResponseEntity<?> addTodo(@RequestBody Todo todo){
        todoService.addTodo(todo);
        HashMap hashMap=new HashMap();
        hashMap.put("message","New todo added");
        return ResponseEntity.status(200).body(hashMap);
    }

    @PutMapping("todos/{id}")
    public ResponseEntity<?> updateTodo(@RequestBody Todo todo,@PathVariable Integer id){
        todoService.updateTodo(id,todo);
        HashMap hashMap=new HashMap();
        hashMap.put("message","Todo Updated");
        return ResponseEntity.status(200).body(hashMap);
    }

    @DeleteMapping("todos/{id}")
    public ResponseEntity<?> deleteTodo(@PathVariable Integer id){
        todoService.deleteTodo(id);
        HashMap hashMap=new HashMap();
        hashMap.put("message","Todo deleted");
        return ResponseEntity.status(200).body(hashMap);
    }
}
