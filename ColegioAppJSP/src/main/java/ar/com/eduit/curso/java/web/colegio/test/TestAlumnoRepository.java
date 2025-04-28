package ar.com.eduit.curso.java.web.colegio.test;

import ar.com.eduit.curso.java.web.colegio.connectors.Connector;
import ar.com.eduit.curso.java.web.colegio.entities.Alumno;
import ar.com.eduit.curso.java.web.colegio.repositories.interfaces.I_AlumnoRepository;
import ar.com.eduit.curso.java.web.colegio.repositories.interfaces.I_CursoRepository;
import ar.com.eduit.curso.java.web.colegio.repositories.jdbc.AlumnoRepository;
import ar.com.eduit.curso.java.web.colegio.repositories.jdbc.CursoRepository;

public class TestAlumnoRepository {
    public static void main(String[] args) {
        
        I_AlumnoRepository ar=new AlumnoRepository(Connector.getConnection());
        I_CursoRepository cr=new CursoRepository(Connector.getConnection());

        System.out.println("-- Método .save() --");
        Alumno alumno=new Alumno("Carolina", "Martinez", 23, 1);
        ar.save(alumno);
        System.out.println(alumno);

        System.out.println("-- Método .remove() --");
        ar.remove(ar.getById(46));

        System.out.println("-- Método .getAll() --");
        ar.getAll().forEach(System.out::println);

        System.out.println("-- Método .getLikeApellido() --");
        ar.getLikeApellido("ro").forEach(System.out::println);

        System.out.println("-- Método getLikeCurso() --");
        System.out.println(cr.getById(7));
        ar.getByCurso(cr.getById(7)).forEach(System.out::println);

        System.out.println("-- Método getCantidadAlumnos() --");
        System.out.println(ar.getCantidadAlumnos(cr.getById(7)));

    }
}
