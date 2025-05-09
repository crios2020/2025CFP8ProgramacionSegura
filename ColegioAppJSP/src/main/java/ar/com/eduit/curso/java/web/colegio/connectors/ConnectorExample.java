package ar.com.eduit.curso.java.web.colegio.connectors;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectorExample {
    //private static String driver="org.mariadb.Driver";          //No es necesario indicar el Driver en la actualidad
    
    //Localhost
    private static String url="jdbc:mariadb://xxxx:3333/xxxx";
    private static String user="xxx";
    private static String pass="xxx";

    private static Connection conn=null;
    
    private ConnectorExample(){}       //constructor privado

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
