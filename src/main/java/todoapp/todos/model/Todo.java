package todoapp.todos.model;

import javax.persistence.*;

@Entity
public class Todo extends NamedEntity {

	@Id
	@GeneratedValue
	private Long id;
	private int priority;

	public Todo(String name, int priority) {
		this.name = name;
		this.priority = priority;
	}
}
