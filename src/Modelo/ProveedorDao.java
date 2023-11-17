
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
public class ProveedorDao {
  
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    public boolean RegistrarProveedir(Proveedor pr){
      String sql = "INSERT INTO proveedor(rut, nombre, telefono, direccion, razon) VALUES (?,?,?,?,?)";
      try {
         con = cn.getConnection();
         ps = con.prepareStatement(sql);
         ps.setInt(1, pr.getRut());
         ps.setString(2, pr.getName());
         ps.setInt(3, pr.getTelefono());
         ps.setString(4, pr.getDireccion());
         ps.setString(5, pr.getRazon());
         ps.execute();
         return true;
      } catch (SQLException e){
          System.out.println(e.toString());
          return false;
      } finally{
          try{
              con.close();
          } catch (SQLException e) {
              
          }
      }
  }
}
