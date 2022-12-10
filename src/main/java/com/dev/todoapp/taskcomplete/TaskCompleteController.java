package com.dev.todoapp.taskcomplete;

import org.springframework.web.bind.annotation.*;

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

    @PostMapping("add-task-complete-by-user-id/{user_id}/{task_id}")
    public void addTaskCompleteByUserId(@PathVariable("user_id") int user_id, @PathVariable("task_id") int task_id) {
        this.taskCompleteService.addTaskCompleteByUserId(user_id, task_id);
    }
}
