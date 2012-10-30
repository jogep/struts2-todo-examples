package eu.strutters.example.todo.action;

import eu.strutters.example.todo.model.TodoItem;
import eu.strutters.example.todo.service.TodoItemService;
import org.apache.struts2.interceptor.ParameterAware;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import java.util.List;
import java.util.Map;

public class TodoListAction {

	private List<TodoItem> items;
	private String category;

	@Inject
	private TodoItemService todoItemService;


	public String execute() throws Exception {

		Criteria criteria = todoItemService.createCriteria();
		if(category != null) criteria.add(Restrictions.eq("category", category)) ;

		items = todoItemService.list(criteria);

		return "success";
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<TodoItem> getItems() {
		return items;
	}
}
