import java.net.InetAddress;

public class ScanIp {

    private static final int oi1 = 192;
    private static final int oi2 = 168;
    private static final int oi3 = 1;
    private static final int oi4 = 1;

    public static void main(String[] args) {
        // ipv 4

        String ip;

        // for(int o1=oi1; o1<=254; o1++){
        // for(int o2=oi2; o2<=254; o2++){
        // for(int o3=oi3; o3<=254; o3++){
        int encendida=0;
        int apagada=0;
        for (int o4 = oi4; o4 <= 254; o4++) {
            ip = oi1 + "." + oi2 + "." + 16 + "." + o4;
            System.out.println(ip);
            try {
                InetAddress in = InetAddress.getByName(ip);
                if (in.isReachable(1000)) {
                    System.out.println("Dirección accesible! :) ");
                    encendida++;
                } else {
                    System.out.println("La dirección indicada es inaccesible :(");
                    apagada++;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        for (int o4 = oi4; o4 <= 254; o4++) {
            ip = oi1 + "." + oi2 + "." + 20 + "." + o4;
            System.out.println(ip);
            try {
                InetAddress in = InetAddress.getByName(ip);
                if (in.isReachable(1000)) {
                    System.out.println("Dirección accesible! :) ");
                    encendida++;
                } else {
                    System.out.println("La dirección indicada es inaccesible :(");
                    apagada++;
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        System.out.println("Se encontraron "+encendida+" terminales encendidas");
        System.out.println("Se encontraron "+apagada+" terminales apagadas");


        // }
        // }
        // }

    }
}
