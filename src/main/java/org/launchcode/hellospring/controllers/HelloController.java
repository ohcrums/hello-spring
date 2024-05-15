package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@ResponseBody
// @RequestMapping("sub-path")
@Controller
public class HelloController {

    @GetMapping("")
    public String helloForm(){
        return "<html>" +
                    "<body>" +
                        "<form action='hello' method='post'>" + //submit POST request to /hello
                            "<input type='text' name='name'>" +
                                "<select name='language' id='lang'>" +
                                    "<option value=''>Select a language</option>" +
                                    "<option value='eng'>English</option>" +
                                    "<option value='fr'>French</option>" +
                                    "<option value='sp'>Spanish</option>" +
                                    "<option value='it'>Italian</option>" +
                                    "<option value='kl'>Klingon</option>" +
                                "</select>" +
                            "<input type='submit' value='Greet Me'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

    @RequestMapping(value="hello", method = RequestMethod.POST)
    @ResponseBody
    public String helloPost(@RequestParam String name, @RequestParam String language) {
        if (name == null || name.isEmpty()) {
            name = "World";
        }
        if (language == ""){
            language = "kl";
        }
        return createMessage(name, language);
    }

    public static String createMessage(String n, String l) {
        String greeting = "";

        if (l.equals("eng")) {
            greeting = "Hello";
        }
        else if (l.equals("fr")) {
            greeting = "Bonjour";
        }
        else if (l.equals("it")) {
            greeting = "Bonjourno";
        }
        else if (l.equals("sp")) {
            greeting = "Hola";
        }
        else if (l.equals("kl")) {
            greeting = "nuqneH";
        }

        return greeting + " " + n;
    }

}
