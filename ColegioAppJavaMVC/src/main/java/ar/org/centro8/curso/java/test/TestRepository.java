package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.enums.Dia;
import ar.org.centro8.curso.java.enums.Turno;
import ar.org.centro8.curso.java.repositories.AlumnoRepository;
import ar.org.centro8.curso.java.repositories.CursoRepository;

public class TestRepository {
    public static void main(String[] args) {
        CursoRepository cursoRepository=new CursoRepository();

        System.out.println("-- Test Curso Repository --");
        System.out.println("-- Método .save() --");
        Curso curso=new Curso(
                                    0,
                                    "Java",
                                    "Torres",
                                    Dia.LUNES,
                                    Turno.NOCHE);
        cursoRepository.save(curso);
        System.out.println(curso);

        System.out.println("-- Método .getById --");
        System.out.println(cursoRepository.getById(8));

        System.out.println("-- Método remove() --");
        cursoRepository.remove(cursoRepository.getById(30));

        System.out.println("-- Método getLikeTitulo --");
        cursoRepository.getLikeTitulo("ja").forEach(System.out::println);

        System.out.println("-- Método .getAll() --");
        cursoRepository.getAll().forEach(System.out::println);

        System.out.println("-- Test Alumno Repository --");
        AlumnoRepository alumnoRepository=new AlumnoRepository();
        
        System.out.println("-- Método .save() --");
        Alumno alumno=new Alumno(
                                    0,
                                    "Cristian",
                                    "Cabrera",
                                    26,
                                    1);
        alumnoRepository.save(alumno);
        System.out.println(alumno);

        System.out.println("-- Método .getById() --");
        System.out.println(alumnoRepository.getById(5));

        System.out.println("-- Método remove() --");
        alumnoRepository.remove(alumnoRepository.getById(8));

        System.out.println("-- Método getLikeApellido() --");
        alumnoRepository.getLikeApellido("ez").forEach(System.out::println);

        System.out.println("-- Método .getAll() --");
        alumnoRepository.getAll().forEach(System.out::println);


    }
}
