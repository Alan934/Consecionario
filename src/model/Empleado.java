package model;

public class Empleado extends Persona{
    private double sueldo;
    public Empleado(String nombre, String apellido, String dni, double sueldo, String contrasena) {
        super(nombre, apellido, dni, contrasena);
        this.sueldo = sueldo;
    }

    public double getSueldo() {
        return sueldo;
    }
    
}
