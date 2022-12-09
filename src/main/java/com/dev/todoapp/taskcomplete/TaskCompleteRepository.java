package com.dev.todoapp.taskcomplete;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.Optional;

public interface TaskCompleteRepository
        extends JpaRepository<TaskComplete, Integer> {

//    @Query("SELECT * FROM task_complete")
//    Collection<TaskComplete> findTaskCompleteByUserId(int user_id);
}
