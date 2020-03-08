package todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class TodoApp {

	public static void main(String[] args) {
		SpringApplication.run(TodoApp.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry
						.addMapping("/api/**")
						.allowedOrigins(
								"http://localhost:4200",
								"http://localhost:8080",
								"https://selbstereg.github.io",
								"https://selbstereg-todo-app-frontend.herokuapp.com")
						.allowedMethods("GET", "POST", "PUT", "DELETE");
			}
		};
	}
}
