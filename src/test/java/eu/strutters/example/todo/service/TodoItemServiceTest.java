package eu.strutters.example.todo.service;

import eu.strutters.example.todo.model.TodoItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * TodoItemServiceTest.
 *
 * @author Rene Gielen
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-model.xml"})
public class TodoItemServiceTest {

	@Inject
	TodoItemService todoItemService;

	private static int id1 = 0;
	private static int id2 = 0;

	@Before
	public void setUp() {
		if (id1 == 0) {
			TodoItem item1 = new TodoItem();
			item1.setTopic("Todo Entry One");
			item1.setCategory("One");
			item1.setDone(false);
			item1.setDueDate(new Date());

			todoItemService.save(item1);
			id1 = item1.getId();

			TodoItem item2 = new TodoItem();
			item2.setTopic("Todo Entry Two");
			item2.setId(2);
			item2.setCategory("Two");
			item2.setDone(true);

			todoItemService.save(item2);
			id2 = item2.getId();
		}
	}

	@Test
	public void testServiceGetsInjected() throws Exception {
		assertNotNull(todoItemService);
	}

	@Test
	public void testFindAll() throws Exception {
		List<TodoItem> list = todoItemService.findAll();
		assertNotNull(list);
		assertTrue(list.size() == 2);
	}

	@Test
	public void testTodoOne() throws Exception {
		TodoItem item = todoItemService.get(id1);
		assertNotNull(item);
		assertNotNull(item.getDueDate());
		assertFalse(item.isDone());
	}

	@Test
	public void testTodoTwo() throws Exception {
		TodoItem item = todoItemService.get(id2);
		assertNotNull(item);
		assertNull(item.getDueDate());
		assertTrue(item.isDone());
	}

	@Test
	public void testCategoriesQuery() throws Exception {
		List<String> list = todoItemService.findCategories("T");
		assertNotNull(list);
		assertTrue(list.size() == 1);
	}
}
