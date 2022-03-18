package com.example.todolist.service;

import com.example.todolist.model.Todo;
import com.example.todolist.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoService {

    private final TodoRepository todoRepository;

    public TodoService(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public List<Todo> getTodos(){
        return todoRepository.findAll();
    }

    public void addTodo(Todo todo) {
        todoRepository.save(todo);
    }

    public void deleteTodo(Integer id) {
        todoRepository.deleteById(id);
    }

    public void updateTodo(Integer id, Todo todo) {
        Todo oldTodo=todoRepository.getById(id);
        oldTodo.setName(todo.getName());
        todoRepository.save(oldTodo);
    }
}
