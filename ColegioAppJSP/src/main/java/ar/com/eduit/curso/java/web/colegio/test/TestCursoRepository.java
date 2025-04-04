package ar.com.eduit.curso.java.web.colegio.test;

import ar.com.eduit.curso.java.web.colegio.connectors.Connector;
import ar.com.eduit.curso.java.web.colegio.entities.Curso;
import ar.com.eduit.curso.java.web.colegio.enums.Dia;
import ar.com.eduit.curso.java.web.colegio.enums.Turno;
import ar.com.eduit.curso.java.web.colegio.repositories.interfaces.I_CursoRepository;
import ar.com.eduit.curso.java.web.colegio.repositories.jdbc.CursoRepository;
import ar.com.eduit.curso.java.web.colegio.utils.ColoresAnsi;

public class TestCursoRepository {

    public static void main(String[] args) {
        I_CursoRepository cr=new CursoRepository(Connector.getConnection());

        System.out.println("-- Método save() --");
        Curso curso=new Curso("Herreria","Farias",Dia.VIERNES,Turno.MAÑANA);
        cr.save(curso);
        System.out.println(curso);
        if(curso.getId()>0) System.out.println(ColoresAnsi.ANSI_GREEN+"OK - Método save()"+ColoresAnsi.ANSI_RESET);
        else                System.out.println(ColoresAnsi.ANSI_RED+"ERROR - Método save()"+ColoresAnsi.ANSI_RESET);

        System.out.println("-- Método remove() --");
        int cantidadInicial=cr.getAll().size();
        cr.remove(cr.getById(65));

        System.out.println("-- Método update() --");
        curso=cr.getById(63);
        curso.setDia(Dia.LUNES);
        cr.update(curso);


        System.out.println("-- Método getAll()  --");
        cr.getAll().forEach(System.out::println);

        System.out.println("-- Método getLikeTitulo() --");
        cr.getLikeTitulo("ja").forEach(System.out::println);

        System.out.println("-- Método getLikeTituloProfesor() --");
        cr.getLikeTituloProfesor("ja", "ri").forEach(System.out::println);

    }
}
