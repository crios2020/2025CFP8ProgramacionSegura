package ar.com.eduit.curso.java.web.colegio.repositories.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ar.com.eduit.curso.java.web.colegio.entities.Curso;
//import ar.com.eduit.curso.java.web.colegio.enums.Dia;
//import ar.com.eduit.curso.java.web.colegio.enums.Turno;
import ar.com.eduit.curso.java.web.colegio.repositories.interfaces.I_CursoRepository;

public class CursoRepository implements I_CursoRepository {

    private Connection conn;

    public CursoRepository(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void save(Curso curso) {
        if (curso == null) return;
        try (PreparedStatement ps = conn.prepareStatement(
                "insert into cursos (titulo,profesor,dia,turno) values (?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, curso.getTitulo());
            ps.setString(2, curso.getProfesor());
            ps.setString(3, curso.getDia());
            ps.setString(4, curso.getTurno());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
                curso.setId(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void remove(Curso curso) {
        if (curso == null) return;
        // try (PreparedStatement ps=conn.prepareStatement("delete from cursos where
        // id=?")) {
        try (PreparedStatement ps = conn.prepareStatement("update cursos set activo=false where id=?")) {
            ps.setInt(1, curso.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void update(Curso curso) {
        if (curso == null) return;
        try (PreparedStatement ps = conn.prepareStatement(
            "update cursos set titulo=?, profesor=?, dia=?, turno=?  where id=?")) {
            ps.setString(1, curso.getTitulo());
            ps.setString(2, curso.getProfesor());
            ps.setString(3, curso.getDia());
            ps.setString(4, curso.getTurno());
            ps.setInt(5, curso.getId());
            ps.execute();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Curso> getAll() {
        List<Curso> list = new ArrayList();
        try (ResultSet rs = conn.createStatement().executeQuery("select * from cursos where activo=true")) {
            while (rs.next()) {
                list.add(
                        new Curso(
                                rs.getInt("id"), // id
                                rs.getString("titulo"), // titulo
                                rs.getString("profesor"), // profesor
                                rs.getString("dia"), // dia
                                rs.getString("turno") // turno
                        ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }


    // @Override
    // public List<Curso> getLikeTitulo(String titulo) {
    // List<Curso>list=new ArrayList();
    // if(titulo==null) return list;
    // try (ResultSet rs=conn.createStatement().executeQuery(
    // "select * from cursos where activo='S' and titulo like '%"+titulo+"%'")){
    // while(rs.next()){
    // list.add(
    // new Curso(
    // rs.getInt("id"), // id
    // rs.getString("titulo"), // titulo
    // rs.getString("profesor"), // profesor
    // Dia.valueOf(rs.getString("dia")), // dia
    // Turno.valueOf(rs.getString("turno")) // turno
    // )
    // );
    // }
    // } catch (Exception e) {
    // System.out.println(e);
    // }
    // return list;
    // }


}
