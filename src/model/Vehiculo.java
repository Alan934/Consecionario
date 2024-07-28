package model;

public class Vehiculo {
    private String marca, color, modelo, tipo, estado;
    private int id, rodado, idCliente;
    private double precio;
    
    public Vehiculo(){
        
    }
    
    public Vehiculo(String marca, String color, String modelo, int rodado, double precio, String tipo) {
        this.marca = marca;
        this.color = color;
        this.modelo = modelo;
        this.rodado = rodado;
        this.precio = precio;
        this.tipo = tipo;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setRodado(int rodado) {
        this.rodado = rodado;
    }

    public void setPrecio(double precio) {
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

    public int getRodado() {
        return rodado;
    }

    public double getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }    
}
