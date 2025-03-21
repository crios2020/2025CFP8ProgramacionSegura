package ar.org.centro8.curso.java.test;
import ar.org.centro8.curso.java.connectors.Connector;
import java.sql.Connection;
import java.util.Scanner;
import java.sql.Statement;
import java.sql.ResultSet;
public class TestConnector {
    public static void main(String[] args) throws Exception {
        Connection conn=Connector.getConnection();
        String query="insert into cursos (titulo,profesor,dia,turno) values('Java','Gomez','MARTES','TARDE')";
        Statement st=conn.createStatement();
        st.execute(query);
     
        Connector
                .getConnection()
                .createStatement()
                .execute("insert into cursos (titulo,profesor,dia,turno) values('HTML','Sosa','LUNES','NOCHE')");
               
        ResultSet rs=Connector.getConnection().createStatement().executeQuery("select * from cursos");
        while(rs.next()){
            System.out.println(
                    rs.getInt("id")+", "+
                    rs.getString("titulo")+", "+
                    rs.getString("profesor")+", "+
                    rs.getString("dia")+", "+
                    rs.getString("turno")
            );
        } 
    }
}
