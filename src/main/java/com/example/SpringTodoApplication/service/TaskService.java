package com.example.SpringTodoApplication.service;

import com.example.SpringTodoApplication.model.Todo;
import com.example.SpringTodoApplication.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository repo;

    public List<Todo> listAll() {
        return repo.findAll();
    }

    public void save(Todo task) {
        repo.save(task);
    }

    public Todo get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }





}
