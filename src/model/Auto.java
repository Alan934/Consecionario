package model;

public class Auto extends Vehiculo{
    private String patente;
    private int cantidadPuertas;
    private int idVehiculo;
    
    public Auto(){
        
    }

    public Auto(int idVehiculo, String patente, int cantidadPuertas, String marca, String color, String modelo, int rodado, double precio, String tipo) {
        this.patente = patente;
        this.cantidadPuertas = cantidadPuertas;
        this.idVehiculo = idVehiculo;
    }
    
    public Auto(String patente, int cantidadPuertas, String marca, String color, String modelo, int rodado, double precio, String tipo) {
        super(marca, color, modelo, rodado, precio, tipo);
        this.patente = patente;
        this.cantidadPuertas = cantidadPuertas;
    }

    public void setIdVehiculo(int idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public int getIdVehiculo() {
        return idVehiculo;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    public String getPatente() {
        return patente;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }    
}
