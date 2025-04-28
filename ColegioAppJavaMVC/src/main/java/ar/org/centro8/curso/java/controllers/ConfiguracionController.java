package ar.org.centro8.curso.java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import ar.org.centro8.curso.java.connectors.ConnectorExample;
import ar.org.centro8.curso.java.utils.Properties;

@Controller
public class ConfiguracionController {
    
    @GetMapping("/configuracion")
    public String getConfiguracion(Model model){
        model.addAttribute("os", Properties.getSO());
        model.addAttribute("java", Properties.getJava());
        model.addAttribute("user", Properties.getUser());
        model.addAttribute("location", Properties.getLocation());
        model.addAttribute("ip", Properties.getIp());
        model.addAttribute("date", Properties.getDate());
        model.addAttribute("url", ConnectorExample.getUrl());
        return "configuracion";
    }

}
