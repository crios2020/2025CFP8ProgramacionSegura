package ar.org.centro8.curso.java.test;

import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDateTime;

import ar.org.centro8.curso.java.connectors.ConnectorExample;

public class TestConnection {
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void main(String[] args) {
        LocalDateTime inicio=LocalDateTime.now();
        try (ResultSet rs=ConnectorExample
                                    .getConnection()
                                    .createStatement()
                                    .executeQuery("select * from cursos")) {
            if(rs.next()){
                System.out.println(rs.getString(1));
                System.out.println(ANSI_GREEN+"OK - Se conecto a la BD");
                LocalDateTime fin=LocalDateTime.now();
                Duration duration=Duration.between(inicio, fin);
                long tiempo=duration.toSeconds();
                if(tiempo<1){
                    System.out.println(ANSI_GREEN+"OK - Tiempo de respuesta menor a 1 segundo");
                }else{
                    System.out.println(ANSI_RED+"ERROR - Tiempo de respuesta lento, "+tiempo+" segundos!");
                }
            }else{
                System.out.println(ANSI_RED+"ERROR - No se conecto a la BD");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println(ANSI_RED+"ERROR - No se conecto a la BD");
        }
        System.out.println(ANSI_RESET);
    }
}
