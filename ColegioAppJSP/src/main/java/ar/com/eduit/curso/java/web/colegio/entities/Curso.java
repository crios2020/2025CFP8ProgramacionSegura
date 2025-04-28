package ar.com.eduit.curso.java.web.colegio.entities;

//import ar.com.eduit.curso.java.web.colegio.enums.Dia;
//import ar.com.eduit.curso.java.web.colegio.enums.Turno;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Curso {

    private int id;
    private String titulo;
    private String profesor;
    private String dia;
    //private Dia dia;
    private String turno;
    //private Turno turno;
    
	public Curso(String titulo, String profesor, String dia, String turno) {
        this.titulo = titulo;
        this.profesor = profesor;
        this.dia = dia;
        this.turno = turno;
    }

    /*
    public Curso() {
	}

	public Curso(String titulo, String profesor, String dia, String turno) {
        this.titulo = titulo;
        this.profesor = profesor;
        this.dia = dia;
        this.turno = turno;
    }

	public Curso(int id, String titulo, String profesor, String dia, String turno) {
		this.id = id;
		this.titulo = titulo;
		this.profesor = profesor;
		this.dia = dia;
		this.turno = turno;
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", titulo=" + titulo + ", profesor=" + profesor + ", dia=" + dia + ", turno=" + turno
				+ "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getProfesor() {
		return profesor;
	}

	public void setProfesor(String profesor) {
		this.profesor = profesor;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	*/
}
