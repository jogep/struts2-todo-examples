package eu.strutters.example.todo.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import eu.strutters.example.todo.model.TodoItem;
import eu.strutters.example.todo.service.TodoItemService;
import org.apache.commons.lang.StringUtils;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

@Result(name = Action.SUCCESS, type = "redirect", location = "todo-list")
@InterceptorRef("jsonValidationWorkflowStack")
public class TodoSaveAction extends ActionSupport {

	private Integer id;
	private Date dueDate;
	private String topic;
	private String description;
	private String category;

	@Autowired
	private TodoItemService todoItemService;

	public String execute() throws Exception {

		if (id != null) {
			TodoItem item = todoItemService.get(id);
			item.setDueDate(dueDate);
			item.setCategory(category);
			item.setDescription(description);
			item.setTopic(topic);

			todoItemService.merge(item);
		} else {
			TodoItem item = new TodoItem();
			item.setTopic(topic);
			item.setDone(false);

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
