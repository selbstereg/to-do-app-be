package todoapp.todos.model;

import javax.persistence.*;

@Entity
public class Todo {

	@Id
	@GeneratedValue
	private Long id;
	private String title;
	
	public Todo(String title) {
		this.title = title;
	}
}
