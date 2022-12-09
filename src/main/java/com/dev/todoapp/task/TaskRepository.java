package com.dev.todoapp.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository
        extends JpaRepository<Task, Integer> {

    @Query("SELECT t FROM Task t where t.user.id = :user_id")
    List<Task> findTaskByUserId(@Param("user_id") int user_id);
}
