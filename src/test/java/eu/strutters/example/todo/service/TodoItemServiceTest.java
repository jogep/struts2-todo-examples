package eu.strutters.example.todo.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

import static org.junit.Assert.assertNotNull;

/**
 * TodoItemServiceTest.
 *
 * @author Rene Gielen
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/spring-model.xml"})
public class TodoItemServiceTest {

	@Inject TodoItemService todoItemService;

	@Test
	public void testServiceGetsInjected() throws Exception {
	    assertNotNull(todoItemService);
	}
}
