package ar.com.eduit.curso.java.web.colegio.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;

import ar.com.eduit.curso.java.web.colegio.entities.Curso;

public interface I_CursoRepository {
    void save(Curso curso);
    void remove(Curso curso);
    void update(Curso curso);
    List<Curso>getAll();
    
    default Curso getById(int id){
        return getAll()
                .stream()
                .filter(curso->curso.getId()==id)
                .findAny()
                .orElse(new Curso());
    }

    default List<Curso>getLikeTitulo(String titulo){
        if(titulo==null) return new ArrayList();
        return getAll()
                        .stream()
                        .filter(curso-> curso.getTitulo()!=null && 
                                        curso.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                        .toList();
        
    }

    default List<Curso>getLikeTituloProfesor(String titulo, String profesor){
        if(titulo==null || profesor==null) return new ArrayList();
        return getAll()
                        .stream()
                        .filter(curso-> curso.getTitulo()!=null && curso.getProfesor()!=null && (
                                        curso.getTitulo().toLowerCase().contains(titulo.toLowerCase()) ||
                                        curso.getProfesor().toLowerCase().contains(profesor.toLowerCase())))
                        .toList();
    }

}
