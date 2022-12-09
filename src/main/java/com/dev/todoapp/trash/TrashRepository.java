package com.dev.todoapp.trash;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TrashRepository
        extends JpaRepository<Trash, Integer> {
}
