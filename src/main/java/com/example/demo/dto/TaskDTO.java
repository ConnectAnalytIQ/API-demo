package com.example.demo.dto;

import com.example.demo.model.Task;

public class TaskDTO {

    private int id;
    private String description;

    private boolean finished;

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Boolean isFinished(){return finished;}



    public TaskDTO(Task task){
        this.id = task.getId();
        this.description = task.getDescription();
        this.finished = task.isFinished();
    }
}
