package com.dev.todoapp.taskcomplete;

import com.dev.todoapp.task.Task;
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

}
