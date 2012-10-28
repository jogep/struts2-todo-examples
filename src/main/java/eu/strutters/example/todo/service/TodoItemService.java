package eu.strutters.example.todo.service;

import eu.strutters.example.todo.model.TodoItem;
import org.hibernate.Query;

import javax.inject.Named;
import java.util.List;

/**
 * TodoItemService.
 *
 * @author Rene Gielen
 */
@Named
public class TodoItemService extends GenericEntityService<TodoItem, Integer> {

	@Override
	protected Class<TodoItem> entityClass() {
		return TodoItem.class;
	}

	public List<String> findCategories(){
		Query query = getCurrentSession().createQuery("select distinct todo.category from TodoItem as todo");
		return (List<String>) query.list();
	}
}
