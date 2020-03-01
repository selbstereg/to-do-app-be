package todoapp.todos.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Todo implements NamedEntity, Comparable<Todo> {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable=false)
	private String name;

	@Column(nullable=false)
	private int priority;

	// For Hibernate
	private Todo() {}

	@JsonCreator
	public Todo(@JsonProperty("name") String name, @JsonProperty("priority") int priority) {
		this.name = name;
		this.priority = priority;
	}

	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Todo theOtherTodo) {
		return this.priority - theOtherTodo.priority;
	}
}
