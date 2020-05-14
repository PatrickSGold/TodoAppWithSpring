package com.example.SpringTodoApplication.model;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "todos")
public class Todo {

    private Long id;
    private String task;
    private boolean done;
    private LocalDate deadline;  // shows the date given -1 day..

    private List<SubTask> subTasks;


    public Todo() {
        subTasks = new ArrayList<>();
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

    @OneToMany(targetEntity = SubTask.class, mappedBy = "todo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    public List<SubTask> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<SubTask> subTasks) {
        this.subTasks = subTasks;
    }

    public String setColor() {
        Long daysBetween =
                Duration.between(LocalDate.now().atStartOfDay(), deadline.atStartOfDay()).toDays();

        if (daysBetween <= 1) {
            return "#FF0000";
        }
        else if (daysBetween <= 7) {
            return "#FFFF00";
        }
        else {
            return "#FFFFFF";
        }
    }
}
