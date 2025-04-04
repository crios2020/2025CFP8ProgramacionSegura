package ar.com.eduit.curso.java.web.colegio.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Alumno {
    
    private int id;
    private String nombre;
    private String apellido;
    private int edad;
    private int id_curso;

    public Alumno() {
	}

	public Alumno(String nombre, String apellido, int edad, int id_curso) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.id_curso = id_curso;
    }

	public Alumno(int id, String nombre, String apellido, int edad, int id_curso) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.id_curso = id_curso;
	}

	@Override
	public String toString() {
		return "Alumno [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", id_curso="
				+ id_curso + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

}
