package model;

public class Persona {
    private String nombre, apellido, dni, contrasena;

    public Persona(String nombre, String apellido, String dni, String contrasena) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDni() {
        return dni;
    }   

    public String getContrasena() {
        return contrasena;
    }
}
