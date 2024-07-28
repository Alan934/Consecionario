package model;

public class Cliente extends Persona{
    private int id;
    
    public Cliente(String nombre, String apellido, String dni, String contrasena) {
        super(nombre, apellido, dni, contrasena);
    }
    
    public Cliente(int id, String nombre, String apellido, String dni, String contrasena) {
        super(nombre, apellido, dni, contrasena);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
 
}
