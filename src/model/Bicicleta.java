package model;

public class Bicicleta extends Vehiculo{
    private String tipoBici;
    private int idVehiculo;

    public Bicicleta(int idVehiculo, String tipoBici, String marca, String color, String modelo, int rodado, double precio, String tipo) {
        super(marca, color, modelo, rodado, precio, tipo);
        this.tipoBici = tipoBici;
        this.idVehiculo = idVehiculo;
    }

    public Bicicleta(String tipoBici, String marca, String color, String modelo, int rodado, double precio, String tipo) {
        super(marca, color, modelo, rodado, precio, tipo);
        this.tipoBici = tipoBici;
    }

    public String getTipoBici() {
        return tipoBici;
    }    
}
