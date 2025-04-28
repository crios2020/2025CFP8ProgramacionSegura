package ar.com.eduit.curso.java.web.colegio.test;

import java.util.Comparator;
import java.util.List;

import ar.com.eduit.curso.java.web.colegio.connectors.Connector;
import ar.com.eduit.curso.java.web.colegio.entities.Alumno;
import ar.com.eduit.curso.java.web.colegio.entities.Curso;
import ar.com.eduit.curso.java.web.colegio.repositories.jdbc.AlumnoRepository;
import ar.com.eduit.curso.java.web.colegio.repositories.jdbc.CursoRepository;

public class TestApiStream {
    public static void main(String[] args) {
        
        List<Alumno>listaAlumnos=new AlumnoRepository(Connector.getConnection()).getAll();
        List<Curso>listaCursos=new CursoRepository(Connector.getConnection()).getAll();

        //listaAlumnos.forEach(System.out::println);
        //listaCursos.forEach(System.out::println);

        //ApiStream
        
        //select * from alumnos
        System.out.println("***************************************************");
        //listaAlumnos.forEach(System.out::println);
        listaAlumnos.stream().forEach(System.out::println);

        //select * from alumnos where nombre='jorge'
        System.out.println("***************************************************");
        listaAlumnos
                    .stream()
                    .filter(a->a.getNombre().equalsIgnoreCase("jorge"))
                    .forEach(System.out::println);
        
        //select * from alumnos where nombre like 'j%'
        System.out.println("***************************************************");
        listaAlumnos
                    .stream()
                    .filter(a->a.getNombre().toLowerCase().startsWith("j"))
                    .forEach(System.out::println);

                
        //select * from alumnos where nombre like 'ju%'
        System.out.println("***************************************************");
        listaAlumnos
                    .stream()
                    .filter(a->a.getNombre().toLowerCase().startsWith("ju"))
                    .forEach(System.out::println);

        //select * from alumnos where nombre like '%a'
        System.out.println("***************************************************");
        listaAlumnos
                    .stream()
                    .filter(a->a.getNombre().toLowerCase().endsWith("a"))
                    .forEach(System.out::println);
        
        //select * from alumnos where nombre like '%ar%'
        System.out.println("***************************************************");
        listaAlumnos
                    .stream()
                    .filter(a->a.getNombre().toLowerCase().contains("ar"))
                    .forEach(System.out::println);
        
        //select * from alumnos where nombre='juan' and apellido='perez'
        System.out.println("***************************************************");
        // listaAlumnos
        //             .stream()
        //             .filter(a-> a.getNombre().equalsIgnoreCase("juan") &&
        //                         a.getApellido().equalsIgnoreCase("perez"))
        //             .forEach(System.out::println);
        listaAlumnos
                    .stream()
                    .filter(a->a.getNombre().equalsIgnoreCase("juan"))
                    .filter(a->a.getApellido().equalsIgnoreCase("perez"))
                    .forEach(System.out::println);
        
        //select * from alumnos where nombre='juan' or apellido='perez'
        System.out.println("***************************************************");            
        listaAlumnos
                    .stream()
                    .filter(a-> a.getNombre().equalsIgnoreCase("juan") ||
                                a.getApellido().equalsIgnoreCase("perez"))
                    .forEach(System.out::println);

        //select * from alumnos where nombre='juan' and edad>=30
        System.out.println("***************************************************"); 
        listaAlumnos
                    .stream()
                    .filter(a->a.getNombre().equalsIgnoreCase("juan"))
                    .filter(a->a.getEdad()>=30)
                    .forEach(System.out::println);
        
        //select * from alumnos where edad between 30 and 40;
        System.out.println("***************************************************"); 
        listaAlumnos
                    .stream()
                    .filter(a->a.getEdad()>=30)
                    .filter(a->a.getEdad()<=40)
                    .forEach(System.out::println);

        //select * from alumnos where edad not between 30 and 40;
        System.out.println("***************************************************"); 
        listaAlumnos
                    .stream()
                    .filter(a->a.getEdad()<30 || a.getEdad()>40)
                    .forEach(System.out::println);
        
        //select * from alumnos order by edad
        System.out.println("***************************************************"); 
        listaAlumnos
                    .stream()
                    .sorted(Comparator.comparingInt(Alumno::getEdad))
                    .forEach(System.out::println);

        //select * from alumnos order by edad desc
        System.out.println("***************************************************"); 
        listaAlumnos
                    .stream()
                    .sorted(Comparator.comparingInt(Alumno::getEdad).reversed())
                    .forEach(System.out::println);

        //select * from alumnos order by apellido, nombre
        System.out.println("***************************************************"); 
        // listaAlumnos
        //             .stream()
        //             .sorted(Comparator.comparing(Alumno::getApellido).thenComparing(Alumno::getNombre))
        //             .forEach(System.out::println);
        listaAlumnos
                    .stream()
                    .sorted(Comparator.comparing(Alumno::getNombre))
                    .sorted(Comparator.comparing(Alumno::getApellido))
                    .forEach(System.out::println);
        
        //select * from alumnos where id_curso=1 order by apellido, nombre
        System.out.println("***************************************************"); 
        listaAlumnos
                    .stream()
                    .filter(a->a.getId_curso()==1)
                    .sorted(Comparator.comparing(Alumno::getNombre))
                    .sorted(Comparator.comparing(Alumno::getApellido))
                    .forEach(System.out::println);


        //select min(edad) from alumnos
        System.out.println("***************************************************"); 
        int edadMinima=listaAlumnos
                                    .stream()
                                    .min(Comparator.comparingInt(Alumno::getEdad))
                                    .get()
                                    .getEdad();
        System.out.println("edadMínima: "+edadMinima);             

        //select max(edad) from alumnos
        System.out.println("***************************************************"); 
        int edadMaxima=listaAlumnos
                                    .stream()
                                    .max(Comparator.comparingInt(Alumno::getEdad))
                                    .get()
                                    .getEdad();
        System.out.println("edadMáxima: "+edadMaxima);  
        
        //select count(*) from alumnos
        System.out.println("***************************************************"); 
        int cantidad=(int)listaAlumnos
                                    .stream()
                                    .count();
        System.out.println("cantidad: "+cantidad);
        
        //select * from alumnos where edad=(select min(edad) from alumnos);
        System.out.println("***************************************************"); 
        // System.out.println(listaAlumnos              //no hacer esto
        //                                 .stream()
        //                                 .min(Comparator.comparingInt(Alumno::getEdad))
        //                                 .get());
        listaAlumnos
                    .stream()
                    .filter(a->a.getEdad()==edadMinima)
                    .forEach(System.out::println);

                    
    }
}
