package ar.org.centro8.curso.java.connectors;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectorExample {
    
    //localhost
    private static String url="jdbc:mariadb://xxxx:3333/xxxx";
    private static String user="xxxx";
    private static String pass="xxxx";

    private static Connection conn=null;

    private ConnectorExample(){}

    public synchronized static Connection getConnection(){
        try {
            if(conn==null || conn.isClosed()){
                conn=DriverManager.getConnection(url, user, pass);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return conn;
    }

    public static String getUrl() {
        return url;
    }

}
