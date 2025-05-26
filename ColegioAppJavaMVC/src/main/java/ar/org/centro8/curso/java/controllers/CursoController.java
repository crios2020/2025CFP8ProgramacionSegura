package ar.org.centro8.curso.java.controllers;

import java.util.Arrays;
import java.util.List;

import org.apache.catalina.connector.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.enums.Dia;
import ar.org.centro8.curso.java.enums.Turno;
import ar.org.centro8.curso.java.repositories.CursoRepository;
import ar.org.centro8.curso.java.repositories.CursoRepository2;

@Controller
public class CursoController {
    
    private String mensaje="Ingrese un nuevo curso!";
    //private CursoRepository cursoRepository=new CursoRepository();

    @Autowired
    private CursoRepository2 cursoRepository;

    @GetMapping("/cursos")
    public String getCursos(Model model, @RequestParam(name="buscar", defaultValue = "") String buscar){
        model.addAttribute("dias", Arrays.asList(Dia.values()));
        model.addAttribute("turnos", Arrays.asList(Turno.values()));
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("curso", new Curso());
        //model.addAttribute("all", cursoRepository.findAll());
        model.addAttribute("likeTitulo", 
            ((List<Curso>)cursoRepository.findAll())
                    .stream()
                    .filter(c->c
                                    .getTitulo()
                                    .toLowerCase()
                                    .contains(buscar))
                    .toList());
        return "cursos";
    }

    @PostMapping("/cursosSave")
    public String cursosSave(@ModelAttribute Curso curso){
        //System.out.println("***************************************");
        //System.out.println(curso);
        //System.out.println("***************************************");
        
        cursoRepository.save(curso);
        if(curso.getId()>0){
            mensaje="Se guardo el curso id: "+curso.getId();
        }else{
            mensaje="Error! no se pudo guardar el curso!";
        }
        
        return "redirect:cursos";
    }

}
