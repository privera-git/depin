package cl.privera.depin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication()
public class DepinApplication {

	public static void main(String[] args) {
		SpringApplication.run(DepinApplication.class, args);
	}

}
