package ar.org.centro8.curso.java.connectors;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connector {
    private static String driver="com.mysql.cj.jdbc.Driver";    // driver mysql 6 o superior
    //private static String driver="com.mysql.jdbc.Driver";       //driver mysql 5
    private static String vendor="mysql";
    private static String server="localhost";
    //private static String server="db4free.net";
    private static String port="3306";
    private static String db="colegio";
    //private static String db="colegioapp2020";
    private static String params="?serverTimezone=UTC";
    private static String user="root";
    private static String pass="";
    //private static String user="colegioapp2020";
    //private static String pass="centro8medrano";

    
    private static String url="jdbc:"+vendor+"://"+server+":"+port+"/"+db+params;
    
    private static Connection conn=null;
    
    private Connector(){ }
    
    public synchronized static Connection getConnection(){
        try{
            if(conn==null || conn.isClosed()){
                Class.forName(driver);
                conn=DriverManager.getConnection(url, user, pass);
            }
        }catch(SQLException e) { System.out.println("Problema de conexión");
        }catch(ClassNotFoundException e) { System.out.println("No se encontro el driver");
        }catch(Exception e){ e.printStackTrace(); }
        return conn;
    }
}