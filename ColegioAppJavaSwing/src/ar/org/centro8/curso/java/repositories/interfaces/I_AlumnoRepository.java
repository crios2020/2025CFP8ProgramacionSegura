package ar.org.centro8.curso.java.repositories.interfaces;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public interface I_AlumnoRepository {
    void save(Alumno alumno);
    void remove(Alumno alumno);
    void update(Alumno alumno);
    List<Alumno> getAll();
    default Stream<Alumno> getStream(){
        return getAll().stream();
    }
    default Alumno getById(int id){
        return getStream().filter(a->a.getId()==id).findAny().orElse(new Alumno());
    }
    default List<Alumno> getLikeApellido(String apellido){
        if(apellido==null) return new ArrayList<Alumno>();
        return getStream()
                .filter(a->a.getApellido().toLowerCase().contains(apellido.toLowerCase()))
                .collect(Collectors.toList());
    }
    default List<Alumno> getByCurso(Curso curso){
        if(curso==null) return new ArrayList<Alumno>();
        return getStream()
                .filter(a->a.getIdCurso()==curso.getId())
                .collect(Collectors.toList());
    }
}