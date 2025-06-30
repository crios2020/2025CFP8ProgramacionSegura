package ar.com.eduit.curso.java.web.colegio.servlets;

import java.io.IOException;

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
        response.sendRedirect("../error.html");
    }
    
}
