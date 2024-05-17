package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
    //handle request at path http://localhost:8080/hello

//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//    }

    //handle request at path //http://localhost:8080/goodbye
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye(){
        return "Goodbye, Spring!";
    }

    //handle requests of the form http://localhost:8080/hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";
    }

    //handle requests of the form http://localhost:8080/hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("what")
    public String iterativeMethod(Model model) {
        String[] coffeeOptions = new String[]{"French Roast", "Espresso", "Kopi Luwak", "Instant"};

        model.addAttribute("coffeeOptions", coffeeOptions);

        return "iterative";
    }

    @GetMapping("blocky")
    public String blockyMethod(Model model) {
        String[] coffeeOptions = new String[]{"French Roast", "Espresso", "Kopi Luwak", "Instant"};

        model.addAttribute("coffeeOptions", coffeeOptions);

        return "blocky";
    }

}
