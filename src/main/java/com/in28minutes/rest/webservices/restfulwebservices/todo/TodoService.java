package com.in28minutes.rest.webservices.restfulwebservices.todo;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	
//	private static List<Todo> todos = new ArrayList<>();

	private TodoRepository repository;

	public TodoService(TodoRepository repository) {
		this.repository = repository;
	}

	private static int todosCount = 0;

	
//	static {
//		todos.add(new Todo(++todosCount, "Neethu","Get AWS Certified",
//							LocalDate.now().plusYears(10), false ));
//		todos.add(new Todo(++todosCount, "Neethu","Learn DevOps",
//				LocalDate.now().plusYears(11), false ));
//		todos.add(new Todo(++todosCount, "Neethu","Learn Full Stack Development",
//				LocalDate.now().plusYears(12), false ));
//		todos.add(new Todo(++todosCount, "Jeffi","Learn DevOps R",
//				LocalDate.now().plusYears(11), false ));
//		todos.add(new Todo(++todosCount, "Jeffi","Learn Full Stack Development R",
//				LocalDate.now().plusYears(12), false ));
//		todos.add(new Todo(++todosCount, "Cristal","Learn ABC",
//				LocalDate.now().plusYears(1), false ));
//
//	}
	
	public List<Todo> findByUsername(String username){
//		Predicate<? super Todo> predicate =
//				todo -> todo.getUsername().equalsIgnoreCase(username);
//		return todos.stream().filter(predicate).toList();
		return repository.findByUsername(username);
	}
	
	public Todo addTodo(String username, String description, LocalDate targetDate, boolean done) {
		Todo todo = new Todo(null,username,description,targetDate,done);
//		todos.add(todo);
		repository.save(todo);
		return todo;
	}
	
	public void deleteById(int id) {
//		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
//		todos.removeIf(predicate);
		repository.deleteById(id);
	}

	public Todo findById(int id) {
//		Predicate<? super Todo> predicate = todo -> todo.getId() == id;
//		Todo todo = todos.stream().filter(predicate).findFirst().get();
//		return todo;
		return repository.findById(id).get();
	}

	public void updateTodo(Todo todo) {
//		deleteById(todo.getId());
//		todos.add(todo);
		repository.save(todo);
	}
}