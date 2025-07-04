package ar.com.eduit.curso.java.web.colegio.servlets;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.eduit.curso.java.web.colegio.connectors.Connector;
import jakarta.servlet.http.HttpSession;

public class HiloSession implements Runnable {

    @Override
    public void run() {
        // acción de avisar que se mantiene la session en la bd
        
        while(true){
            try {
                Thread.sleep(60000);
                Connection conn=Connector.getConnection();
        try{
            PreparedStatement ps=conn.prepareStatement(
                "insert into sessiones (username, fecha_hora, accion) "+
                "values (?,sysdate(),?)");
            ps.setString(1, Connector.getUser());
            ps.setString(2, "CHECKLOGIN");
            ps.execute();
        }catch(SQLException e){
            System.out.println(e);
        }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }
    
}
