package ar.com.eduit.curso.java.web.colegio.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ar.com.eduit.curso.java.web.colegio.entities.Alumno;
import ar.com.eduit.curso.java.web.colegio.repositories.interfaces.I_AlumnoRepository;
import lombok.AllArgsConstructor;

//@AllArgsConstructor
public class AlumnoRepository implements I_AlumnoRepository{

    private Connection conn;

    public AlumnoRepository(Connection conn) {
		this.conn = conn;
	}

	@Override
    public void save(Alumno alumno) {
        if(alumno==null) return;
        try (PreparedStatement ps=conn.prepareStatement(
            "insert into alumnos (nombre, apellido, edad, id_curso) values (?,?,?,?)",
            PreparedStatement.RETURN_GENERATED_KEYS)){
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setInt(3, alumno.getEdad());
            ps.setInt(4, alumno.getId_curso());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
                alumno.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void remove(Alumno alumno) {
        if(alumno==null) return;
        try (PreparedStatement ps = conn.prepareStatement("update alumnos set activo=false where id=?")) {
            ps.setInt(1, alumno.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Alumno alumno) {
        if(alumno==null) return;
        // TODO realizar método actualizar alumno
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Alumno> getAll() {
        List<Alumno>list=new ArrayList();
        try(ResultSet rs=conn.createStatement().executeQuery("select * from alumnos where activo=true")){
            while(rs.next()){
                list.add(
                    new Alumno(
                        rs.getInt("id"),            //id
                        rs.getString("nombre"),     //nombre
                        rs.getString("apellido"),   //apellido
                        rs.getInt("edad"),          //edad
                        rs.getInt("id_curso")       //id_curso
                    )
                );
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

}
