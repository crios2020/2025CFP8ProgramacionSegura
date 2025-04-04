package ar.com.eduit.curso.java.web.colegio.test;

import ar.com.eduit.curso.java.web.colegio.entities.Curso;
import ar.com.eduit.curso.java.web.colegio.enums.Dia;
import ar.com.eduit.curso.java.web.colegio.enums.Turno;

public class TestEntityCurso {
    public static void main(String[] args) {
        Curso curso1=new Curso();
        curso1.setTitulo("Java");
        System.out.println(curso1.getTitulo());
        System.out.println(curso1);

        Curso curso2=new Curso("Python","Rodrigo",Dia.JUEVES,Turno.NOCHE);
        System.out.println(curso2);

        Curso curso3=new Curso(55, "HTML", "Bias", Dia.LUNES, Turno.TARDE);
        System.out.println(curso3);
        System.out.println(curso3.getId());
    }
}
