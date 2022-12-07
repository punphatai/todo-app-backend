package com.dev.todoapp.taskcomplete;

import com.dev.todoapp.task.Task;
import com.dev.todoapp.trash.Trash;
import com.dev.todoapp.user.User;
import jakarta.persistence.*;

@Entity
public class TaskComplete {
    @Id
    @SequenceGenerator(
            name="taskcomplete_id_sequence",
            sequenceName = "taskcomplete_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "taskcomplete_id_sequence"
    )
    private int taskcomplete_id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @OneToOne
    @JoinColumn(name = "task_id")
    private Task task;

    public TaskComplete(int taskcomplete_id, User user, Task task) {
        this.taskcomplete_id = taskcomplete_id;
        this.user = user;
        this.task = task;
    }

    public TaskComplete(User user, Task task) {
        this.user = user;
        this.task = task;
    }

    public TaskComplete() {
    }

    public void setTaskcomplete_id(int taskcomplete_id) {
        this.taskcomplete_id = taskcomplete_id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public int getTaskcomplete_id() {
        return taskcomplete_id;
    }

    public User getUser() {
        return user;
    }

    public Task getTask() {
        return task;
    }

    @Override
    public String toString() {
        return "TaskComplete{" +
                "taskcomplete_id=" + taskcomplete_id +
                ", user=" + user +
                ", task=" + task +
                '}';
    }
}
