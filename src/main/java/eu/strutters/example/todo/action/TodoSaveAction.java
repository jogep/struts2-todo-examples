package eu.strutters.example.todo.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import eu.strutters.example.todo.model.TodoItem;
import eu.strutters.example.todo.service.TodoItemService;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.hibernate.annotations.SourceType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

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

		TodoItem item =  todoItemService.get(id);
		item.setDueDate(dueDate);
		item.setCategory(category);
		item.setDescription(description);
		item.setTopic(topic);

		todoItemService.merge(item);
		System.out.println(item);

		return Action.SUCCESS;
	}

	public void validate() {
		super.validate();
		if (topic == null || topic.trim().length() < 1) {
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
		this.topic = topic;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setCategory(String category) {
		this.category = category;
	}
}
