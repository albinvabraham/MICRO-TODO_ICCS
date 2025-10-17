package com.microapp.microp1.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microapp.microp1.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long>{

}
