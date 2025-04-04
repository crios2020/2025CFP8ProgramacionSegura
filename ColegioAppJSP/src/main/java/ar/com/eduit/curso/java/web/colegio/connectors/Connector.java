package ar.com.eduit.curso.java.web.colegio.connectors;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    //private static String driver="org.mariadb.Driver";          //No es necesario indicar el Driver en la actualidad
    
    //Localhost
    private static String url="jdbc:mariadb://localhost:3306/colegio";
    private static String user="root";
    private static String pass="";

    //db4free
    // private static String url="jdbc:mariadb://db4free.net:3306/basegeneral";
    // private static String user="basegeneral";
    // private static String pass="basegeneral";

    private static Connection conn=null;
    
    private Connector(){}       //constructor privado

    public synchronized static Connection getConnection(){
        try {
            if(conn==null || conn.isClosed()){
                //Class.forName(driver);      //Registro del driver, no es necesario en la actualidad
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
