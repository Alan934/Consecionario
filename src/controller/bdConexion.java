package controller;
import java.sql.Connection;
import java.sql.DriverManager;
public class bdConexion {
    String url="jdbc:mysql://localhost:3306/concesionario";
    String user="root",pass="";    
    Connection con;
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url,user,pass);
        } catch (Exception e) {
            System.out.println("Error conectar con base de datos: "+e);
        }
        return con;
    }
}
