package com.example.docappointment;

		import org.springframework.boot.SpringApplication;
		import org.springframework.boot.autoconfigure.SpringBootApplication;
		import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DocAppointmentApplication {

	public static void main(String[] args) {
		SpringApplication.run(DocAppointmentApplication.class, args);
	}
}
