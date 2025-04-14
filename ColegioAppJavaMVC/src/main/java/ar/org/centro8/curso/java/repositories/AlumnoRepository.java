package ar.org.centro8.curso.java.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ar.org.centro8.curso.java.connectors.Connector;
import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.entities.Curso;
import ar.org.centro8.curso.java.enums.Dia;
import ar.org.centro8.curso.java.enums.Turno;

public class AlumnoRepository {
    private Connection conn = Connector.getConnection();

    public void save(Alumno alumno) {
        if (alumno == null) return;
        try (PreparedStatement ps = conn.prepareStatement(
                "insert into alumnos (nombre,apellido,edad,id_curso) values (?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setInt(3, alumno.getEdad());
            ps.setInt(4, alumno.getIdCurso());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
                alumno.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void remove(Alumno alumno) {
        if(alumno==null) return;
        //try (PreparedStatement ps=conn.prepareStatement("delete from alumnos where id=?")){
        try (PreparedStatement ps=conn
                .prepareStatement("update alumnos set activo=false where id=?")){
            ps.setInt(1, alumno.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Alumno> getAll() {
        List<Alumno> list = new ArrayList();
        try (ResultSet rs = conn
                .createStatement()
                .executeQuery("select * from alumnos where activo=true")) {
            while (rs.next()) {
                list.add(new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getInt("id_curso")));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Alumno getById(int id){
        return getAll()
                        .stream()
                        .filter(alumno->alumno.getId()==id)
                        .findFirst()
                        .orElse(new Alumno());
    }

    public List<Alumno>getLikeApellido(String apellido){
        if(apellido==null) return new ArrayList();
        return getAll()
                        .stream()
                        .filter(alumno->alumno
                                            .getApellido()
                                            .toLowerCase()
                                            .contains(apellido.toLowerCase()))
                        .toList();
    }
}
