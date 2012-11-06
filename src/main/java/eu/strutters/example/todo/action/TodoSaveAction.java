package eu.strutters.example.todo.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.Preparable;
import eu.strutters.example.todo.model.TodoItem;
import eu.strutters.example.todo.service.TodoItemService;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import java.util.Date;

@Result(name = Action.SUCCESS, type = "redirect", location = "todo-list")
@InterceptorRef("jsonValidationWorkflowStack")
public class TodoSaveAction extends ActionSupport {

	@Inject
	private TodoItemService todoItemService;

	private TodoItem item = new TodoItem();

	public TodoItem getItem() {
		return item;
	}

	public String execute() throws Exception {

		if (item.getId() != null) {
			todoItemService.merge(item);
		} else {
			todoItemService.save(item);
		}

		return Action.SUCCESS;
	}

	public void validate() {
		super.validate();
		if (item.getTopic() == null) {
			addFieldError("topic", "A Topic is required!");
		}
	}

}
