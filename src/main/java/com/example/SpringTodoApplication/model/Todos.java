package com.example.SpringTodoApplication.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Duration;
import java.time.LocalDate;

@Entity
public class Todos {

    private int id;
    private String task;
    private boolean done;
    private LocalDate deadline;  // shows the date given -1 day..

    public Todos() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getId() {
        return id;
    }

    public void setId(int id) {
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



    public String makeColor() {
        Long daysBetween =
                Duration.between(LocalDate.now().atStartOfDay(), deadline.atStartOfDay()).toDays();
        System.out.println(daysBetween);

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
