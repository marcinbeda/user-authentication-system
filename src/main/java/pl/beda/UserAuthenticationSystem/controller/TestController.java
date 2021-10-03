package pl.beda.UserAuthenticationSystem.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// IT'S NOT IMPORTANT CLASS FOR THIS PROJECT

@RestController
@Profile("local")
public class TestController {

    @RequestMapping("/test")
    public String test() {
        return "Some test data";
    }
}
