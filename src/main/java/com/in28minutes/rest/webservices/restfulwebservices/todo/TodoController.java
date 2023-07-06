package com.in28minutes.rest.webservices.restfulwebservices.todo;

import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000", allowCredentials = "true")
public class TodoController {

    TodoService service;

    public TodoController(TodoService service) {
        this.service = service;
    }

    @GetMapping("/users/{username}/todos")
    public List<Todo> retrieveListOfAllTodos(@PathVariable String username){
        return service.findByUsername(username);
    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo retrieveSingleUserTodo(@PathVariable String username, @PathVariable int id){
        return service.findById(id);
    }

    @DeleteMapping("/users/{username}/todo/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable int id){
        service.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
