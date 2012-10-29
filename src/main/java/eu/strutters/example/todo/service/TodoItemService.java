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

	@SuppressWarnings("unchecked")
	public List<String> findCategories(String term) {
		Query query = getCurrentSession().createQuery("select distinct todo.category from TodoItem as todo where lower(todo.category) like :term");
		query.setString("term", "%" + term.toLowerCase() + "%");
		return (List<String>) query.list();
	}
}
