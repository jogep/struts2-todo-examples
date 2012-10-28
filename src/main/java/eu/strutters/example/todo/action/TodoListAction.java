package eu.strutters.example.todo.action;

import eu.strutters.example.todo.model.TodoItem;
import eu.strutters.example.todo.service.TodoItemService;
import org.apache.struts2.interceptor.ParameterAware;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class TodoListAction implements ParameterAware {

	private List<TodoItem> items;
	private Map<String, String[]> parameters;

	@Inject
	private TodoItemService todoItemService;


	public String execute() throws Exception {

		items = todoItemService.findAll();
		String[] parms = {"true"};
		parameters.put("nodec", parms);

		return "success";
	}

	public List<TodoItem> getItems() {
		return items;
	}

	@Override
	public void setParameters(Map<String, String[]> parameters) {
		this.parameters = parameters;
	}
}
