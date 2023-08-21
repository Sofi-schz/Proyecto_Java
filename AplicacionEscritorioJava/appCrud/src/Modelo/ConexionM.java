
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionM {
    
     private  final String dbName="medicamento";
    private final  String userName="root";
    private  final String password="192305";
    private  final String host="localhost";
    private  final String port="3306";
    private final String url= "jdbc:mysql://"+this.host+":"+this.port+"/"+this.dbName;
    private   Connection con= null;
    
    public Connection getConexionM(){
     try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(this.url, this.userName, this.password);
            //System.out.print("Conexion exitosa");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
            //System.out.println("Error, no se conecto");
        }
           return con;
       }
    
}
