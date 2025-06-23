package ar.org.centro8.curso.java.interfaces;

import java.util.List;

import ar.org.centro8.curso.java.entities.Alumno;

public interface I_AlumnoRepository {
    public abstract void save(Alumno alumno);
    public abstract void remove(Alumno alumno);
    public abstract void update(Alumno alumno);
    public abstract List<Alumno>getAll();

    public default Alumno getById(int id){
        return getAll()
                        .stream()
                        .filter(a->a.getId()==id)
                        .findFirst()
                        .orElse(new Alumno());
    }

    public default List<Alumno>getLikeApellido(String apellido){
        return getAll()
                        .stream()
                        .filter(a->a
                                    .getApellido()
                                    .toLowerCase()
                                    .contains(apellido.toLowerCase()))
                        .toList();
    }

}
