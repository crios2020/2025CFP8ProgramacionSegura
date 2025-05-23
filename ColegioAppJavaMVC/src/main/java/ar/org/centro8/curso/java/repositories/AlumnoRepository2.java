package ar.org.centro8.curso.java.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ar.org.centro8.curso.java.entities.Alumno;

@Repository
public interface AlumnoRepository2 extends CrudRepository<Alumno, Integer>{
    
}
