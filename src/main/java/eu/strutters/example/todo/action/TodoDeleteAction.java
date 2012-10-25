package eu.strutters.example.todo.action;

import com.opensymphony.xwork2.Action;
import eu.strutters.example.todo.service.TodoItemService;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

@Result(name = Action.SUCCESS, type = "redirect", location = "todo")
public class TodoDeleteAction implements Action {

	private int id;

	@Autowired
	private TodoItemService todoItemService;

	public String execute() throws Exception {
		todoItemService.delete(todoItemService.get(id));

		return Action.SUCCESS;
	}

	public void setId(int id) {
		this.id = id;
	}
}
