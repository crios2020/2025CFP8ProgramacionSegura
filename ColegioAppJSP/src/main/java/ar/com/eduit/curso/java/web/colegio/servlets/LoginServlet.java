package ar.com.eduit.curso.java.web.colegio.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.boot.web.servlet.server.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/servlets/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("/error.html");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ((HttpServletResponse) response)
                .addHeader("Access-Control-Allow-Origin", "192.168.16.244");
        try (PrintWriter out=new PrintWriter(response.getOutputStream())){
            //Salida
            //out.println("<h1>Hola Mundo Servlet!!</h1>");

            //entrada de parámetros
            String user=request.getParameter("user");
            String pass=request.getParameter("pass");

            System.out.println("****************************************");
            System.out.println(user);
            System.out.println(pass);
            System.out.println("****************************************");
            HttpSession session=request.getSession();
            if( user!=null && 
                pass!=null && 
                user.equals("root") && 
                pass.equals("1234")){
                    
                    session.setAttribute("login", true);
                    session.setAttribute("user", "root");
                    response.sendRedirect("/index.jsp");
                    
                }else{
                    session.setAttribute("login", false);
                    response.sendRedirect("/error.html");
                }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
    
}
