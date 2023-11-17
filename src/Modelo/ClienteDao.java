
package Modelo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class ClienteDao {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public boolean RegistrarCliente(Cliente cl) {
        String sql = "INSERT INTO clientes ( cc, nombre, telefono, direccion,razonSocial ) VALUES (?, ?, ?, ?, ?)";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);         
            ps.setInt(1, cl.getCC());
            ps.setString(2, cl.getNombre());
            ps.setLong(3, cl.getTelefono());
            ps.setString(4, cl.getDireccion()); 
            ps.setString(5, cl.getRazonSocial());
            ps.execute();
            return true;
        } catch (SQLException e ){
            JOptionPane.showMessageDialog(null, e.toString());
            return false;            
        }finally{
            try {
                con.close();
            } catch (SQLException e ){
                System.out.println(e.toString());
            }
        }
    }
    public List ListarClientes(){
        List<Cliente> ListaCl = new ArrayList();
        String sql = "SELECT * FROM clientes";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeQuery();
            rs = ps.executeQuery();
            while (rs.next()){
                Cliente cl = new Cliente();
               cl.setId(rs.getInt("id"));
               cl.setCC(rs.getInt("cc"));
               cl.setNombre(rs.getString("nombre"));
               cl.setTelefono(rs.getInt("telefono"));
               cl.setDireccion(rs.getString("direccion"));
               cl.setRazonSocial(rs.getString("razonSocial"));
               ListaCl.add(cl);
            }
        } catch (SQLException e){
            System.out.println(e.toString());
        }
        return ListaCl;
    }
    public boolean EliminarCliente (int id){
        String sql = "DELETE FROM clientes WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.execute();
            return true;
        } catch (SQLException e){
            System.out.println(e.toString());
            return false;
        } finally{
            try {
                con.close();
            } catch (SQLException ex) {
                 System.out.println(ex.toString());  
            }
        }   
    }
}

    
   