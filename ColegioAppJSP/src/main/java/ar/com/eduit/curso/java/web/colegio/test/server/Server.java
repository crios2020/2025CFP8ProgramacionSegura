package ar.com.eduit.curso.java.web.colegio.test.server;

import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Ejemplo de Servidor TCP-IP
 */
public class Server {
    public static void main(String[] args) {
        String mensaje = "<h1>Servidor de Carlos!</h1>";
        //String mensaje=System.getProperties()+"\n"+System.getenv();
        mensaje= "HTTP/1.1 200 OK\n"+
            "Content-Type: text/html\n"+
            "Content-Length: "+mensaje.length()+"\n\n"
            +mensaje;
        try (ServerSocket ss = new ServerSocket(8000)) { // abriendo un TCP-IP Server
            while (true) {
                System.out.println("Esperando conexión de cliente ......");
                try (
                        Socket so = ss.accept();
                        OutputStream out = so.getOutputStream();) {
                    InetAddress in = so.getInetAddress();
                    System.out.println("Se conecto: " + in.getHostAddress());
                    out.write(mensaje.getBytes());
                } catch (Exception ee) {
                    System.out.println(ee);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}