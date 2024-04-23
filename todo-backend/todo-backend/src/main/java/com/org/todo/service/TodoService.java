package com.org.todo.service;

import org.springframework.stereotype.Service;

import com.org.todo.model.Project;
import com.org.todo.model.Todo;
import com.org.todo.repository.ProjectRepository;
import com.org.todo.repository.TodoRepository;

import java.util.List;

@Service
public class TodoService {

	private final TodoRepository todoRepository;
	private final ProjectRepository projectRepository;

	public TodoService(TodoRepository todoRepository, ProjectRepository projectRepository) {
		this.todoRepository = todoRepository;
		this.projectRepository = projectRepository;
	}

	public List<Todo> getAllTodos() {
		return todoRepository.findAll();
	}

	public Todo getTodoById(Long todoId) {
		return todoRepository.findById(todoId).orElseThrow(() -> new IllegalArgumentException("Todo not found"));
	}

	public Todo addTodoToProject(Long projectId, Todo todo) {
		Project project = projectRepository.findById(projectId)
				.orElseThrow(() -> new IllegalArgumentException("Project not found"));
		todo.setProject(project);
		return todoRepository.save(todo);
	}
	
	List<Todo> findByProjectId(Long projectId);

	public Todo updateTodo(Long todoId, Todo todo) {
		Todo existingTodo = getTodoById(todoId);
		existingTodo.setDescription(todo.getDescription());
		existingTodo.setStatus(todo.isStatus());
		return todoRepository.save(existingTodo);
	}

	public void deleteTodo(Long todoId) {
		todoRepository.deleteById(todoId);
	}

	public List<Todo> getAllTodosByProjectId(Long projectId) {
		return todoRepository.findByProjectId(projectId);
	}
}
