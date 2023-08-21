
package Modelo;


import java.sql.PreparedStatement;
import java.sql.Connection;

import java.sql.ResultSet;

public class ConsultasM extends ConexionM {
    
    public boolean registrar(Medicamento med)
    {
    PreparedStatement ps = null;
    Connection con=getConexionM();
    
    String sql="INSERT INTO  medicamento (codigo,nombre,lote,fabricante,"
            + "cantidad,precio) VALUES (?,?,?,?,?,?)";
            try {
                   ps=con.prepareStatement(sql);
                   ps.setString(1, med.getCodigo());
                   ps.setString(2, med.getNombre());
                   ps.setString(3, med.getLote());
                   ps.setString(4, med.getFabricante());
                   ps.setString(5, med.getCantidad());
                   ps.setDouble(6, med.getPrecio());
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
    
    
    //************
    public boolean modificar(Medicamento med)
    {
    PreparedStatement ps = null;
    Connection con=getConexionM();
    
    String sql="UPDATE   medicamento SET codigo=?, nombre=?, lote=?,fabricante=?,"
            + "cantidad=?,precio=? where id=? ";
            try {
                   ps=con.prepareStatement(sql);
                   ps.setString(1, med.getCodigo());
                   ps.setString(2, med.getNombre());
                   ps.setString(3, med.getLote());
                   ps.setString(4, med.getFabricante());
                   ps.setString(5, med.getCantidad());
                   ps.setDouble(6, med.getPrecio());
                   ps.setInt(7, med.getId());
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
    
    //*************************
    public boolean eliminar(Medicamento med)
    {
    PreparedStatement ps = null;
    Connection con=getConexionM();
    
    String sql="DELETE FROM   medicamento  WHERE id=? ";
            try {
                   ps=con.prepareStatement(sql);
                   ps.setInt(1, med.getId());
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

//************************
    public boolean buscar(Medicamento med)
    {
    PreparedStatement ps = null;
    ResultSet rs=null;
    Connection con=getConexionM();
    
    String sql="SELECT *  FROM   medicamento  WHERE codigo=? ";
            try {
                   ps=con.prepareStatement(sql);
                   ps.setString(1, med.getCodigo());
                   rs=ps.executeQuery();
                   if(rs.next())
                   {
                       med.setId(Integer.parseInt(rs.getString("id")));
                       med.setCodigo(rs.getString("codigo"));
                       med.setNombre(rs.getString("nombre"));
                      med.setLote(rs.getString("lote"));
                      med.setFabricante(rs.getString("fabricante"));
                      med.setCantidad(rs.getString("cantidad"));
                      med.setPrecio(rs.getDouble("precio"));
                       return true;
                   }
                    return false;
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
