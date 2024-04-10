package com.example.demo.controller;


import com.example.demo.dto.TodoDTO;
import com.example.demo.dto.TodoListDTO;
import com.example.demo.model.Task;
import com.example.demo.model.Todo;
import com.example.demo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;


    @GetMapping("/hello")
    public ResponseEntity<String> hello(){
        return ResponseEntity.ok("Hello World");
    }

    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody Todo todo){
        todoService.save(todo);
        return ResponseEntity.ok("Todo Created");
    }

    @GetMapping("/list")
    public ResponseEntity<?> list(){
        List<Todo> todos= todoService.findAll();
        List<TodoListDTO> response=new ArrayList<>();
        for (Todo todo:
             todos) {
            response.add(new TodoListDTO(todo));
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<?> find(@PathVariable int id){
        Todo t= todoService.findById(id);
        if(t==null){
            return new ResponseEntity<>("Todo not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(new TodoDTO(t));
    }

    @PostMapping("/addTask/{id}")
    public ResponseEntity<String> addTask(@PathVariable int id, @RequestBody Task task){
        todoService.addTask(id, task);
        return ResponseEntity.ok("Task Added");
    }

    @PutMapping("/updateTask/{id}")
    public ResponseEntity<String> updateTask(@PathVariable int id){
        todoService.updateTask(id);
        return ResponseEntity.ok("Task Updated");
    }
}
