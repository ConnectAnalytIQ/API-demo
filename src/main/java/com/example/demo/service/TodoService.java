package com.example.demo.service;


import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.demo.model.Todo;

@Service
public class TodoService implements GenericService<Todo>{

    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private TaskRepository taskRepository;

    @Override
    public void save(Todo todo) {
        todo.setDate(new Date());
        todoRepository.save(todo);
    }

    @Override
    public Todo findById(int id) {
        Optional<Todo> response= todoRepository.findById(id);
        if(response.isPresent()){
            return response.get();
        }
        return null;
    }

    @Override
    public List<Todo> findAll() {
        return todoRepository.findAll();
    }

    public void addTask(int id, Task task){
        Optional<Todo> todo=todoRepository.findById(id);
        if(todo.isPresent()){
            Todo t= todo.get();
            List<Task> tasks=t.getTasks();
            task.setTodo(t);
            taskRepository.save(task);
        }
    }

    public void updateTask(int id){
        Optional<Task> task=taskRepository.findById(id);
        if(task.isPresent()){
            Task t = task.get();
            t.setFinished(!t.isFinished());
            taskRepository.save(t);
        }
    }

    public void updateTodo(int id){
        Optional<Todo> todo = todoRepository.findById(id);
        if (todo.isPresent()) {
            Todo t = todo.get();
            List<Task> tasks = t.getTasks();
            boolean allTasksCompleted = tasks.stream().allMatch(Task::isFinished);
            if (allTasksCompleted) {
                t.setFinished(true);
                todoRepository.save(t);
            }
        }
    }

}
