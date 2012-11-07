package eu.strutters.example.todo.action;

import com.opensymphony.xwork2.Action;
import eu.strutters.example.todo.model.TodoItem;
import eu.strutters.example.todo.service.TodoItemService;
import org.apache.struts2.interceptor.ParameterAware;
import org.hibernate.Criteria;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class TodoListAction implements Action {

	private List<TodoItem> items;
	private String category;
	private Date dueDate;

	public void setDueDate( Date dueDate ) {
		this.dueDate = dueDate;
	}

	@Inject
	private TodoItemService todoItemService;


	public String execute() throws Exception {

		Criteria criteria = todoItemService.createCriteria();
		if(category != null) criteria.add(Restrictions.eq("category", category)) ;
		if(dueDate != null) criteria.add(Restrictions.eq("dueDate", dueDate)) ;

		items = todoItemService.list(criteria);

		return SUCCESS;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<TodoItem> getItems() {
		return items;
	}
}
