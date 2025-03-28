package ar.org.centro8.curso.java.test;
import ar.org.centro8.curso.java.connectors.Connector;
import java.sql.ResultSet;
public class TestConnector {
    public static void main(String[] args) throws Exception {
        ResultSet rs=Connector
                .getConnection()
                .createStatement()
                .executeQuery("select version()");
        if(rs.next())   System.out.println("Se conecto a "+rs.getString(1));
        else            System.out.println("No se pudo conectar a la BD!");

    }
}
