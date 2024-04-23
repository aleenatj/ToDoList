package com.org.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.todo.model.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
}
