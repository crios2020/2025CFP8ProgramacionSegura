package ar.org.centro8.curso.java.test;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.repositories.AlumnoRepository;
import ar.org.centro8.curso.java.repositories.CursoRepository;

public class TestApiStream {
    public static void main(String[] args) {
        CursoRepository cr=new CursoRepository();
        AlumnoRepository ar=new AlumnoRepository();
        //ar.save(new Alumno(0,"Paula","Gonzalez",23,1));
        //select * from alumnos
        System.out.println("----------------------------------");
        ar.getAll().stream().forEach(System.out::println);

        //select * from alumnos where nombre='paula'
        System.out.println("----------------------------------");
        ar
            .getAll()
            .stream()
            .filter(a->a.getNombre().toLowerCase().equals("paula"))
            .forEach(System.out::println);
    
        //select * from alumnos where nombre='paula' and apellido='gonzalez'
        System.out.println("----------------------------------");
        //ar
        //    .getAll()
        //    .stream()
        //    .filter(a->a.getNombre().toLowerCase().equals("paula")
        //            && a.getApellido().toLowerCase().equals("gonzalez"))
        //    .forEach(System.out::println);
        

        ar
            .getAll()
            .stream()
            .filter(a->a.getNombre().toLowerCase().equals("paula"))
            .filter(a->a.getApellido().toLowerCase().equals("gonzalez"))
            .forEach(System.out::println);
        
        //select * from alumnos where nombre='paula' or apellido='gonzalez'
        System.out.println("----------------------------------");
        ar
            .getAll()
            .stream()
            .filter(a->a.getNombre().toLowerCase().equals("paula")
                    || a.getApellido().toLowerCase().equals("gonzalez"))
            .forEach(System.out::println);

        //select * from alumnos where edad>=30 and edad<=40
        System.out.println("----------------------------------");


    }
}
