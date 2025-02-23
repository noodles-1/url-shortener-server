package me.chowlong.smolbackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmolBackendController {
    @GetMapping("/")
    public String test() {
        return "Hello World";
    }
}
