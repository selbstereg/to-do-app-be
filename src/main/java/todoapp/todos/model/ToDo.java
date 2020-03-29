package todoapp.todos.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class ToDo implements NamedEntity, Comparable<ToDo> {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable=false)
	private String name;

	@Column(nullable=false)
	private int priority;

	// For Hibernate
	private ToDo() {}

	@JsonCreator
	public ToDo(@JsonProperty("name") String name, @JsonProperty("priority") int priority) {
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

	public int getPriority() { return priority; }

	@Override
	public int compareTo(ToDo theOtherToDo) {
		return this.priority - theOtherToDo.priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}
}
