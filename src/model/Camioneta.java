package model;

public class Camioneta extends Vehiculo{
    
    private String patente, carga;

    public Camioneta(String patente, String carga, String marca, String color, String modelo, int rodado, double precio, String tipo) {
        super(marca, color, modelo, rodado, precio, tipo);
        this.patente = patente;
        this.carga = carga;
    }

    public String getPatente() {
        return patente;
    }

    public String getCarga() {
        return carga;
    }
    
    
}
