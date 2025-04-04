package ar.com.eduit.curso.java.web.colegio.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "sumar", urlPatterns = "/sumar")
public class SumarServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        try (PrintWriter out=response.getWriter()) {
            int nro1=Integer.parseInt(request.getParameter("nro1"));
            int nro2=Integer.parseInt(request.getParameter("nro2"));
            int resultado=nro1+nro2;
            out.println(resultado);
            //http://localhost:8082/sumar?nro1=2&nro2=6

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
