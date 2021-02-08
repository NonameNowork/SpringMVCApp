package org.example.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){

        //System.out.println("Hello, "+ name + " " + surname);

        model.addAttribute("message", "Hello, "+ name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculate(@RequestParam(value = "a") int a,
                            @RequestParam(value = "b") double b,
                            @RequestParam(value = "act") String action,
                            Model model){
        switch (action){
            case "multiplication": model.addAttribute("result", a + " * " + b + " = " + a*b); break;
            case "addiction": model.addAttribute("result", a + " + " + b + " = " + (a + b)); break;
            case "subtraction": model.addAttribute("result", a + " - " + b + " = " + (a - b)); break;
            case "division": model.addAttribute("result", a + " / " + b + " = " + a/b);
        }

        return "first/calculate";
    }
}
