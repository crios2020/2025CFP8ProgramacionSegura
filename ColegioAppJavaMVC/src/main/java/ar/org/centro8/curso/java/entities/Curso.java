package ar.org.centro8.curso.java.entities;

import ar.org.centro8.curso.java.enums.Dia;
import ar.org.centro8.curso.java.enums.Turno;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cursos")
public class Curso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private int id;
    private String titulo;
    private String profesor;
    @Enumerated(value = EnumType.STRING)
    private Dia dia;
    @Enumerated(value = EnumType.STRING)
    private Turno turno;
}
