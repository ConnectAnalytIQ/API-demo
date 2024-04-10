package com.example.demo.service;

import java.util.List;

public interface GenericService<T> {
    public void save(T t);
    public T findById(int id);
    public List<T> findAll();
}
