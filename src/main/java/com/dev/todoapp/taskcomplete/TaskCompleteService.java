package com.dev.todoapp.taskcomplete;

import com.dev.todoapp.task.Task;
import com.dev.todoapp.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskCompleteService {

    private  final TaskCompleteRepository taskCompleteRepository;

    public TaskCompleteService(TaskCompleteRepository taskCompleteRepository) {
        this.taskCompleteRepository = taskCompleteRepository;
    }

    public List<TaskComplete> getTaskComplete() {
        return this.taskCompleteRepository.findAll();
    }

    public void addTaskCompleteByUserId(int user_id, int task_id) {
        User user = new User(user_id);
        Task task = new Task(task_id);
        TaskComplete taskComplete = new TaskComplete(
                user,
                task
        );
        this.taskCompleteRepository.save(taskComplete);
    }
}
