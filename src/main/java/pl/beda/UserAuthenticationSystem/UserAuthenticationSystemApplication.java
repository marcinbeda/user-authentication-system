package pl.beda.UserAuthenticationSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class UserAuthenticationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserAuthenticationSystemApplication.class, args);
    }

}
