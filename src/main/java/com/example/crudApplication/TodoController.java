package com.example.crudApplication;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class TodoController {
	
	@Autowired
//	private TodoRepository repository;
	private TodoService service;
	
	@Autowired
	private AuthenService authentication;

	public TodoController(TodoService service, AuthenService authentication) {
		super();
		this.service = service;
		this.authentication = authentication;
	}

	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@PostMapping("login")
	public String welcomePage(@RequestParam String username, @RequestParam String password, ModelMap model) {
		//login? name&pass
		if (authentication.authenticate(username, password)) {
			model.put("username", username);
			model.put("password", password);	
			return "welcome";			
		}
		model.put("errorMessage", "Invalid Credentials! Try again");
		return "login";
	}
	
	@GetMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		List<Todo> list = service.findByUsername("in28minutes");
		model.addAttribute("todos", list);
		return "listTodos";
	}
	
	
}
