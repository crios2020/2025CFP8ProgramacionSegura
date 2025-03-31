package ar.org.centro8.curso.java.test;
import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.enums.Dia;
import ar.org.centro8.curso.java.enums.Turno;
import ar.org.centro8.curso.java.repositories.interfaces.I_AlumnoRepository;
import ar.org.centro8.curso.java.repositories.interfaces.I_CursoRepository;
import ar.org.centro8.curso.java.repositories.jdbc.AlumnoRepository;
import ar.org.centro8.curso.java.repositories.jdbc.CursoRepository;
public class TestRepositories {
    public static void main(String[] args) {
        I_CursoRepository cr=new CursoRepository(Connector.getConnection());
        
        Curso curso=new Curso("PHP","Dieguez",Dia.VIERNES,Turno.MAÑANA);
        cr.save(curso);
        System.out.println(curso);
        
        cr.remove(cr.getById(6));
        
        curso=cr.getById(10);
        if(curso!=null && curso.getId()!=0){
            curso.setProfesor("Pereyra");
            cr.update(curso);
        }
        
        System.out.println("**************************************************");
        cr.getAll().forEach(System.out::println);
        //cr.getLikeTitulo("ja").forEach(System.out::println);
        //cr.getLikeTituloProfesor("", "di").forEach(System.out::println);
        
        System.out.println("**************************************************");
        I_AlumnoRepository ar=new AlumnoRepository(Connector.getConnection());
        Alumno alumno=new Alumno("Jeremias","Sprinfield",99,1);
        ar.save(alumno);
        System.out.println(alumno);
        
        ar.save(new Alumno("Pedro","Perez",30,1));
        ar.save(new Alumno("Laura","Perez",30,1));
        ar.save(new Alumno("Juan","Perez",30,1));
        ar.save(new Alumno("Victor","Perez",30,2));
        ar.save(new Alumno("Mariela","Perez",30,2));
        ar.save(new Alumno("Mercedez","Perez",30,3));
        
        ar.remove(ar.getById(5));
        
        alumno=ar.getById(49);
        if(alumno!=null && alumno.getId()!=0){
            alumno.setEdad(40);
            //alumno.setApellido("ttttt");
            //alumno.setApellido("'-- ");
            //alumno.setNombre("Laureana");
            alumno.setNombre("'-- ");
            ar.update(alumno);
        }
        
        System.out.println("**************************************************");
        //ar.getAll().forEach(System.out::println);
        //ar.getLikeApellido("pe").forEach(System.out::println);
        ar.getByCurso(cr.getById(1)).forEach(System.out::println);
    }
}