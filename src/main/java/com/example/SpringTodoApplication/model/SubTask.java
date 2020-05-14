package com.example.SpringTodoApplication.model;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;


@Entity
@Table(name = "sub_tasks")
public class SubTask {

    private Long id;
    private String task;
    private boolean done;
    private LocalDate deadline;
    private Long todo_id;

    private Todo todo;

    public SubTask() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    @ManyToOne
    @JoinColumn(name = "todo_id", nullable = false, referencedColumnName = "id",
            insertable = false, updatable = false)
    public Todo getTodo() {
        return todo;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }

    public Long getTodo_id() {
        return todo_id;
    }

    public void setTodo_id(Long todo_id) {
        this.todo_id = todo_id;
    }

    public String setColor() {
        Long daysBetween =
                Duration.between(LocalDate.now().atStartOfDay(), deadline.atStartOfDay()).toDays();

        if (daysBetween <= 1) {
            return "#FF0000";
        } else if (daysBetween <= 7) {
            return "#FFFF00";
        } else {
            return "#FFFFFF";
        }
    }


}




