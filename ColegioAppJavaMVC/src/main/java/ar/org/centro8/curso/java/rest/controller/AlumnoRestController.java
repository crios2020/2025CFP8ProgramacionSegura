package ar.org.centro8.curso.java.rest.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.repositories.AlumnoRepository;

@RestController
public class AlumnoRestController {

    AlumnoRepository ar=new AlumnoRepository();

    //TODO manejo de parámetros de entrada
    @RequestMapping("/api/v1/alumnos")
    public List<Alumno>getAll(){
        return ar.getAll();
    }

}
