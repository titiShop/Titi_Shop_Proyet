package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection; // Importa la clase correcta para Connection

/**
 *
 * @author aleiz
 */
public class ProductosDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;

    public boolean RegistrarProductos(String codigo, String nombre, String proveedor, int stock, double precio) {
        String sql = "INSERT INTO productos (codigo, nombre, proveedor, stock, precio) VALUES (?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, codigo);
            ps.setString(2, nombre);
            ps.setString(3, proveedor);
            ps.setInt(4, stock);
            ps.setDouble(5, precio);
            int result = ps.executeUpdate();
            return result > 0; // Devuelve true si se insertó correctamente
        } catch (Exception e) {
            e.printStackTrace(); // Manejo básico de errores, imprime el stack trace
            return false;
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace(); // Manejo básico de errores, imprime el stack trace
            }
        }
    }

}
