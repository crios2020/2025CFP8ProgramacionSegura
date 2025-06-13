package ar.org.centro8.curso.java.test;

import java.util.Comparator;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.repositories.AlumnoRepository;
import ar.org.centro8.curso.java.repositories.CursoRepository;

public class TestApiStream {
    public static void main(String[] args) {
        CursoRepository cr=new CursoRepository();
        AlumnoRepository ar=new AlumnoRepository();
        //ar.save(new Alumno(0,"Martina","Coronado",35,1));
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
        //select * from alumnos where edad between 30 and 40
        System.out.println("----------------------------------");
        ar
            .getAll()
            .stream()
            .filter(a->a.getEdad()>=30)
            .filter(a->a.getEdad()<=40)
            .forEach(System.out::println);

        //select * from alumnos where edad not between 30 and 40
        System.out.println("----------------------------------");
        ar
            .getAll()
            .stream()
            .filter(a->a.getEdad()<30 || a.getEdad()>40)
            .forEach(System.out::println);

        //select * from alumnos where nombre like 'a%'
        System.out.println("----------------------------------");
        ar
            .getAll()
            .stream()
            .filter(a->a.getNombre().toLowerCase().startsWith("a"))
            .forEach(System.out::println);

        //select * from alumnos where nombre like '%a'
        System.out.println("----------------------------------");
        ar
            .getAll()
            .stream()
            .filter(a->a.getNombre().toLowerCase().endsWith("a"))
            .forEach(System.out::println);

        //select * from alumnos where nombre like '%ar%'
        System.out.println("----------------------------------");
        ar
            .getAll()
            .stream()
            .filter(a->a.getNombre().toLowerCase().contains("ar"))
            //.forEach(a->System.out.println(a));
            .forEach(System.out::println);

        //select * from alumnos order by apellido
        System.out.println("----------------------------------");
        ar
            .getAll()
            .stream()
            .sorted(Comparator.comparing(Alumno::getApellido))
            .forEach(System.out::println);
        
        //select * from alumnos order by apellido, nombre desc
        System.out.println("----------------------------------");
        ar
            .getAll()
            .stream()
            .sorted(Comparator.comparing(Alumno::getNombre).reversed())
            .sorted(Comparator.comparing(Alumno::getApellido))
            .forEach(System.out::println);

        //select * from alumnos where edad<40 order by apellido, nombre desc
        System.out.println("----------------------------------");
        ar
            .getAll()
            .stream()
            .filter(a->a.getEdad()<40)
            .sorted(Comparator.comparing(Alumno::getNombre).reversed())
            .sorted(Comparator.comparing(Alumno::getApellido))
            .forEach(System.out::println);
        
        //select max(edad) from alumnos
        System.out.println("----------------------------------");
        int edadMaxima=ar
            .getAll()
            .stream()
            .max(Comparator.comparing(Alumno::getEdad))
            .get()
            .getEdad();
        System.out.println(edadMaxima);

        //select * from alumnos where edad=(select max(edad) from alumnos)
        System.out.println("----------------------------------");
        ar
            .getAll()
            .stream()
            .filter(a->a.getEdad()==edadMaxima)
            .forEach(System.out::println);

    }
}
