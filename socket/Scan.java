import java.net.ServerSocket;

public class Scan{
    public static void main(String[] args) {
        for(int a=0; a<=65535; a++){
            try (ServerSocket ss=new ServerSocket(a)) {
                //System.out.println("Puerto "+a+" libre");
            } catch (Exception e) {
                //System.out.println(e);
                System.out.println("Puerto "+a+" ocupado");
            }
        }

    }
}