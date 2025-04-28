package ar.org.centro8.curso.java.test;

import java.net.Inet4Address;
import java.time.LocalDate;
import java.util.Calendar;

import ar.org.centro8.curso.java.utils.Properties;

public class TestPropiedades {
    public static void main(String[] args) {
        //System.out.println(System.getProperties());
        System.getProperties().forEach((k,v)->System.out.println(k+": "+v));
        System.out.println("******************************************");

        //System.out.println(System.getenv());
        System.getenv().forEach((k,v)->System.out.println(k+": "+v));
        System.out.println("******************************************");

        System.out.println("Sistema Operativo: "+
                                System.getProperty("os.name")+" "+
                                System.getProperty("os.version")+" "+
                                System.getProperty("os.arch"));
        
        System.out.println("Versión de java: "+
                                System.getProperty("java.vm.name")+" "+
                                System.getProperty("java.vm.version"));
                            
        System.out.println("Nombre de Usuario:"+
                                System.getProperty("user.name"));
        
        System.out.println("Ubicación: "+
                                Calendar
                                            .getInstance()
                                            .getTimeZone()
                                            .getID()
                                            .replace("/", " ")
                                            .replace("_", " "));

        try {
            System.out.println("IP: "+
                                        Inet4Address
                                        .getLocalHost()
                                        .getHostAddress());
        } catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("******************************************");
        System.out.println(Properties.getSO());
        System.out.println(Properties.getJava());
        System.out.println(Properties.getUser());
        System.out.println(Properties.getLocation());
        System.out.println(Properties.getIp());

        System.out.println(
                            LocalDate
                                        .now()
                                        .toString()
                                        .replace("-", "/"));
        LocalDate ld=LocalDate.now();
        String fecha=ld.getDayOfMonth()+"/"+ld.getMonthValue()+"/"+ld.getYear();
        System.out.println(fecha);

        
        
    }
}
