package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Slf4j
@RequestMapping("/demo")
public class DemoController {

    @GetMapping("/{name}")
    public String greet(@PathVariable("name") String name) {
        log.info("Inside DemoController greet >>> name >>> {}", name);
        return "Good morning! " + name;
    }

}
