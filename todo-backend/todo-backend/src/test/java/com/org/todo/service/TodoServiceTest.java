package com.org.todo.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.org.todo.model.Project;
import com.org.todo.model.Todo;
import com.org.todo.repository.ProjectRepository;
import com.org.todo.repository.TodoRepository;
import com.org.todo.service.TodoService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class TodoServiceTest {

    @Mock
    private TodoRepository todoRepository;

    @Mock
    private ProjectRepository projectRepository;

    @InjectMocks
    private TodoService todoService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGetAllTodos() {
        // Given
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo(1L, "Task 1", false, null, null, null));
        todos.add(new Todo(2L, "Task 2", true, null, null, null));

        when(todoRepository.findAll()).thenReturn(todos);

        // When
        List<Todo> retrievedTodos = todoService.getAllTodos();

        // Then
        assertEquals(2, retrievedTodos.size());
        assertEquals("Task 1", retrievedTodos.get(0).getDescription());
        assertEquals("Task 2", retrievedTodos.get(1).getDescription());
    }

    @Test
    void testGetTodoById() {
        // Given
        Todo todo = new Todo(1L, "Task 1", false, null, null, null);

        when(todoRepository.findById(1L)).thenReturn(Optional.of(todo));

        // When
        Todo retrievedTodo = todoService.getTodoById(1L);

        // Then
        assertEquals(todo, retrievedTodo);
    }

    @Test
    void testGetTodoById_NotFound() {
        // Given
        when(todoRepository.findById(1L)).thenReturn(Optional.empty());

        // When, Then
        assertThrows(IllegalArgumentException.class, () -> todoService.getTodoById(1L));
    }

    // Add tests for addTodoToProject, updateTodo, and deleteTodo methods
}
