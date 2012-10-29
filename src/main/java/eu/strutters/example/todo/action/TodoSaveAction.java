package eu.strutters.example.todo.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
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

	private Integer id;
	private Date dueDate;
	private String topic;
	private String description;
	private String category;

	@Inject
	private TodoItemService todoItemService;

	public String execute() throws Exception {

		TodoItem item;
		if (id != null) {
			item = todoItemService.get(id);
		} else {
			item = new TodoItem();
			item.setDone(false);
		}

		item.setDueDate(dueDate);
		item.setCategory(category);
		item.setDescription(description);
		item.setTopic(topic);

		if (id != null) {
			todoItemService.merge(item);
		} else {
			todoItemService.save(item);
		}

		return Action.SUCCESS;
	}

	public void validate() {
		super.validate();
		if (topic == null) {
			addFieldError("topic", "A Topic is required!");
		}
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public void setTopic(String topic) {
		this.topic = StringUtils.trimToNull(topic);
	}

	public void setDescription(String description) {
		this.description = StringUtils.trimToNull(description);
	}

	public void setCategory(String category) {
		this.category = StringUtils.trimToNull(category);
	}
}
