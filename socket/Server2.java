import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2{
    public static void main(String[] args) {
        try (ServerSocket ss=new ServerSocket(8801)) {
            System.out.println("Servidor encendido!");
            while (true) {
                System.out.println("Esperando conexión de cliente.........");
                try (
                    Socket so=ss.accept();
                    InputStream in=so.getInputStream();
                    BufferedReader bf=new BufferedReader(new InputStreamReader(in));
                ){
                    System.out.println(so.getInetAddress());
                    //hola
                    //String mensaje="";
                    //int car;
                    //while((car=in.read())!=-1){
                    //    mensaje+=(char)car;
                    //}
                    //System.out.println(mensaje);
                    bf
                        .lines()
                        .filter(st->st.contains("centro8")) //token
                        .forEach(System.out::println);
                } catch (Exception ee) {
                    System.out.println(ee);
                }
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}