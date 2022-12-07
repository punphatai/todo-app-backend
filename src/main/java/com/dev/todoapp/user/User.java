package com.dev.todoapp.user;

import com.dev.todoapp.task.Task;
import com.dev.todoapp.taskcomplete.TaskComplete;
import com.dev.todoapp.trash.Trash;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @SequenceGenerator(
            name="user_id_sequence",
            sequenceName = "customer_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "user_id_sequence"
    )
    private Integer user_id;
    private String username;
    private String email;
    private String password;

    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "user_id")
    private List<Task> tasks;
    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "trash_id_sequence")
    private List<Trash> trashes;
    @OneToMany
    @JsonIgnore
    @JoinColumn(name = "taskcomplete_id")
    private List<TaskComplete> taskCompletes;

    public User(Integer user_id, String username, String email, String password) {
        this.user_id = user_id;
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(Integer user_id) {
        this.user_id = user_id;
    }

    public User() {
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void setTrashes(List<Trash> trashes) {
        this.trashes = trashes;
    }

    public void setTaskCompletes(List<TaskComplete> taskCompletes) {
        this.taskCompletes = taskCompletes;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public List<Trash> getTrashes() {
        return trashes;
    }

    public List<TaskComplete> getTaskCompletes() {
        return taskCompletes;
    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}