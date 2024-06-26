package com.example.demo.dto;

import com.example.demo.model.Todo;

public class TodoListDTO {
    private int id;
    private String description;

    public TodoListDTO(Todo todo) {
        this.id = todo.getId();
        this.description = todo.getDescription();
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
}
