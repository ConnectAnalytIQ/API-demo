package com.example.demo.dto;

import com.example.demo.model.Task;
import com.example.demo.model.Todo;

import java.util.ArrayList;
import java.util.List;

public class TodoDTO {
    private int id;
    private String description;

    private List<TaskDTO> tasks;

    private boolean finished;

    public TodoDTO(Todo t){
        this.id = t.getId();
        this.description = t.getDescription();
        this.tasks= new ArrayList<>();
        for (Task task: t.getTasks()
        ) {
            tasks.add(new TaskDTO(task));
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<TaskDTO> getTasks() {
        return tasks;
    }
    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }

    public boolean isFinished(){
        boolean finished=true;
        for(TaskDTO t:tasks){
            if(!t.isFinished()){
                finished=false;
            }
        }
        return finished;
    }
}
