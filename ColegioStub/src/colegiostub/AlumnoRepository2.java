/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package colegiostub;

import ar.org.centro8.curso.java.entities.Alumno;
import ar.org.centro8.curso.java.repositories.jdbc.AlumnoRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;

/**
 *
 * @author centro8
 */
public class AlumnoRepository2 extends AlumnoRepository {
    public Connection conn;
    public AlumnoRepository2(Connection conn) {
        super(conn);
        this.conn=conn;
    }

    public void remove(Alumno alumno) {
        if(alumno==null) return;
        try (PreparedStatement ps=conn.prepareStatement("delete from alumnos where id=?")){
        //try (PreparedStatement ps=conn
                //.prepareStatement("delete from alumnos")){
                //.prepareStatement("delete from cursos")){
            ps.setInt(1, alumno.getId());
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }    
    
}
