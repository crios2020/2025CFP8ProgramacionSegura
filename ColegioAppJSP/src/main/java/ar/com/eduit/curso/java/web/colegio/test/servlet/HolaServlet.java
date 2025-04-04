package ar.com.eduit.curso.java.web.colegio.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "holaservlet", urlPatterns = "/servlet")
public class HolaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //response.setContentType("text/plain");
        response.setContentType("text/html");
        try (PrintWriter out=response.getWriter()){


            //http://localhost:8082/servlet
            out.println("<h1>hola mundo Servlet</h1>");
            System.out.println("Esto sale por consola del server!");

            //Parámetros de entrada
            String nombre=request.getParameter("nombre");
            if(nombre!=null && !nombre.isEmpty()){
                //http://localhost:8082/servlet?nombre=Carlos
                out.println("<h2>Hola "+nombre+"</h2>");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
