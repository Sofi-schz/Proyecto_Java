
package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;



public class ConsultasReg extends ConexionReg{
     public boolean registrar(Registro1 regis)
    {
    PreparedStatement ps = null;
    Connection con=getConexionReg();
    
    String sql="INSERT INTO  registro (nombre,apellido,domicilio,telefono) VALUES (?,?,?,?)";
            try {
                   ps=con.prepareStatement(sql);
                   ps.setString(1, regis.getNombre());
                   ps.setString(2, regis.getApellido());
                   ps.setString(3, regis.getDomicilio());
                   ps.setString(4, regis.getTelefono());
                   
                   ps.execute();
                   return true;
        } catch (Exception e) 
        {
            System.err.println(e);
            return false;
        }finally{
                try {
                    con.close();
                } catch (Exception e) {
                    System.err.println(e);
                }
            }
            
    }
    
}
