package eu.strutters.example.todo.action.mobile;

import eu.strutters.example.todo.model.TodoItem;
import eu.strutters.example.todo.service.TodoItemService;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import javax.inject.Inject;
import java.util.List;

public class TodoListAction {

	private List<TodoItem> items;

	@Inject
	private TodoItemService todoItemService;


	public String execute() throws Exception {

		items = todoItemService.findAll();

		return "success";
	}

	public List<TodoItem> getItems() {
		return items;
	}
}
