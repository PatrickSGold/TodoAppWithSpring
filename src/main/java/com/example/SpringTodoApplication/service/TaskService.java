package com.example.SpringTodoApplication.service;

import com.example.SpringTodoApplication.model.Todos;
import com.example.SpringTodoApplication.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository repo;

    public List<Todos> listAll() {
        return repo.findAll();
    }

    public void save(Todos task) {
        repo.save(task);
    }

    public Todos get(int id) {
        return repo.findById(id).get();
    }

    public void delete(int id) {
        repo.deleteById(id);
    }



}
