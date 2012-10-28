package eu.strutters.example.todo.action;

import com.opensymphony.xwork2.Action;
import eu.strutters.example.todo.model.TodoItem;
import eu.strutters.example.todo.service.TodoItemService;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;

@Result(type = "json")
public class TodoDeleteAction implements Action {

	private int id;
	private TodoItem item;

	@Inject
	private TodoItemService todoItemService;

	public String execute() throws Exception {
		item = todoItemService.get(id);
		todoItemService.delete(item);

		return Action.SUCCESS;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TodoItem getItem() {
		return item;
	}
}
