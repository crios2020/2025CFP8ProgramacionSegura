package ar.org.centro8.curso.java.connectors;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class ConnectorExample {
    private static String driver="com.mysql.cj.jdbc.Driver";    // driver mysql 6 o superior
    private static String vendor="mysql";
    private static String server="xxxx";
    private static String port="3333";
    private static String db="xxxx";
    private static String params="?serverTimezone=UTC";
    private static String user="xxxx";
    private static String pass="xxxx";

    
    private static String url="jdbc:"+vendor+"://"+server+":"+port+"/"+db+params;
    
    private static Connection conn=null;
    
    private ConnectorExample(){ }
    
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