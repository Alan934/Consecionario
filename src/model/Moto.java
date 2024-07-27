package model;

public class Moto extends Vehiculo{
    private String patente, tipoMoto;

    public Moto(String patente, String tipoMoto , String marca, String color, String modelo, int rodado, double precio, String tipo) {
        super(marca, color, modelo, rodado, precio, tipo);
        this.patente = patente;
        this.tipoMoto = tipoMoto;
    }

    public String getTipoMoto() {
        return tipoMoto;
    }
    
    public String getPatente() {
        return patente;
    }    
}
