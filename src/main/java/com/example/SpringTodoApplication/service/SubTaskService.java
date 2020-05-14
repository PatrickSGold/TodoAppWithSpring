package com.example.SpringTodoApplication.service;

import com.example.SpringTodoApplication.model.SubTask;
import com.example.SpringTodoApplication.repository.SubTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class SubTaskService {

    @Autowired
    SubTaskRepository repo;

    public List<SubTask> listAll() {

        return repo.findAll();
    }

    public void save(SubTask subTask) {
        repo.save(subTask);
    }

    public SubTask get(Long id) {
        return repo.findById(id).get();
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }

}

