package teste.aular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@SpringBootApplication
public class AularApplication {

	public static void main(String[] args) {
		SpringApplication.run(AularApplication.class, args);
	}

}
