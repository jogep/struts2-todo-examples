package eu.strutters.example.todo.service;

import eu.strutters.example.todo.model.TodoItem;

import javax.inject.Named;

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
}
