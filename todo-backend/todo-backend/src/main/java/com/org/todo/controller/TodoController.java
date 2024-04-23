package com.org.todo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.org.todo.model.Todo;
import com.org.todo.service.TodoService;

import java.util.List;

@RestController
@RequestMapping("/api/todos")
public class TodoController {

	private final TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	@GetMapping
	public List<Todo> getAllTodos() {
		return todoService.getAllTodos();
	}

	@GetMapping("/{todoId}")
	public ResponseEntity<Todo> getTodoById(@PathVariable Long todoId) {
		Todo todo = todoService.getTodoById(todoId);
		return ResponseEntity.ok(todo);
	}

	@GetMapping("/project/{projectId}")
	public ResponseEntity<List<Todo>> getAllTodosByProjectId(@PathVariable Long projectId) {
		List<Todo> todos = todoService.getAllTodosByProjectId(projectId);
		return ResponseEntity.ok(todos);
	}

	@PostMapping("/{projectId}")
	public ResponseEntity<Todo> addTodoToProject(@PathVariable Long projectId, @RequestBody Todo todo) {
		Todo addedTodo = todoService.addTodoToProject(projectId, todo);
		return ResponseEntity.status(HttpStatus.CREATED).body(addedTodo);
	}

	@PutMapping("/{todoId}")
	public ResponseEntity<Todo> updateTodo(@PathVariable Long todoId, @RequestBody Todo todo) {
		Todo updatedTodo = todoService.updateTodo(todoId, todo);
		return ResponseEntity.ok(updatedTodo);
	}

	@DeleteMapping("/{todoId}")
	public ResponseEntity<?> deleteTodo(@PathVariable Long todoId) {
		todoService.deleteTodo(todoId);
		return ResponseEntity.noContent().build();
	}
}
