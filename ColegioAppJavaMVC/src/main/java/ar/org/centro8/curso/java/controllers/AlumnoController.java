package ar.org.centro8.curso.java.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.repositories.AlumnoRepository;
import ar.org.centro8.curso.java.repositories.CursoRepository;

@Controller
public class AlumnoController{
    
    private String mensaje="Ingrese un nuevo alumno!";
    private AlumnoRepository alumnoRepository=new AlumnoRepository();
    private CursoRepository cursoRepository=new CursoRepository();

    @GetMapping("/alumnos")
    public String getAlumnos(Model model, @RequestParam(name="buscar", defaultValue = "") String buscar){
        Alumno alumno=new Alumno();
        alumno.setEdad(18);
        model.addAttribute("mensaje", mensaje);
        model.addAttribute("alumno", alumno);
        model.addAttribute("cursos", cursoRepository.getAll());
        model.addAttribute("likeApellido", alumnoRepository.getLikeApellido(buscar));
        return "alumnos";
    }

    @PostMapping("/alumnosSave")
    public String alumnosSave(@ModelAttribute Alumno alumno){
        System.out.println("***************************************");
        System.out.println(alumno);
        System.out.println("***************************************");
        alumnoRepository.save(alumno);
        if(alumno.getId()>0){
            mensaje="Se guardo el alumno id: "+alumno.getId();
        }else{
            mensaje="Error! No se pudo guardar el alumno!";
        }
        return "redirect:alumnos";
    }

}