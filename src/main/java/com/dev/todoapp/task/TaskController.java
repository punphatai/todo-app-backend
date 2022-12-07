package com.dev.todoapp.task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/task")
public class TaskController {

    private  final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping("")
    public List<Task> getTask(){
        return this.taskService.getTask();
    }

    @PostMapping("{user_id}")
    public void addUserTask(@PathVariable int user_id,  @RequestBody Task taskRequest){
        this.taskService.addNewUserTask(user_id, taskRequest);
    }
}
