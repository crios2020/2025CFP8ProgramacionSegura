package ar.com.eduit.curso.java.web.colegio.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import ar.com.eduit.curso.java.web.colegio.connectors.Connector;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/servlets/logout")
public class LogoutServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        HttpSession session=request.getSession();
        session.setAttribute("login", false);
        session.setAttribute("user", null);
        Connection conn=Connector.getConnection();
        try{
            PreparedStatement ps=conn.prepareStatement(
                "insert into sessiones (username, fecha_hora, accion) "+
                "values (?,sysdate(),?)");
            ps.setString(1, Connector.getUser());
            ps.setString(2, "LOGOUT");
            ps.execute();
        }catch(SQLException e){
            System.out.println(e);
        }
        response.sendRedirect("../login.html");
    }
    
}
