package com.dev.todoapp.task;

import com.dev.todoapp.user.User;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Task {
    @Id
    @SequenceGenerator(
            name="task_id_sequence",
            sequenceName = "task_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "task_id_sequence"
    )
    private int task_id;
    private String task_detail;
    private LocalDate created_date;
    private LocalDate deadline_date;
    private boolean complete_status;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public Task(int task_id, String task_detail, LocalDate created_date, LocalDate deadline_date, boolean complete_status) {
        this.task_id = task_id;
        this.task_detail = task_detail;
        this.created_date = created_date;
        this.deadline_date = deadline_date;
        this.complete_status = complete_status;
    }

    public Task(String task_detail,
                LocalDate created_date,
                LocalDate deadline_date,
                boolean complete_status,
                User user) {
        this.task_detail = task_detail;
        this.created_date = created_date;
        this.deadline_date = deadline_date;
        this.complete_status = complete_status;
        this.user = user;
    }

    public Task(String task_detail, LocalDate created_date, LocalDate deadline_date, boolean complete_status) {
        this.task_detail = task_detail;
        this.created_date = created_date;
        this.deadline_date = deadline_date;
        this.complete_status = complete_status;
    }

    public Task() {
    }

    public void setTask_id(int task_id) {
        this.task_id = task_id;
    }

    public void setTask_detail(String task_detail) {
        this.task_detail = task_detail;
    }

    public void setCreated_date(LocalDate created_date) {
        this.created_date = created_date;
    }

    public void setDeadline_date(LocalDate deadline_date) {
        this.deadline_date = deadline_date;
    }

    public void setComplete_status(boolean complete_status) {
        this.complete_status = complete_status;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getTask_id() {
        return task_id;
    }

    public String getTask_detail() {
        return task_detail;
    }

    public LocalDate getCreated_date() {
        return created_date;
    }

    public LocalDate getDeadline_date() {
        return deadline_date;
    }

    public boolean isComplete_status() {
        return complete_status;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Task{" +
                "task_id=" + task_id +
                ", task_detail='" + task_detail + '\'' +
                ", created_date=" + created_date +
                ", deadline_date=" + deadline_date +
                ", complete_status=" + complete_status +
                ", user=" + user +
                '}';
    }
}
