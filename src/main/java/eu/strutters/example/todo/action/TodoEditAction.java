package eu.strutters.example.todo.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import eu.strutters.example.todo.model.TodoItem;
import eu.strutters.example.todo.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;

public class TodoEditAction extends ActionSupport {

	private int id;
	private TodoItem item;

	@Inject
	private TodoItemService todoItemService;

	public String execute() throws Exception {
		item = todoItemService.get(id);

		return Action.SUCCESS;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TodoItem getItem() {
		return item;
	}
}
