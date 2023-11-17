
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    // Declaramos una variable de tipo Connection para almacenar la conexión a la base de datos.
    Connection con;
    // Método público llamado "getConnection" que devuelve una conexión a la base de datos.
    public Connection getConnection (){
        try {
            String myBD = "jdbc:mysql://localhost:3306/sistemaventa";
            con = DriverManager.getConnection(myBD, "root", "");
            return con;
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}

