package com.pyxis.ui.customer;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@Configuration
@Controller
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class Application {

    @RequestMapping(value = "/", method = GET)
    public String index() {
        return "index.html";
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
