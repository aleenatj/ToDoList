package com.org.todo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.org.todo.model.Project;
import com.org.todo.repository.ProjectRepository;
import com.org.todo.service.ProjectService;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class ProjectServiceTest {

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private ProjectService projectService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllProjects() {
        // Given
        List<Project> projects = new ArrayList<>();
        projects.add(new Project(1L, "Project 1"));
        projects.add(new Project(2L, "Project 2"));

        when(projectRepository.findAll()).thenReturn(projects);

        // When
        List<Project> retrievedProjects = projectService.getAllProjects();

        // Then
        assertEquals(2, retrievedProjects.size());
        assertEquals("Project 1", retrievedProjects.get(0).getTitle());
        assertEquals("Project 2", retrievedProjects.get(1).getTitle());
    }
}
