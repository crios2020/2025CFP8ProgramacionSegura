package ar.com.eduit.curso.java.web.colegio.servlets;

import java.io.IOException;
import java.io.PrintStream;

import ar.com.eduit.curso.java.web.colegio.connectors.Connector;
import ar.com.eduit.curso.java.web.colegio.repositories.jdbc.AlumnoRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/servlets/alumnos")
public class AlumnoService extends HttpServlet {

    AlumnoRepository ar = new AlumnoRepository(Connector.getConnection());

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintStream out = new PrintStream(response.getOutputStream())) {
            HttpSession session=request.getSession();
            if (session.getAttribute("login") == null ||
                    ((boolean) session.getAttribute("login")) != true) {
                response.sendRedirect("../error.html");
            }

            String apellido = request.getParameter("apellido");
            if (apellido == null)
                apellido = "";
            // out.println(ar.getAll());
            out.println(ar.getLikeApellido(apellido));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
