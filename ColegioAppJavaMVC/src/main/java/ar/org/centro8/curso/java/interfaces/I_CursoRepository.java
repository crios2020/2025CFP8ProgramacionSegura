package ar.org.centro8.curso.java.interfaces;

import java.util.List;

import ar.org.centro8.curso.java.entities.Curso;

public interface I_CursoRepository {
    public abstract void save(Curso curso);
    public abstract void remove(Curso curso);
    public abstract void update(Curso curso);
    public abstract List<Curso>getAll();

    public default Curso getById(int id){
        return getAll()
                        .stream()
                        .filter(c->c.getId()==id)
                        .findFirst()
                        .orElse(new Curso());
    }

    public default List<Curso>getLikeTitulo(String titulo){
        return getAll()
                        .stream()
                        .filter(c->c
                                    .getTitulo()
                                    .toLowerCase()
                                    .contains(titulo.toLowerCase()))
                        .toList();
    }

}
