package eu.strutters.example.todo.action;

import com.opensymphony.xwork2.Action;
import eu.strutters.example.todo.service.TodoItemService;
import org.apache.struts2.convention.annotation.Result;
import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Inject;
import java.util.List;

@Result(type = "json")
public class TodoCategoriesAction implements Action {

	private List<String> categories;
	private String term;

	@Inject
	private TodoItemService todoItemService;

	public String execute() throws Exception {

		categories = todoItemService.findCategories(term);

		return Action.SUCCESS;
	}

	public void setTerm(String term) {
		this.term = term;
	}

	public List<String> getCategories() {
		return categories;
	}
}
