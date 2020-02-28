package todoapp.todos.controller;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static todoapp.todos.controller.Constants.REST_API_BASE_URL;

@RestController
@RequestMapping(REST_API_BASE_URL + "/todos")
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
