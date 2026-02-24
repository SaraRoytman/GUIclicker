package com.example.clicker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ClickerApp {

    private int count = 0;

    public static void main(String[] args) {
        SpringApplication.run(ClickerApp.class, args);
    }

    @GetMapping("/api/click")
    public int click() {
        count++;
        return count;
    }
}
