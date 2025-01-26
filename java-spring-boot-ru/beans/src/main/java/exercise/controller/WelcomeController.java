package exercise.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import exercise.daytime.Daytime;

// BEGIN
import org.springframework.beans.factory.annotation.Autowired;

@RestController
public class WelcomeController {
    @Autowired
    private Daytime daytime;
    @GetMapping("/welcome")
    public String welcome() {
        return String.format("It is %s now! Welcome to Spring!", daytime.getName());
    }
}
// END
