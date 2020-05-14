package com.example.SpringTodoApplication.repository;

import com.example.SpringTodoApplication.model.SubTask;
import org.springframework.data.jpa.repository.JpaRepository;


public interface SubTaskRepository extends JpaRepository<SubTask, Long> {
}
