package ar.org.centro8.curso.java.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alumno {
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private int idCurso;
}
