package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@ResponseBody
// @RequestMapping("sub-path")
@Controller
public class HelloController {

    @GetMapping
        public String hello(){
        return "Hello, Spring";
    }

    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring";
    }

    // http://localhost:8080/hello?name=Zak
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value="hello")
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "...";
    }

    // handles request with path
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello" + name + "...";
    }

    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //submit POST request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet Me'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }



}
