package ar.org.centro8.curso.java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MenuController {
    
    @GetMapping("/fragments/menu")
    public String getMenu(){
        return "fragments/menu";
    }

}
