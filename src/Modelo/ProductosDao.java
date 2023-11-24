package Modelo;

import java.sql.PreparedStatement;
import java.sql.Connection; 
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;

/**
 *
 * @author aleiz
 */
public class ProductosDao {
    Connection con;
    Conexion cn = new Conexion();
    PreparedStatement ps;
    ResultSet rs;

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

    public void ConsultarProveedor(JComboBox proveedor){
    String sql ="SELECT nombre FROM proveedor";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                proveedor.addItem(rs.getString("nombre"));
                
                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
    
    }
    
    public Productos BuscarPro(String cod){
        Productos producto = new Productos();
        String sql = "SELECT * FROM productos WHERE codigo ==?";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(2, cod);
            rs = ps.executeQuery();
            if (rs.next()) {
                producto.setNombre(rs.getString("nombre"));
                producto.setPrecio(rs.getDouble("precio"));
                producto.setStock(rs.getInt("stock"));
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return producto;
    } 
    
}
  