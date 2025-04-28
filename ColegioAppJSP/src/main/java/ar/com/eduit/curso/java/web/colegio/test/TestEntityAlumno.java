package ar.com.eduit.curso.java.web.colegio.test;

import ar.com.eduit.curso.java.web.colegio.entities.Alumno;

public class TestEntityAlumno {
    public static void main(String[] args) {
        Alumno alumno1=new Alumno();
        alumno1.setApellido("Perez");
        System.out.println(alumno1.getApellido());
        System.out.println(alumno1);

        Alumno alumno2=new Alumno("Diego","Lopez",23,1);
        System.out.println(alumno2);

        Alumno alumno3=new Alumno(222, "María", "Mendez", 22, 1);
        System.out.println(alumno3);
        System.out.println(alumno3.getId());
        System.out.println(alumno3.getId_curso());
        
    }
}
