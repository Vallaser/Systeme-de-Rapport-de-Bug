package qv.fr.uphf.BugTracking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class BugTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BugTrackingApplication.class, args);
	}
	
	@GetMapping("/hello")
	 public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
	 return String.format("Hello %s!", name);
	 }

	//https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.repositories

}
