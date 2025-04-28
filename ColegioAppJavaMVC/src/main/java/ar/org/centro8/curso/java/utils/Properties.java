package ar.org.centro8.curso.java.utils;

import java.net.Inet4Address;
import java.time.LocalDate;
import java.util.Calendar;

public class Properties {
    
    public static String getSO(){
        return  System.getProperty("os.name")+" "+
                System.getProperty("os.version")+" "+
                System.getProperty("os.arch");
    }

    public static String getJava(){
        return  System.getProperty("java.vm.name")+" "+
                System.getProperty("java.vm.version");
    }

    public static String getUser(){
        return  System.getProperty("user.name");
    }

    public static String getLocation(){
        return Calendar
                        .getInstance()
                        .getTimeZone()
                        .getID()
                        .replace("/", " ")
                        .replace("_", " ");
    }

    public static String getIp(){
        String ip="";
        try {
            ip=Inet4Address
                            .getLocalHost()
                            .getHostAddress();
        } catch (Exception e) {}
        return ip;
    }

    public static String getDate(){
        return LocalDate
                        .now()
                        .toString()
                        .replace("-", "/");
    }

}
