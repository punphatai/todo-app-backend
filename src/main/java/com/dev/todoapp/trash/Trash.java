package com.dev.todoapp.trash;

import com.dev.todoapp.task.Task;
import com.dev.todoapp.user.User;
import jakarta.persistence.*;

@Entity
public class Trash {
    @Id
    @SequenceGenerator(
            name = "trash_id_sequence",
            sequenceName = "trash_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "trash_id_sequence"
    )
    private int trash_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public Trash(int trash_id, User user, Task task) {
        this.trash_id = trash_id;
        this.user = user;
        this.task = task;
    }

    public Trash(User user, Task task) {
        this.user = user;
        this.task = task;
    }

    public Trash() {
    }

    public void setTrash_id(int trash_id) {
        this.trash_id = trash_id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getTrash_id() {
        return trash_id;
    }

    public User getUser() {
        return user;
    }

    public Task getTask() {
        return task;
    }

    @Override
    public String toString() {
        return "Trash{" +
                "trash_id=" + trash_id +
                ", user=" + user +
                ", task=" + task +
                '}';
    }
}
