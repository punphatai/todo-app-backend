package com.dev.todoapp.taskcomplete;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/task-complete")
public class TaskCompleteController {

    private final TaskCompleteService taskCompleteService;

    public TaskCompleteController(TaskCompleteService taskCompleteService) {
        this.taskCompleteService = taskCompleteService;
    }

    @GetMapping("")
    public List<TaskComplete> getTaskComplete() {
        return this.taskCompleteService.getTaskComplete();
    }
}
