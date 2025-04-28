package ar.org.centro8.curso.java.repositories.jdbc;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.repositories.interfaces.I_AlumnoRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public final class AlumnoRepository implements I_AlumnoRepository{

    private Connection conn;

    public AlumnoRepository(Connection conn) {
        this.conn = conn;
    }
  
    @Override
    public void save(Alumno alumno) {
        if(alumno==null) return;
        //insert into alumnos (nombre,apellido,edad,idCurso) values
        //                  ('Carlos','Rios',52,1);
        
        // ("Anonymus','x',66,1); delete from alumnos; -- ",'x',20,1)"
        
        
        //statement es obsoleto
//        try {
//            String query="insert into alumnos (nombre,apellido,edad,id_curso) values "
//                    +"('"+alumno.getNombre()+"','"+alumno.getApellido()+"','"
//                    +alumno.getEdad()+"','"+alumno.getIdCurso()+"')";
//            conn.createStatement().execute(query);      //jdk1 a jdk 5
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        
        
        try (PreparedStatement ps=conn.prepareStatement(
                "insert into alumnos (nombre,apellido,edad,id_curso) values (?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS
        )) {
            ps.setString(1, alumno.getNombre());
            ps.setString(2, alumno.getApellido());
            ps.setInt(3, alumno.getEdad());
            ps.setInt(4, alumno.getIdCurso());
            ps.execute();
            ResultSet rs=ps.getGeneratedKeys();
            if(rs.next()) alumno.setId(rs.getInt(1));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    @Override
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

    @Override
    public void update(Alumno alumno) {
        if(alumno==null) return;
        String query="update alumnos set nombre='"+
                alumno.getNombre()+"', apellido='"+
                alumno.getApellido()+"', edad='"+
                alumno.getEdad()+"', id_curso='"+
                alumno.getIdCurso()+"' where id='"+
                alumno.getId()+"'";
        try {
            conn.createStatement().execute(query);
        } catch (Exception e) {
            System.out.println(e);
        }
//        try (PreparedStatement ps=conn.prepareStatement(
//                "update alumnos set nombre=?, apellido=?, edad=?, id_curso=? where id=?"
//        )) {
//            ps.setString(1, alumno.getNombre());
//            ps.setString(2, alumno.getApellido());
//            ps.setInt(3, alumno.getEdad());
//            ps.setInt(4, alumno.getIdCurso());
//            ps.setInt(5, alumno.getId());
//            ps.execute();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    @Override
    public List<Alumno> getAll() {
        List<Alumno> lista=new ArrayList();
        try (ResultSet rs=conn.createStatement().executeQuery("select * from alumnos where activo=true")){
            while(rs.next()){
                lista.add(new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getInt("id_curso")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    
    @Override
    public List<Alumno> getLikeApellido(String apellido) {
    List<Alumno> lista=new ArrayList();
        try (ResultSet rs=conn
                .createStatement()
                .executeQuery(
                        "select * from alumnos where apellido like '%"+
                                apellido+
                                "%' and activo=true")){
            //%' and activo=false-- 
            while(rs.next()){
                lista.add(new Alumno(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getInt("edad"),
                        rs.getInt("id_curso")
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;    
    }
    
    
    
}