package eu.strutters.example.todo.model;

import javax.persistence.*;

/**
 * TodoItem.
 *
 * @author Rene Gielen
 */
@Entity
public class TodoItem {

	Integer id;
	String topic;
	String description;
	String category;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	public Integer getId() {
		return id;
	}

	public void setId( Integer id ) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic( String topic ) {
		this.topic = topic;
	}

	@Column(length = 1024)
	public String getDescription() {
		return description;
	}

	public void setDescription( String description ) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory( String category ) {
		this.category = category;
	}
}
