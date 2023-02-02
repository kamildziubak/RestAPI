package pl.edu.vistula.Cwiczenia15zad2;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title = "Products API for Vistula", version="1.0", description = "Products information"))
public class FirstRestApiSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(FirstRestApiSpringApplication.class, args);
    }
}
