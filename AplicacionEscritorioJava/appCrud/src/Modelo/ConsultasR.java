
package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection;




public class ConsultasR extends ConexionR {
     public boolean registrar(Registro reg)
    {
    PreparedStatement ps = null;
    Connection con=getConexionR();
    
    String sql="INSERT INTO  registro (correo_electronico,contrasena) VALUES (?,?)";
            try {
                   ps=con.prepareStatement(sql);
                   
                   ps.setString(1, reg.getCorreo_electronico());
                   ps.setString(2, reg.getContraseña());
                   
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
