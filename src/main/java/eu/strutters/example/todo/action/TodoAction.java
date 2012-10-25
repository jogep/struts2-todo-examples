package eu.strutters.example.todo.action;

import eu.strutters.example.todo.model.TodoItem;
import eu.strutters.example.todo.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class TodoAction {

	private List<TodoItem> items;

	@Autowired
	private TodoItemService todoItemService;

	public String execute() throws Exception {

		items = todoItemService.findAll();

		return "success";
	}

	public List<TodoItem> getItems() {
		return items;
	}
}
