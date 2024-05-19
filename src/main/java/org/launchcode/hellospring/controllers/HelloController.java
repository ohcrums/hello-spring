package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
public class HelloController {

    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    // Handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greetingString = "Hello " + name + "!";
        model.addAttribute("greeting", greetingString);
        return "hello";
    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        model.addAttribute("greeting", "Hello, " + name + "!");
        return "hello";
    }

    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    // conditional loop
    @GetMapping("hello-names")
    public String helloNames(Model model) {
        String[] nameList = new String[]{"Jasmine", "Zachary", "Alfredo", "Tyson Fury"};
        model.addAttribute("names", nameList);

        return "hello-list";
    }

}
