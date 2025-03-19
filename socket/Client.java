import java.io.OutputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {
        String mensaje="hola soy Carlos!centro8";
        try (
            Socket so=new Socket("192.168.20.206", 8801);
            OutputStream out=so.getOutputStream();
            ) {
            out.write(mensaje.getBytes());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
