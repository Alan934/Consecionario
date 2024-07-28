package controller;

import controller.VehiculoDAO;
import model.Auto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class AutoDAO {
    private Connection connection;
    private VehiculoDAO vehiculoDAO;

    public AutoDAO(Connection connection) {
        this.connection = connection;
        this.vehiculoDAO = new VehiculoDAO(connection);
    }
    
    public void insertarAuto(Auto auto) throws SQLException{
        int autoId = vehiculoDAO.insertarVehiculo(auto, "Auto");
        String query = "INSERT INTO auto (idVehiculo, patente, cantidadPuertas) VALUES (?, ?, ?)";
        try(PreparedStatement stmt = connection.prepareStatement(query)){
            stmt.setInt(1, autoId);
            stmt.setString(2, auto.getPatente());
            stmt.setInt(3, auto.getCantidadPuertas());
            stmt.executeUpdate();
        }
    }
    
    public void actualizarAuto(Auto auto) throws SQLException {
        vehiculoDAO.actualizarVehiculo(auto);
        String query = "UPDATE Auto SET patente = ?, cantidadPuertas = ? WHERE idVehiculo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, auto.getPatente());
            stmt.setInt(2, auto.getCantidadPuertas());
            stmt.setInt(3, auto.getId());
            stmt.executeUpdate();
        }
    }
    
    public void eliminarAuto(int autoId) throws SQLException {
        String query = "DELETE FROM auto WHERE idVehiculo = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, autoId);
            stmt.executeUpdate();
        }
    }

}
