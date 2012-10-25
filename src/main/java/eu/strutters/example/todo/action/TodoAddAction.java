package eu.strutters.example.todo.action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import eu.strutters.example.todo.model.TodoItem;
import eu.strutters.example.todo.service.TodoItemService;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Result(name = Action.SUCCESS, type = "redirect", location = "todo")
public class TodoAddAction extends ActionSupport {

	private String topic;

	@Autowired
	private TodoItemService todoItemService;

	public String execute() throws Exception {

		TodoItem item = new TodoItem();
		item.setTopic(topic);
		item.setDone(false);

		todoItemService.save(item);

		return Action.SUCCESS;
	}

	public void validate() {
		super.validate();
		if (topic == null || topic.trim().length() < 1) {
			addFieldError("topic", "A Topic is required!");
		}
	}

	public List<TodoItem> getItems() {
		return todoItemService.findAll();
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {

		this.topic = topic;
	}
}
