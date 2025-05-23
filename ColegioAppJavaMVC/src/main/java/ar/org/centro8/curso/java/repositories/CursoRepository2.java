package ar.org.centro8.curso.java.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ar.org.centro8.curso.java.entities.Curso;

@Repository
public interface CursoRepository2 extends CrudRepository<Curso, Integer>{
 
}
