package com.in28minutes.rest.webservices.todo;

import com.in28minutes.rest.webservices.restfulwebservices.todo.Todo;
import com.in28minutes.rest.webservices.restfulwebservices.todo.TodoRepository;
import com.in28minutes.rest.webservices.restfulwebservices.todo.TodoService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TodoServiceMockTest {

    @Mock
    private TodoRepository repositoryMock;

    @InjectMocks
    private TodoService service;

    @Test
    void basicTest01(){
        Todo royTodo = new Todo(111,"Roy","Learn English", LocalDate.now(),false);
        List<Todo> todos= new ArrayList<>();
        todos.add(royTodo);
        when(repositoryMock.findByUsername("Roy")).thenReturn(todos);
        assertEquals(royTodo,service.findByUsername("Roy").get(0));

    }
}
