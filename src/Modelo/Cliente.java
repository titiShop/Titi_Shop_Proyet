
package Modelo;

// Definición de la clase Cliente
public class Cliente {
    // Atributos privados de la clase
    private int id;
    private int CC;
    private String nombre;
    private String telefono;
    private String direccion;
    private String razonSocial;

    // Constructor vacío
    public Cliente() {
    }

    // Constructor con parámetros para inicializar todos los atributos
    public Cliente(int id, int CC, String nombre, String telefono, String direccion, String razonSocial) {
        this.id = id;
        this.CC = CC;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.razonSocial = razonSocial;
    }

    // Métodos de acceso (getters) para obtener valores de los atributos
    public int getId() {
        return id;
    }

    public int getCC() {
        return CC;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    // Métodos de modificación (setters) para establecer valores de los atributos
    public void setId(int id) {
        this.id = id;
    }

    public void setCC(int CC) {
        this.CC = CC;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }
}
