package eu.strutters.example.todo.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ModelDriven;
import eu.strutters.example.todo.model.TodoItem;
import eu.strutters.example.todo.service.TodoItemService;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

public class TodoEditAction {

	private int id;
	private TodoItem item;

	@Autowired
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
