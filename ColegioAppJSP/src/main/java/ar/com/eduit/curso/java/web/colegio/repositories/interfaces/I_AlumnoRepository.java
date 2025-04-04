package ar.com.eduit.curso.java.web.colegio.repositories.interfaces;

import java.util.ArrayList;
import java.util.List;

import ar.com.eduit.curso.java.web.colegio.entities.Alumno;
import ar.com.eduit.curso.java.web.colegio.entities.Curso;

public interface I_AlumnoRepository {
    void save(Alumno alumno);
    void remove(Alumno alumno);
    void update(Alumno alumno);
    List<Alumno>getAll();
    
    default Alumno getById(int id){
        return getAll()
                        .stream()
                        .filter(alumno->alumno.getId()==id)
                        .findAny()
                        .orElse(new Alumno());
    }

    default List<Alumno>getLikeApellido(String apellido){
        if(apellido==null) return new ArrayList();
        return getAll()
                        .stream()
                        .filter(alumno->alumno.getApellido()!=null && 
                                        alumno.getApellido().toLowerCase().contains(apellido.toLowerCase()))
                        .toList();
    }
    
    default List<Alumno>getLikeApellidoNombre(String apellido, String nombre){
        if(apellido==null || nombre==null) return new ArrayList();
        return getAll()
                        .stream()
                        .filter(alumno->alumno.getApellido()!=null && alumno.getNombre()!=null && (
                                        alumno.getApellido().toLowerCase().contains(apellido.toLowerCase())) ||
                        				alumno.getNombre().toLowerCase().contains(nombre.toLowerCase())
                        )
                        .toList();
    }
    
    default List<Alumno>getByCurso(Curso curso){
        if (curso==null) return new ArrayList();
        return getAll()
                        .stream()
                        .filter(alumno->alumno.getId_curso()==curso.getId())
                        .toList();
    }

    default int getCantidadAlumnos(Curso curso){
        return getByCurso(curso).size();
    }
}
