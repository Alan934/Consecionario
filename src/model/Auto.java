package model;

public class Auto extends Vehiculo{
    private String patente, cantidadPuertas;
    
    public Auto(){
        
    }
    
    public Auto(String patente, String cantidadPuertas, String marca, String color, String modelo, int rodado, double precio, String tipo) {
        super(marca, color, modelo, rodado, precio, tipo);
        this.patente = patente;
        this.cantidadPuertas = cantidadPuertas;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public void setCantidadPuertas(String cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }

    public String getPatente() {
        return patente;
    }

    public String getCantidadPuertas() {
        return cantidadPuertas;
    }    
}
