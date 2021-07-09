
package view;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"config"})
public class BrookeAndCoApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(BrookeAndCoApplication.class, args);
	}
}
