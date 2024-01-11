
package Modelo;



import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection; 



/**
 *
 * @author Aleizerbick
 */
public class VentaDAO {
      Connection con;
      Conexion cn = new Conexion ();
        PreparedStatement ps;
      int r;
    public int RegistrarVenta(Venta V)
    { String sql = " INSERT INTO ventas(cliente,vendedor,total) VALUES (?,?,?)";
        try {
          con =  cn.getConnection();
             ps = con.prepareStatement(sql);
           ps.setString(1, V.getCliente());
           ps.setString(2, V.getVendedor());
           ps.setDouble(3, V.getTotal());
           ps.execute();
        } catch (SQLException e) {System.out.println(e.toString());
        }
        return r;
    }
    
}
