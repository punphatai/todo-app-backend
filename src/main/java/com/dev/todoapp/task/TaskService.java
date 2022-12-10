package com.dev.todoapp.task;
import com.dev.todoapp.user.User;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getTask() {
        return this.taskRepository.findAll();
    }

    public void addNewUserTask(int user_id,
                               Task taskRequest) {
        User user = new User(user_id);
        Task task = new Task(
                taskRequest.getTask_detail(),
                LocalDate.now(),
                LocalDate.now(),
                false,
                false,
                user
        );
        taskRepository.save(task);
    }

    public List<Task> getTaskByUserId(int user_id) {
        return this.taskRepository.findTaskByUserId(user_id);
    }

    public void deleteTaskByUserId(int user_id) {

    }
}
