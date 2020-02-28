package todoapp.todos.model;

import javax.persistence.*;

@Entity
public class Todo implements NamedEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable=false)
	private String name;

	@Column(nullable=false)
	private int priority;

	// For Hibernate
	private Todo() {}

	public Todo(String name, int priority) {
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
}
