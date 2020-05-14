package com.example.SpringTodoApplication.repository;

import com.example.SpringTodoApplication.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Todo, Long> {
}
