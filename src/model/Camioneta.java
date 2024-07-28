package model;

public class Camioneta extends Vehiculo{
    private String patente; 
    private Double carga;
    private int idVehiculo;

    public Camioneta(int idVehiculo, String patente, Double carga, String marca, String color, String modelo, int rodado, double precio, String tipo) {
        super(marca, color, modelo, rodado, precio, tipo);
        this.patente = patente;
        this.carga = carga;
        this.idVehiculo = idVehiculo;
    }
    
    public Camioneta(String patente, Double carga, String marca, String color, String modelo, int rodado, double precio, String tipo) {
        super(marca, color, modelo, rodado, precio, tipo);
        this.patente = patente;
        this.carga = carga;
    }

    public String getPatente() {
        return patente;
    }

    public Double getCarga() {
        return carga;
    }   
}
