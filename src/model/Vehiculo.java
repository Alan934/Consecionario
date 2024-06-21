package model;

public class Vehiculo {
    private String marca, color, modelo, patente, cantidadPuertas;
    private int rodado;
    private double precio;

    public Vehiculo(String marca, String color, String modelo, String patente, String cantidadPuertas, int rodado, double precio) {
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.patente = patente;
        this.cantidadPuertas = cantidadPuertas;
        this.rodado = rodado;
        this.precio = precio;
    }

    public String getMarca() {
        return marca;
    }

    public String getColor() {
        return color;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPatente() {
        return patente;
    }

    public String getCantidadPuertas() {
        return cantidadPuertas;
    }

    public int getRodado() {
        return rodado;
    }

    public double getPrecio() {
        return precio;
    }    
}
