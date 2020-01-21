package todoapp.todos.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todos")
public class TodosController {

	List<String> todos = new ArrayList<>();
	
	public TodosController() {
		todos.add("Lampen kaufen");
		todos.add("Teppiche kaufen?");
		todos.add("Garderobe kaufen?");
		todos.add("Vorhänge anbringen");
		todos.add("Spiegel aufhängen");
		todos.add("Rote Kästen aufhängen");
		todos.add("Bilder kaufen");
		todos.add("Bilder + Kalender aufhängen");
		todos.add("überall Filzgleiter hinmachen");
		todos.add("Ummelden (Vermieterformular nicht vergessen)");
		todos.add("Lampen anbringen");
		todos.add("Adressen ändern bei Krankenkasse, bahn, ...");
		todos.add("Kühlschrank besorgen");
		todos.add("GEZ bescheid geben");
	}

	@GetMapping()
	public List<String> getTodos() {
		return todos;
	}
	
	@PostMapping()
	public void addTodo(@RequestBody String todo) {
		todos.add(0, todo);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable int id) {
		todos.remove(id);
	}

}
