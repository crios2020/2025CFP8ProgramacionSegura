import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
   public static void main(String[] args) {
        //192.168.20.206:8800
        //String mensaje=System.getProperties()+"\n"+System.getenv();
        //mensaje=    "HTTP/1.1 200 OK\n"+
        //            "Content-Type: text/plain\n"+
        //            "Content-Length: "+mensaje.length()+"\n\n"
        //            +mensaje;
        String mensaje="<h1>Servidor de Carlos!</h1>";
        mensaje=    "HTTP/1.1 200 OK\n"+
                    "Content-Type: text/html\n"+
                    "Content-Length: "+mensaje.length()+"\n\n"
                    +mensaje;
        try (ServerSocket ss=new ServerSocket(8800)){
            System.out.println("Servidor Encendido!");
            while(true){
                //DDOS
                //Thread.sleep(1000);
                System.out.println("Esperando conexión de cliente.......");
                try (
                        Socket so=ss.accept();
                        OutputStream out=so.getOutputStream();    
                    ){
                        System.out.println("Se conecto "+so.getInetAddress());
                        out.write(mensaje.getBytes());
                        System.out.println("Conexión terminada!!");
                } catch (Exception ee) {
                    System.out.println(ee);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
   } 
}
