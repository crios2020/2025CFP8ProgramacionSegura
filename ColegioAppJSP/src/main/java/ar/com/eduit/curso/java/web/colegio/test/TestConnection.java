package ar.com.eduit.curso.java.web.colegio.test;

import java.sql.ResultSet;
import java.time.Duration;
import java.time.LocalDateTime;

import ar.com.eduit.curso.java.web.colegio.connectors.Connector;
import ar.com.eduit.curso.java.web.colegio.utils.ColoresAnsi;

public class TestConnection {

    public static void main(String[] args) {
        LocalDateTime ldtInicial=LocalDateTime.now();
        try (ResultSet rs = Connector
                .getConnection()
                .createStatement()
                .executeQuery("select version()")) {
            if (rs.next()) {
                System.out.println(ColoresAnsi.ANSI_GREEN+"OK - Se conecto a: "+rs.getString(1)+"!"+ColoresAnsi.ANSI_RESET);
                LocalDateTime ldtFinal=LocalDateTime.now();
                Duration duration=Duration.between(ldtInicial, ldtFinal);
                System.out.println("Tiempo en conectarse: "+duration.toMillis()+" ms.");
                if(duration.toMillis()<1000){
                    System.out.println(ColoresAnsi.ANSI_GREEN+"OK - Velocidad de conexión aceptable! "+duration.toMillis()+" ms."+ColoresAnsi.ANSI_RESET);
                }else{
                    System.out.println(ColoresAnsi.ANSI_RED+"ERROR - Velocidad de conexión muy lenta! "+duration.toMillis()+" ms."+ColoresAnsi.ANSI_RESET);
                }
            } else {
                System.out.println(ColoresAnsi.ANSI_RED+"ERROR - NO SE PUDO CONECTAR A LA BD!"+ColoresAnsi.ANSI_RESET);
            }             
        } catch (Exception e) {
            System.out.println(ColoresAnsi.ANSI_RED+"ERROR - NO SE PUDO CONECTAR A LA BD!"+ColoresAnsi.ANSI_RESET);
            System.out.println(e);
        }
    }
}
