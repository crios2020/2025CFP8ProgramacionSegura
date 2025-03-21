package ar.org.centro8.curso.java.repositories.interfaces;
import ar.org.centro8.curso.java.entities.Curso;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public interface I_CursoRepository {
    void save(Curso curso);
    void remove(Curso curso);
    void update(Curso curso);
    List<Curso> getAll();
    default Stream<Curso> getStream(){
        return getAll().stream();
    }
    default Curso getById(int id){
        return getStream().filter(c->c.getId()==id).findAny().orElse(new Curso());
    }
    default List<Curso> getLikeTitulo(String titulo){
        if(titulo==null) return new ArrayList<Curso>();
        return getStream()
                .filter(c->c.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .collect(Collectors.toList());
    }
    default List<Curso> getLikeTituloProfesor(String titulo, String profesor){
        if(titulo==null || profesor==null) return new ArrayList<Curso>();
        return getStream()
                .filter(c->c.getTitulo().toLowerCase().contains(titulo.toLowerCase())
                        && c.getProfesor().toLowerCase().contains(profesor.toLowerCase()))
                .collect(Collectors.toList());
    }
}