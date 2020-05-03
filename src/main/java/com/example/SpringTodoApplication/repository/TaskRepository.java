package com.example.SpringTodoApplication.repository;

import com.example.SpringTodoApplication.model.Todos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Todos, Integer> {
}
