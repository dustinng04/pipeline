package com.example.crudApplication;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {
	private static List<Todo> todos = new ArrayList<>();
	private static int count = 0;
	
	static {
		todos.add(new Todo(++count, "in28minutes", "Learn 1", LocalDate.now().plusYears(1), false));
		todos.add(new Todo(++count, "in28minutes", "Learn 2", LocalDate.now().plusYears(2), false));
		todos.add(new Todo(++count, "in28minutes", "Learn 3", LocalDate.now().plusYears(3), true));

	}
	
	public List<Todo> findByUsername(String username) {
		return todos;
	}
}
